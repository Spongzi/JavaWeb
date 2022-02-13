package com.github.junit;

public class CalculatorTest {
    public static void main(String[] args) {
        // 创建对象， 调用方法
        Calculator c = new Calculator();
        int result = c.add(1, 2);
        System.out.println("加法结果" + result);
    }
}
