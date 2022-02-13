package com.github.test;

import com.github.junit.Calculator;
import org.junit.After;
import org.junit.Before;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {
    // 创建计算机对象
    Calculator c = new Calculator();

    // @Before 初始化方法, 用于资源的申请，所有的测试方法在实行之前，都会执行该方法
    @Before
    public void init() {
        System.out.println("init");
    }

    // @After 释放资源的方法， 在所有的测试方法执行完之后， 都会自动执行该方法
    @After
    public void close() {
        System.out.println("close");
    }

    // 测试add方法
    @Test
    public void testAdd() {
        // System.out.println("我被执行了！");
        // 调用add方法
        int result = c.add(1, 2);
        System.out.println(result);
        // 一般在测试题内进行断言
        Assert.assertEquals(3, result);
    }

    @Test
    public void testSub() {
        int result = c.sub(1, 1);
        System.out.println(result);
    }

    // 红色代表测试失败， 绿色代表成功
}
