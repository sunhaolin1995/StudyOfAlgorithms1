package com.example.hello.leetcode;

import java.util.HashMap;
import java.util.Map;

public class No466getMaxRepetitons {

    public static void main(String[] args) {
        String s1 = "acb";
        int n1 = 4;
        String s2 = "ab";
        int n2 = 2;
        int maxRepetitions = getMaxRepetitions(s1, n1, s2, n2);

    }

    /***
     * https://leetcode.cn/problems/count-the-repetitions/solutions/209271/zhao-xun-huan-zuo-you-hua-0ms-2mb-pao-shuang-bai-b
     * 题解链接
     * @param s1
     * @param n1
     * @param s2
     * @param n2
     * @return
     */

    public static int getMaxRepetitions(String s1, int n1, String s2, int n2) {

        int ans=0;
        int index1=0,index2=0;
        int len1=s1.length(),len2=s2.length();
        if(len2*n2>len1*n1){
            return ans;
        }
        Map<Integer,int[]> record=new HashMap();
        while(index1/len1<n1){
            // 注意：是在sa的末尾寻找循环体，由题解可知，如bdadc循环体
            if(index1%len1==len1-1){
                int[]nums=record.get(index2%len2);
                // 出现循环
                if(nums!=null){
                    int preIndex1=nums[0],preIndex2=nums[1];
                    // 一次循环对应Sa的数量
                    int cycleLen=index1/len1-preIndex1/len1;
                    // 剩余Sa循环体的数量，注意index1/len1是从0开始算起的
                    int cycleNum=(n1-1-index1/len1)/cycleLen;
                    // 循环体中包含Sb的数量
                    int cycle2Num=index2/len2-preIndex2/len2;

                    // 更新指针
                    // 将ra指向推进到对应位置
                    index1+=cycleNum*cycleLen*len1;
                    // 累加推进过程中所出现的答案数量
                    ans+=cycle2Num*cycleNum;
                } else {
                    record.put(index2%len2,new int[]{index1,index2});
                }
            }
            // 移动sb指针
            if(s1.charAt(index1%len1)==s2.charAt(index2%len2)){
                if(index2%len2==len2-1){
                    ans+=1;
                }
                index2+=1;
            }
            // 移动sa指针
            index1+=1;
        }
        return ans/n2;

    }


}
