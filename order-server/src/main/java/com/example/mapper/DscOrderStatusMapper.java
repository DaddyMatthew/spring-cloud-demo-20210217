package com.example.mapper;

import com.example.dto.DscOrderStatus;
import com.example.dto.DscOrderStatusExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DscOrderStatusMapper {
    long countByExample(DscOrderStatusExample example);

    int deleteByExample(DscOrderStatusExample example);

    int insert(DscOrderStatus record);

    int insertSelective(DscOrderStatus record);

    List<DscOrderStatus> selectByExample(DscOrderStatusExample example);

    int updateByExampleSelective(@Param("record") DscOrderStatus record, @Param("example") DscOrderStatusExample example);

    int updateByExample(@Param("record") DscOrderStatus record, @Param("example") DscOrderStatusExample example);
}