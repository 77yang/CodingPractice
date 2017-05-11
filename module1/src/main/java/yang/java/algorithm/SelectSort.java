package yang.java.algorithm;

import java.util.Arrays;

/**
 *  Created by Dev_yang on 2017/5/11.
 * 选择排序
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr={4,2,5,2,2,6,8,1,-1,9};
        sort(arr);
    }

    static void sort(int [] arr){
        System.out.println(Arrays.toString(arr));
        System.out.println("==========");
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j <arr.length ; j++) {

                if(arr[i]>arr[j]){
                    swap(arr,i,j);
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
