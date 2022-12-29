package com.example.hello.Offer;

/**
 * @author 孙浩林
 * @date: 2022/9/10 13:52
 */
public class no4findNumberIn2DArray {
    public static void main(String[] args) {
        int[][] array ={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int[][] array1 ={{-5}};
      ///  System.out.println(array.length);
      //  System.out.println(array[0].length);
        System.out.println(find(array1,-5));
      //  System.out.println(array.length);


    }

    public static boolean find(int[][] array,int number){
        boolean result =false;

        int a = array.length;
        int b = 0;
        if (a !=0){
            b=array[0].length;
        }

        if (a >0 && b >0){
            int row = 0 ;
            int column =b-1;

             while (row < a && column >=0){
                 if (array[row][column] == number){
                     result =true;
                     break;
                 }else if (array[row][column] > number){
                     --column;
                 }else {
                     ++row;
                 }
             }

        }

        return result;
    }
}
