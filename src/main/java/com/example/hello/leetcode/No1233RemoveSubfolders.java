package com.example.hello.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No1233RemoveSubfolders {

    public static void main(String[] args) {

    }

    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> ans = new ArrayList<String>();
        ans.add(folder[0]);
        for (int i = 1; i < folder.length; ++i) {

            int pre = ans.get(ans.size() - 1).length();
            if (!(pre < folder[i].length() && ans.get(ans.size() - 1).equals(folder[i].substring(0, pre)) && folder[i].charAt(pre) == '/')) {
                ans.add(folder[i]);

            }
        }
        return ans;
    }

}
