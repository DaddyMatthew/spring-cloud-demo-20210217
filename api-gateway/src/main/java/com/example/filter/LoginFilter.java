package com.example.filter;

import com.example.utils.JwtVerifier;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

@Component
@Slf4j
public class LoginFilter extends ZuulFilter {

    // 过滤器类型，前置过滤器
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    // 过滤器顺序
    @Override
    public int filterOrder() {
        return 4;
    }

    // 过滤器是否生效
    @Override
    public boolean shouldFilter() {
        RequestContext _ctx = RequestContext.getCurrentContext();
        HttpServletRequest _request = _ctx.getRequest();
        String _url = _request.getRequestURL().toString();
        log.info("@@@@ request url is [{}]", _url);
        if ("".equalsIgnoreCase(_url)) {
            return true;
        }
        return false;
    }

    // 业务逻辑
    @Override
    public Object run() throws ZuulException {
        log.info("拦截了");

        RequestContext _ctx = RequestContext.getCurrentContext();
        HttpServletRequest _request = _ctx.getRequest();
        String _token = _request.getHeader("token");
        if (_token == null) {
            _ctx.setSendZuulResponse(false);
            _ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        } else {
            JwtVerifier.verifyToken(_token);
        }
        return null;
    }
}
