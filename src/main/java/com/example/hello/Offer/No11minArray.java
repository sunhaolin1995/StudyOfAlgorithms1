package com.example.hello.Offer;

/**
 * @author 孙浩林
 * @date: 2022/12/28 15:40
 */
public class No11minArray {
    public static void main(String[] args) {
        int[] numbers = {1, 0, 1, 1, 1};
        System.out.println(minArray(numbers));
    }

    public static int minArray(int[] numbers) {
        int index1 = 0, index2 = numbers.length - 1;
        int indexMid = index1;

        while (numbers[index1] >= numbers[index2]) {
            if (index2 - index1 == 1) {
                indexMid = index2;
                break;
            }

            indexMid = (index1 + index2) / 2;

            if (numbers[index1] == numbers[index2] && numbers[index1] == numbers[indexMid]){
                return MinInOrder(numbers,index1,index2);
            }

            if (numbers[indexMid] >= numbers[index1]) {
                index1 = indexMid;
            } else if (numbers[indexMid] <= numbers[index2]) {
                index2 = indexMid;
            }

        }
        return numbers[indexMid];
    }

    public static int MinInOrder(int[] numbers,int index1,int index2){
        int res = numbers[index1];
        for (int i = index1 +1 ; i <=index2 ; i++) {
            if (res > numbers[i]){
                res = numbers[i];
            }
        }
        return res;
    }

}
