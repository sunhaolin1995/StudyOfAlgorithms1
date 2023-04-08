package com.example.hello.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author 孙浩林
 * @date: 4/8/23 15:00
 */
public class No1125SmallestSufficientTeam {

    public static void main(String[] args) {
        String[] req_skills = {"java","nodejs","reactjs"};
        List<List<String>> people = new ArrayList<>();
        List<String> people1 = new ArrayList<>();
        people1.add("java");
        List<String> people2 = new ArrayList<>();
        people2.add("nodejs");
        List<String> people3 = new ArrayList<>();
        people3.add("nodejs");
        people3.add("reactjs");
        people.add(people1);
        people.add(people2);
        people.add(people3);
        int[] ints = smallestSufficientTeam(req_skills, people);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

    }

    public static int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = req_skills.length, m = people.size();
        HashMap<String, Integer> skill_index = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            skill_index.put(req_skills[i], i);
        }
        List<Integer>[] dp = new List[1 << n];
        dp[0] = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            int cur_skill = 0;
            for (String s : people.get(i)) {
                cur_skill |= 1 << skill_index.get(s);
            }
            for (int prev = 0; prev < dp.length; ++prev) {
                if (dp[prev] == null) {
                    continue;
                }
                int comb = prev | cur_skill;
                if (dp[comb] == null || dp[prev].size() + 1 < dp[comb].size()) {
                    dp[comb] = new ArrayList<>(dp[prev]);
                    dp[comb].add(i);
                }
            }
        }
        return dp[(1 << n) - 1].stream().mapToInt(i -> i).toArray();

    }


}
