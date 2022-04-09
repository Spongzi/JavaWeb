package com.itheima.service;

import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;

import java.util.List;

public interface BrandService {
    /**
     * 查询所有的数据
     */
//    List<Brand> selectAll();

    /**
     * 添加数据
     */
    void add(Brand brand);

    /**
     * 通过id来删除数据
     */
    void deleteById(Integer id);

    /**
     * 根据Id查找对应的brand
     */
    Brand selectById(Integer id);

    /**
     * 通过id来修改数据
     */
    void modifyById(Brand brand);

    /**
     * 根据ID批量删除
     */
    void deleteByIds(Integer[] ids);

    /**
     * 分页查询
     *
     * @param currentPage 当前页码
     * @param pageSize    每页展示条数
     * @return 查询到的结果对象
     */
//    PageBean<Brand> selectByPage(int currentPage, int pageSize);

    /**
     * 根据条件查询
     * @param currentPage 当前页码
     * @param pageSize 每页展示条数
     * @param brand 要查询的条件
     * @return 返回的结果
     */
    PageBean<Brand> selectByCondition(int currentPage, int pageSize, Brand brand);
}
