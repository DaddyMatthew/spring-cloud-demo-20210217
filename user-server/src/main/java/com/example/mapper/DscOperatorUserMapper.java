package com.example.mapper;

import com.example.dto.DscOperatorUser;
import com.example.dto.DscOperatorUserExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DscOperatorUserMapper {
    long countByExample(DscOperatorUserExample example);

    int deleteByExample(DscOperatorUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DscOperatorUser record);

    int insertSelective(DscOperatorUser record);

    List<DscOperatorUser> selectByExample(DscOperatorUserExample example);

    DscOperatorUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DscOperatorUser record, @Param("example") DscOperatorUserExample example);

    int updateByExample(@Param("record") DscOperatorUser record, @Param("example") DscOperatorUserExample example);

    int updateByPrimaryKeySelective(DscOperatorUser record);

    int updateByPrimaryKey(DscOperatorUser record);
}