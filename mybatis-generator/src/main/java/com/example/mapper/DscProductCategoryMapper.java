package com.example.mapper;

import com.example.dto.DscProductCategory;
import com.example.dto.DscProductCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DscProductCategoryMapper {
    long countByExample(DscProductCategoryExample example);

    int deleteByExample(DscProductCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DscProductCategory record);

    int insertSelective(DscProductCategory record);

    List<DscProductCategory> selectByExample(DscProductCategoryExample example);

    DscProductCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DscProductCategory record, @Param("example") DscProductCategoryExample example);

    int updateByExample(@Param("record") DscProductCategory record, @Param("example") DscProductCategoryExample example);

    int updateByPrimaryKeySelective(DscProductCategory record);

    int updateByPrimaryKey(DscProductCategory record);
}