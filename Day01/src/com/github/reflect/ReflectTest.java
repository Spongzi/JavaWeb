package com.github.reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // 加载配置文件
        Properties properties = new Properties();
        // 转化为一个集合
        // 获取class目录下的配置文件目录
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("pro.properties");
        properties.load(is);
        // 2. 获取定义的内容
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");
        // 加载该类进内存
        Class<?> cls = Class.forName(className);
        // 创建对象
        Object obj = cls.newInstance();
        // 获取方法
        Method method = cls.getMethod(methodName);
        // 执行方法
        method.invoke(obj);
    }
}
