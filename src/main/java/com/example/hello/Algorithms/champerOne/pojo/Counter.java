package com.example.hello.Algorithms.champerOne.pojo;

/**
 * @author 孙浩林
 * @date 2021/12/27 20:23 23
 */
public class Counter {

    private String id;

    public Counter(String id) {
        this.id = id;
    }

    public void increment(){

    }

    public int tally(){
        return -1;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "id='" + id + '\'' +
                '}';
    }
}
