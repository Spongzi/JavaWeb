package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {
    /**
     * 查询所有
     * @return 查询到的所有结果
     */
    /*@Select("select * from tb_brand;")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();
*/
    /**
     * 添加数据
     * @param brand 要添加数据的对象
     */
    @Insert("insert into tb_brand (brand_name, company_name, ordered, description, status) values (#{brandName}, #{companyName}, #{ordered}, #{description},#{status});")
    void add(Brand brand);

    /**
     * 根据id删除
     * @param id 要删除的id
     */
    @Delete("delete from tb_brand where id = #{id};")
    void deleteById(Integer id);

    /**
     * 根据id查询
     * @param id 序列id
     * @return 返回查询到的结果
     */
    @Select("select * from tb_brand where id = #{id};")
    Brand selectById(Integer id);

    /**
     * 修改数据内容
     * @param brand 修改的后的对象
     */
    @Update("update tb_brand set brand_name = #{brandName}, company_name = #{companyName}, ordered = #{ordered}, description = #{description}, status = #{status} where id = #{id};")
    void modifyId(Brand brand);

    /**
     * 多选删除数据
     * @param ids ids数组
     */
    void deleteByIds(@Param("ids") Integer[] ids);

    /**
     * 分页查询
     * @param begin 开始的编号
     * @param size 查询的长度
     * @return 查询到的结果数组
    @Select("select * from tb_brand limit #{begin}, #{size};")
    @ResultMap("brandResultMap")
    List<Brand> selectByPage(@Param("begin") int begin, @Param("size") int size);

    *//**
     * 查询总记录数
     * @return 返回一共有多少个
     */
    /*
    @Select("select count(*) from tb_brand;")
    int selectTotalCount();*/

    /**
     * 条件查询
     */
    List<Brand> selectByCondition(@Param("begin") int begin, @Param("size") int size, @Param("brand") Brand brand);

    /**
     * 查询记录数
     * @return 返回一共有多少个
     */
    int selectCountByCondition(Brand brand);
}
