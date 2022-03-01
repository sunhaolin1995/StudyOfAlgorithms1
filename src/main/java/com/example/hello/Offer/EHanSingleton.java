package com.example.hello.Offer;

/**
 * @author 孙浩林
 * @date 2022/3/1 22:43 43
 */
public class EHanSingleton {
    private static EHanSingleton instance=null;
    static {
        instance =new EHanSingleton();
    }

    private EHanSingleton(){

    }

    public static EHanSingleton getInstance(){
        return instance;
    }

}
