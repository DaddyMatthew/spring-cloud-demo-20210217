package com.example.mapper;

import com.example.dto.DscUserOrderList;
import com.example.dto.DscUserOrderListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DscUserOrderListMapper {
    long countByExample(DscUserOrderListExample example);

    int deleteByExample(DscUserOrderListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DscUserOrderList record);

    int insertSelective(DscUserOrderList record);

    List<DscUserOrderList> selectByExample(DscUserOrderListExample example);

    DscUserOrderList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DscUserOrderList record, @Param("example") DscUserOrderListExample example);

    int updateByExample(@Param("record") DscUserOrderList record, @Param("example") DscUserOrderListExample example);

    int updateByPrimaryKeySelective(DscUserOrderList record);

    int updateByPrimaryKey(DscUserOrderList record);
}