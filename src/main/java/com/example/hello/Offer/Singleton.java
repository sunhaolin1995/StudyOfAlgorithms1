package com.example.hello.Offer;

/**
 * @author 孙浩林
 * @date 2022/3/1 22:34 34
 */

/***
 * 饿汉式，类加载时创建实例
 * 优点：类加载时创建了一次实例，避免了多线程同步问题
 * 缺点：即使单例没被使用也会创建，浪费内存
 */
public class Singleton {

    private static Singleton instance =new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }



}
