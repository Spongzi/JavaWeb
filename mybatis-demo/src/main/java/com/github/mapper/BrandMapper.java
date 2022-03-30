package com.github.mapper;

import com.github.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    List<Brand> selectAll();
    Brand selectById(int id);
    // 使用param注解
//    List<Brand> selectByCondition(@Param("status")int status,
//                                  @Param("companyName")String companyName,
//                                  @Param("brandName")String brandName);

    // 使用brand
    List<Brand> selectByCondition(Brand brand);

    List<Brand> selectByConditionSingle(Brand brand);

    void add(Brand brand);

    void update(Brand brand);

    void deleteById(int id);

    void deleteById(Map<String, Integer> map);

    void deleteByIds(@Param("ids")int[] ids);
}
