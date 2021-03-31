package com.example.service.impl;

import com.example.dto.DscOrder;
import com.example.dto.DscOrderExample;
import com.example.mapper.DscOrderMapper;
import com.example.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private DscOrderMapper mapper;

    @Override
    public DscOrder queryOrderByNo(String orderNo) {
        DscOrderExample example = new DscOrderExample();
        example.createCriteria().andOrderNoEqualTo(orderNo);
        List<DscOrder> orders = mapper.selectByExample(example);
        return orders.get(0);
    }
}
