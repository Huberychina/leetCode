package althgrithm.sort;

import java.util.Arrays;

//归并排序
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{
                8, 4, 5, 7, 1, 3, 6
        };
        // Arrays.copyOfRange(arr,0,2); //输出 8  4，代表前闭后开区间
        int[] result = mergeSort(arr);
        for(int i: result){
            System.out.print(i+"\t");
        }
    }

    private static int[] mergeSort(int[] arr) {
        if(arr.length < 2) return arr;
        int middleLen = arr.length /2;
        int[] leftArr = Arrays.copyOfRange(arr,0,middleLen);
        int[] rightArr = Arrays.copyOfRange(arr,middleLen,arr.length);
        return merge(mergeSort(leftArr),mergeSort(rightArr));
    }

    private static int[] merge(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length+arr2.length];
        int index = 0;
        int i=0,j=0;
        for(;i<arr1.length && j<arr2.length ;){
            if(arr1[i]<arr2[j]){
                result[index++] = arr1[i++];
            }else {
                result[index++] = arr2[j++];
            }
        }
        while(j<arr2.length){
            result[index++] = arr2[j++];
        }
        while(i<arr1.length){
            result[index++] = arr1[i++];
        }
        return result;
    }
}
