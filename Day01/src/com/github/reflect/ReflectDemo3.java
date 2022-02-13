package com.github.reflect;

import com.github.domain.Person;

import java.lang.reflect.Field;

public class ReflectDemo3 {
    /**
     * 1. 获取成员变量们
     *        ```java
     *           Filed[] getFileds()
     *           Filed getFiled(String name)
     *           Filed[] getDeclaredFields()
     *           Filed getDeclaredField(String name)
     *      2. 获取构造方法们
     *         ```java
     *           Constructor<?>[] getConstructors()
     *           Constructor<?> getConstructor(类<?>... parmeterTypes)
     *           Constructor<?>[] getDeclaredConstructors()
     *           Constructor<?> getDeclaredConstructor(类<?>... parmeterTypes)
     *      3. 获取成员方法们
     *         ```java
     *           Method[] getMethods()
     *           Method getMethod(类<?>... parmeterTypes)
     *           Method[] getDeclaredMethods()
     *           Method getDeclaredMethod(类<?>... parmeterTypes)
     *      4. 获取类名
     *         ```java
     *             String getName()
     */
    public static void main(String[] args) throws Exception {
        // 1. 获取person的class对象
        Class<Person> personClass = Person.class;
        // 获取成员变量
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        Field a = personClass.getField("a");
        // 操作获取成员变量a的值
        Person person = new Person();
        Object value = a.get(person);
        System.out.println(value);
        a.set(person, "张三");
        value = a.get(person);
        System.out.println(value);
        System.out.println("===============");
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        // 忽略访问权限
        Field d = personClass.getDeclaredField("d");
        d.setAccessible(true);
        Object o = d.get(person);
        System.out.println(o);
    }
}
