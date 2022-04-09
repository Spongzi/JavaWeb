package com.itheima.service.impl;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import com.itheima.service.BrandService;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandServiceImpl implements BrandService {
    // 创建sqlSessionFactory
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /*@Override
    public List<Brand> selectAll() {
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 获取mapper对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        // 执行方法
        List<Brand> brands = mapper.selectAll();

        // 释放资源
        sqlSession.close();
        return brands;
    }*/

    @Override
    public void add(Brand brand) {
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 获取mapper对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        // 执行方法
        mapper.add(brand);

        // 提交事务
        sqlSession.commit();

        // 释放资源
        sqlSession.close();
    }

    @Override
    public void deleteById(Integer id) {
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 获取mapper对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        // 执行方法
        mapper.deleteById(id);

        // 提交事务
        sqlSession.commit();

        // 释放资源
        sqlSession.close();
    }

    @Override
    public Brand selectById(Integer id) {
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 获取mapper对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        // 执行方法
        Brand brand = mapper.selectById(id);

        // 释放资源
        sqlSession.close();
        return brand;
    }

    @Override
    public void modifyById(Brand brand) {
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 获取mapper对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        // 执行方法
        mapper.modifyId(brand);

        // 提交事务
        sqlSession.commit();

        // 释放资源
        sqlSession.close();
    }

    @Override
    public void deleteByIds(Integer[] ids) {
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 获取mapper对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        // 执行方法
        mapper.deleteByIds(ids);

        // 提交事务
        sqlSession.commit();

        // 释放资源
        sqlSession.close();
    }

    /*@Override
    public PageBean<Brand> selectByPage(int currentPage, int pageSize) {
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 获取mapper对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        // 计算开始索引
        int begin = (currentPage - 1) * pageSize;

        // 执行方法
        List<Brand> rows = mapper.selectByPage(begin, pageSize);

        // 查询总记录数
        int totalCount = mapper.selectTotalCount();

        // 封装pageBean对象
        PageBean<Brand> brandPageBean = new PageBean<>();
        brandPageBean.setRows(rows);
        brandPageBean.setTotalCount(totalCount);

        // 释放资源
        sqlSession.close();
        return brandPageBean;
    }*/

    @Override
    public PageBean<Brand> selectByCondition(int currentPage, int pageSize, Brand brand) {
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 获取mapper对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        // 计算开始索引
        int begin = (currentPage - 1) * pageSize;

        // 执行方法
        List<Brand> rows = mapper.selectByCondition(begin, pageSize, brand);

        // 查询总记录数
        int totalCount = mapper.selectCountByCondition(brand);

        // 封装pageBean对象
        PageBean<Brand> brandPageBean = new PageBean<>();
        brandPageBean.setRows(rows);
        brandPageBean.setTotalCount(totalCount);

        // 释放资源
        sqlSession.close();
        return brandPageBean;
    }
}
