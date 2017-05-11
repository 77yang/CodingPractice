package yang.java.algorithm;


import java.util.Arrays;

/**
 *  Created by Dev_yang on 2017/5/11.
 * 冒泡排序
 * 从小到大排序
 *
 */
public class BubbleSort {

    public static void main(String[] args) {

        int[] arr={4,2,5,2,2,6,8,1,-1,9};
        sort(arr);
    }


    static void sort(int [] arr){
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {

            for (int j = arr.length-1; j >0 ; j--) {
                if(arr[j-1]>arr[j]){
                    swap(arr,j,j-1);
                }
            }

            System.out.println(Arrays.toString(arr));
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp=arr[j];
        arr[j]=arr[i];
        arr[i]=temp;
    }
}
