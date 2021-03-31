package com.example.mapper;

import com.example.dto.DscProductItem;
import com.example.dto.DscProductItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DscProductItemMapper {
    long countByExample(DscProductItemExample example);

    int deleteByExample(DscProductItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DscProductItem record);

    int insertSelective(DscProductItem record);

    List<DscProductItem> selectByExample(DscProductItemExample example);

    DscProductItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DscProductItem record, @Param("example") DscProductItemExample example);

    int updateByExample(@Param("record") DscProductItem record, @Param("example") DscProductItemExample example);

    int updateByPrimaryKeySelective(DscProductItem record);

    int updateByPrimaryKey(DscProductItem record);
}