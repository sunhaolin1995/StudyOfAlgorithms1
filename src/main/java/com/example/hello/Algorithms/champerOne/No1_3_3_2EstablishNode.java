package com.example.hello.Algorithms.champerOne;

/**
 * @author 孙浩林
 * @date: 2022/10/10 20:49
 */
public class No1_3_3_2EstablishNode {

    public static void main(String[] args) {
        Node first = new Node();
        Node second = new Node();
        Node third = new Node();

        first.item="to";
        second.item="be";
        third.item="or";

        first.next = second;
        second.next = third;


    }

}
