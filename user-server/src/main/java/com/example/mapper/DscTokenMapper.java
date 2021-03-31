package com.example.mapper;

import com.example.dto.DscToken;
import com.example.dto.DscTokenExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DscTokenMapper {
    long countByExample(DscTokenExample example);

    int deleteByExample(DscTokenExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(DscToken record);

    int insertSelective(DscToken record);

    List<DscToken> selectByExample(DscTokenExample example);

    DscToken selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") DscToken record, @Param("example") DscTokenExample example);

    int updateByExample(@Param("record") DscToken record, @Param("example") DscTokenExample example);

    int updateByPrimaryKeySelective(DscToken record);

    int updateByPrimaryKey(DscToken record);
}