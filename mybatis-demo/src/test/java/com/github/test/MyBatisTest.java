package com.github.test;

import com.github.mapper.BrandMapper;
import com.github.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {
    /**
     * 测试查询所有
     */
    @Test
    public void selectAll() throws IOException {
        // 1. 获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = brandMapper.selectAll();

        System.out.println(brands);

        sqlSession.close();
    }

    /**
     * 根据ID查询信息
     */
    @Test
    public void selectById() throws IOException {
        // 1. 获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = brandMapper.selectById(1);

        System.out.println(brand);

        sqlSession.close();
    }

    /**
     * 根据给定的信息查询
     */
    @Test
    public void selectByCondition() throws IOException {
        int status = 1;
        String companyName = "";
        String brandName = "";

        // 处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);

        // 1. 获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = brandMapper.selectByCondition(brand);

        System.out.println(brands);

        sqlSession.close();
    }

    /**
     * 根据给定的列名查询信息
     */
    @Test
    public void selectByConditionSingle() throws IOException {
        int status = 1;
        String companyName = "";
        String brandName = "";

        // 处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);

        // 1. 获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = brandMapper.selectByConditionSingle(brand);

        System.out.println(brands);

        sqlSession.close();
    }

    /**
     * 添加信息
     */
    @Test
    public void add() throws IOException {
        Brand brand = new Brand();
        brand.setBrandName("张三加工厂");
        brand.setCompanyName("张三加工厂有限公司");
        brand.setOrdered(100);
        brand.setDescription("张三加工成基地");
        brand.setStatus(1);

        // 1. 获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.add(brand);

        // 提交事务
        sqlSession.commit();

        System.out.println(brand.getId());

        sqlSession.close();
    }


    /**
     * 修改信息
     */
    @Test
    public void update() throws IOException {
        Brand brand = new Brand();
        brand.setId(5);
        brand.setBrandName("张大炮加工厂");
        brand.setCompanyName("张大炮加工厂有限公司");
        brand.setOrdered(1020);
        brand.setDescription("张大炮加工成基地");
        brand.setStatus(1);

        // 1. 获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.update(brand);

        // 提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    /**
     * 删除数据
     */
    @Test
    public void deleteById() throws IOException {

        // 1. 获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

//        brandMapper.deleteById(6);
        Map<String, Integer> map = new HashMap<>();
        map.put("id", 1);
        brandMapper.deleteById(map);
        // 提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    /**
     * 批量删除
     */
    @Test
    public void deleteByIds() throws IOException {

        int[] ids = new int[]{5, 7};

        // 1. 获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.deleteByIds(ids);

        // 提交事务
        sqlSession.commit();

        sqlSession.close();
    }
}
