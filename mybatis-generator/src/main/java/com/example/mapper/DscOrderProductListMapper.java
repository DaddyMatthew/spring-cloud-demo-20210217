package com.example.mapper;

import com.example.dto.DscOrderProductList;
import com.example.dto.DscOrderProductListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DscOrderProductListMapper {
    long countByExample(DscOrderProductListExample example);

    int deleteByExample(DscOrderProductListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DscOrderProductList record);

    int insertSelective(DscOrderProductList record);

    List<DscOrderProductList> selectByExample(DscOrderProductListExample example);

    DscOrderProductList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DscOrderProductList record, @Param("example") DscOrderProductListExample example);

    int updateByExample(@Param("record") DscOrderProductList record, @Param("example") DscOrderProductListExample example);

    int updateByPrimaryKeySelective(DscOrderProductList record);

    int updateByPrimaryKey(DscOrderProductList record);
}