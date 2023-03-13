package com.example.hello.leetcode;

public class No2383MinNumberOfHours {

    public static void main(String[] args) {
        int initialEnergy = 5, initialExperience = 3;
        int[] energy = {1,4,3,2}, experience = {2,6,3,1};
        System.out.println(minNumberOfHours(initialEnergy,initialExperience,energy,experience));
    }

    public static int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int s = 0;
        for (int x : energy) {
            s += x;
        }
        int ans = Math.max(0, s - initialEnergy + 1);
        for (int x : experience) {
            if (initialExperience <= x) {
                ans += x - initialExperience + 1;
                initialExperience = x + 1;
            }
            initialExperience += x;
        }
        return ans;

    }

}
