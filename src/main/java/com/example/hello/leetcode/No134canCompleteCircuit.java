package com.example.hello.leetcode;

/**
 * @author 孙浩林
 * @date: 9/12/23 11:17
 */
public class No134canCompleteCircuit {

    public static void main(String[] args) {
        int[] gas = {2,3,4};
        int[] cost = {3,4,3};
        System.out.println(canCompleteCircuit(gas,cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, totalGas = 0, currentGas = 0;

        int length = gas.length;
        for (int i = 0; i < length; i++) {

            currentGas = currentGas + (gas[i]-cost[i]);
            if (currentGas<0){
                start = i+1;
                currentGas =0;
            }
            totalGas = (gas[i]-cost[i])+totalGas;
        }
        if (totalGas<0){
            return -1;
        }
        return start;
    }

}
