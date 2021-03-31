package com.example.mapper;

import com.example.dto.DscOrderStatus;
import com.example.dto.DscOrderStatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DscOrderStatusMapper {
    long countByExample(DscOrderStatusExample example);

    int deleteByExample(DscOrderStatusExample example);

    int insert(DscOrderStatus record);

    int insertSelective(DscOrderStatus record);

    List<DscOrderStatus> selectByExample(DscOrderStatusExample example);

    int updateByExampleSelective(@Param("record") DscOrderStatus record, @Param("example") DscOrderStatusExample example);

    int updateByExample(@Param("record") DscOrderStatus record, @Param("example") DscOrderStatusExample example);
}