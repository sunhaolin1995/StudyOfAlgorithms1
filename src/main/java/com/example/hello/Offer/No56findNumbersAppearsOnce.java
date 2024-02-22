package com.example.hello.Offer;


public class No56findNumbersAppearsOnce {

    public static void main(String[] args) {
        int[] numbers ={1,2,3,3,2,9};
        int[] ints = FindNumsAppearOnce(numbers);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }


    public static int[] FindNumsAppearOnce(int[] nums) {
        //先将全部数进行异或运算，得出最终结果
        int temp = 0;
        for (int num : nums) {
            temp = temp ^ num;
        }
        //找到哪个可以充当分组去进行运算的数
        int mask = 1;
        while ((temp & mask) == 0) {
            mask = mask << 1;
        }

        //进行分组,分成两组，转换为两组，求出现一次的数字
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & mask) == 0) {
                a = a ^ num;
            } else {
                b = b ^ num;
            }
        }
//因为题目要求小的数字放前面，所以这里做一个判断
        if (a > b) {
            int c = a;
            a = b;
            b = c;
        }
        return new int[]{a, b};
    }


    /*public static int[] FindNumsAppearOnce(int[] nums) {
        int[] res = new int[2];
        Map<Integer, Integer> cvt = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (cvt.containsKey(nums[i])) {
                cvt.remove(nums[i]);
            } else {
                cvt.put(nums[i], nums[i]);
            }
        }

        int i=0;
        for (Integer number:cvt.keySet()) {
            res[i] = cvt.get(number);
            i++;
        }
        Arrays.sort(res);
        return res;
    }*/


}
