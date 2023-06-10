package com.chenfei.cfgo.test.reflect;

/**
 * @author 464498258@qq.com
 * @version 1.0.0
 * @descriptions <TODO description class purpose>
 * @create 2022/11/5 22:55
 */
public class ReflectTest {

    public static void main(String[] args) {
        Class<Student> studentClass = Student.class;
        Class<? super Student> superclass = studentClass.getSuperclass();
    }

}
