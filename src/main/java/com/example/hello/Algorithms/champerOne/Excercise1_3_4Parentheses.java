package com.example.hello.Algorithms.champerOne;

import edu.princeton.cs.algs4.Stack;

/**
 * @author 孙浩林
 * @date: 2022/10/12 22:14
 */
public class Excercise1_3_4Parentheses {
    public static void main(String[] args) {
     String s ="[()]{}()";
        System.out.println(Parentheses(s));

    }

    public static boolean Parentheses(String s){
        char[] chars = s.toCharArray();
        Stack<Character>  a= new Stack<Character>();
        for (int i = 0; i <chars.length ; i++) {
            if (chars[i]=='[' || chars[i] == '(' || chars[i] == '{'){
                a.push(chars[i]);
            }else if (chars[i] == ']'){
                if (a.pop() != '['){
                    return false;
                }
            }else if (chars[i] == '}'){
                if (a.pop() != '{'){
                    return false;
                }
            }else if (chars[i] == ')'){
                if (a.pop() != '('){
                    return false;
                }
            }
        }
        return true;
    }

}
