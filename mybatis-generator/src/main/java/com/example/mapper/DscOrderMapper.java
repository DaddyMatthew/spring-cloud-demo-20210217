package com.example.mapper;

import com.example.dto.DscOrder;
import com.example.dto.DscOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DscOrderMapper {
    long countByExample(DscOrderExample example);

    int deleteByExample(DscOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DscOrder record);

    int insertSelective(DscOrder record);

    List<DscOrder> selectByExample(DscOrderExample example);

    DscOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DscOrder record, @Param("example") DscOrderExample example);

    int updateByExample(@Param("record") DscOrder record, @Param("example") DscOrderExample example);

    int updateByPrimaryKeySelective(DscOrder record);

    int updateByPrimaryKey(DscOrder record);
}