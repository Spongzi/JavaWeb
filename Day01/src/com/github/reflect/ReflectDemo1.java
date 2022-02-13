package com.github.reflect;

import com.github.domain.Person;

public class ReflectDemo1 {
    // 获取Class的三种方式:
    /*
    Java代码处于第一阶段的时候：Class.forName("全类名");将字节码文件放入内存，返回Class对象
    Java代码处于第二阶段的时候；类名.class;通过类名获取Class对象
    Java代码处于第三阶段的时候：对象.getClass();通过对象的方法获取，getClass()是在Object对象中定义的
    */
    public static void main(String[] args) throws ClassNotFoundException {
        // 1. Class.forName("全类名")
        Class<?> cls1 = Class.forName("com.github.domain.Person");
        System.out.println(cls1);
        // 2. 类名.class
        Class<Person> cls2 = Person.class;
        System.out.println(cls2);
        // 3.对象.getClass()
        Person p = new Person();
        Class<? extends Person> cls3 = p.getClass();
        System.out.println(cls3);

        // 验证三个对象是否一样--> 使用 ==
        System.out.println(cls1 == cls2);
        System.out.println(cls1 == cls3);
    }
}
