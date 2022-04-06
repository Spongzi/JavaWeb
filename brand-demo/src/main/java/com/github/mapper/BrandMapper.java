package com.github.mapper;

import com.github.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {
    /*
    * 查询所有的数据
    */
    @Select("select * from tb_brand;")
    @ResultMap("brandResultMap")
    List<Brand> select();

    @Insert("insert into tb_brand values (null, #{brandName}, #{companyName}, #{ordered}, #{description}, #{status});")
    void add(Brand brand);

    /**
     * 根据ID查询
     */
    @Select("select * from tb_brand where id = #{id}")
    @ResultMap("brandResultMap")
    Brand selectById(Integer id);

    /**
     * 更新数据
     * @param brand
     */
    @Update("update tb_brand set brand_name=#{brandName},company_name=#{companyName},ordered=#{ordered},description=#{description},status=#{status} where id = #{id}")
    void update(Brand brand);

    /**
     * 删除数据
     */
    @Delete("delete from tb_brand where id = #{id};")
    void deleteById(Integer id);
}
