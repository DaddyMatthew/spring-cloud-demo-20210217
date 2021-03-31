package com.example.service;

import com.example.dto.DscOrder;

public interface IOrderService {

    DscOrder queryOrderByNo(String orderNo);
}
