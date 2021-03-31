package com.example.service.impl;

import com.example.dto.DscOperatorUser;
import com.example.dto.DscOperatorUserExample;
import com.example.dto.DscToken;
import com.example.dto.DscTokenExample;
import com.example.exception.DscException;
import com.example.mapper.DscOperatorUserMapper;
import com.example.mapper.DscTokenMapper;
import com.example.service.IUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private DscOperatorUserMapper operatorUserMapper;
    @Autowired
    private DscTokenMapper tokenMapper;

    @Override
    public void insertUser(DscOperatorUser dto) {
        dto.setPassword(DigestUtils.md5Hex(dto.getPassword()));
        dto.setCreatedDate(new Date());
        dto.setUpdatedDate(new Date());
        operatorUserMapper.insertSelective(dto);
    }

    @Override
    public DscOperatorUser queryUserByToken(DscToken dto) {
        DscTokenExample example = new DscTokenExample();
        example.createCriteria().andTokenEqualTo(dto.getToken()).andExpiredTimeGreaterThan(new Date());
        List<DscToken> tokens = tokenMapper.selectByExample(example);
        if (tokens.isEmpty()) {
            throw new DscException(403, "登录过期");
        }
        DscToken token = tokens.get(0);
        DscOperatorUser user = operatorUserMapper.selectByPrimaryKey(token.getUserId());
        user.setPassword(null);
        return user;
    }

    @Transactional
    @Override
    public DscOperatorUser login(DscOperatorUser dto) {
        DscOperatorUserExample operatorUserExample = new DscOperatorUserExample();
        operatorUserExample.createCriteria().andAccountEqualTo(dto.getAccount()).andPasswordEqualTo(dto.getPassword());
        List<DscOperatorUser> users = operatorUserMapper.selectByExample(operatorUserExample);
        if (!users.isEmpty()) {
            DscOperatorUser user = users.get(0);
            DscTokenExample tokenExample = new DscTokenExample();
            tokenExample.createCriteria().andUserIdEqualTo(user.getId());

            Date now = new Date();
            DscToken token = new DscToken();
            token.setUserId(user.getId());
            token.setToken(UUID.randomUUID().toString().replaceAll("-", ""));
            token.setExpiredTime(DateUtils.addHours(now, 2));
            token.setUpdatedDate(now);
            int i = tokenMapper.updateByExampleSelective(token, tokenExample);
            if (i < 1) {
                token.setCreatedDate(now);
                tokenMapper.insertSelective(token);
            }
            return user;
        } else {
            throw new DscException(403, "登录失败");
        }
    }
}
