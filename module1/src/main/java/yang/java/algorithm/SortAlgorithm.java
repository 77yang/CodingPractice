package yang.java.algorithm;

import java.util.Arrays;

/**
 * Created by Dev_yang on 2017/5/11.
 */
public class SortAlgorithm {
    public static void main(String[] args) {
        int[] arr={4,2,5,2,2,6,8,1,-1,9};
//        selectSort(Arrays.copyOf(arr, arr.length));
//        bubbleSort(Arrays.copyOf(arr, arr.length));
//        insertSort(Arrays.copyOf(arr, arr.length));
//        fastSort(Arrays.copyOf(arr, arr.length));
        fastSort(Arrays.copyOf(arr, arr.length));
    }

    /**
     * 快速排序
     * @param arr
     */
    private static void fastSort(int[] arr) {
        System.out.println("===快速排序===");
        sort(arr, 0, arr.length-1);
    }

    private static void sort(int[] arr, int startIndex, int endIndex) {
       if(startIndex>=endIndex)return;
        System.out.println(Arrays.toString(arr));
        int leftIndex=startIndex;
        int rightIndex=endIndex-1;
        int midIndex=endIndex;
        while (leftIndex<rightIndex){
            while (arr[leftIndex]<=arr[midIndex]&&leftIndex<rightIndex)
                leftIndex++;
            while (arr[rightIndex]>=arr[midIndex]&&leftIndex<rightIndex)
                rightIndex--;
            swap(arr,leftIndex,rightIndex);
        }

        if(arr[leftIndex]>arr[midIndex]){
            swap(arr,leftIndex,midIndex);
        }else{
            leftIndex++;
        }
        sort(arr,0,leftIndex-1);
        sort(arr,leftIndex+1,endIndex);
    }

    /**
     * 插入排序
     * @param arr
     */
    private static void insertSort(int[] arr) {
        System.out.println("===插入排序===");
        System.out.println(Arrays.toString(arr));
        for (int referenceIndex = 0; referenceIndex < arr.length; referenceIndex++) {
          int temp=referenceIndex;
            for (int j =temp-1; j >=0; j--) {
              if(arr[temp]<arr[j]){
                 swap(arr,temp,j);
                  temp=j;
              }
            }
            System.out.println(Arrays.toString(arr));
        }
    }


    /**
     * 冒泡排序
     * @param arr
     */
    static void bubbleSort(int [] arr){
        System.out.println("===冒泡排序===");
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j <arr.length-1-i ; j++) {
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
            System.out.println(Arrays.toString(arr));
        }

    }

    /**
     * 选择排序
     * @param arr
     */
    static void selectSort(int [] arr){
        System.out.println("===选择排序===");
        System.out.println(Arrays.toString(arr));
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
