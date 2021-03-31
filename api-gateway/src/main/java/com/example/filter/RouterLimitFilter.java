package com.example.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

@Component
@Slf4j
public class RouterLimitFilter extends ZuulFilter {

    // 每秒获取10个令牌
    private static final RateLimiter RATE_LIMITER = RateLimiter.create(10);

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return -4;
    }

    @Override
    public boolean shouldFilter() {
        String _url = RequestContext.getCurrentContext().getRequest().getRequestURL().toString();
        log.info("@@@@ request url is [{}]", _url);
        if ("".equalsIgnoreCase(_url)) {
            return true;
        }
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext _ctx = RequestContext.getCurrentContext();
        if (!RATE_LIMITER.tryAcquire()) {
            _ctx.setSendZuulResponse(false);
            _ctx.setResponseStatusCode(HttpStatus.TOO_MANY_REQUESTS.value());
        }
        return null;
    }
}
