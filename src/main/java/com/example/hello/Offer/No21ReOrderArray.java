package com.example.hello.Offer;

/**
 * @author 孙浩林
 * @date: 1/22/24 14:00
 */
public class No21ReOrderArray {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        int[] ints = reOrderArray(array);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public static int[] reOrderArray(int[] array) {
        int[] res = new int[array.length];
        int odd = 0;
        int dummy = 0;
        while (dummy < array.length) {
            if (array[dummy] % 2 == 1) {
                res[odd] = array[dummy];
                odd++;
            }
            dummy++;
        }
        int even = array.length - 1;
        int right = array.length - 1;
        while (right >= 0) {
            if (array[right] % 2 == 0) {
                res[even] = array[right];
                even--;
            }
            right--;
        }
        return res;
    }

}
