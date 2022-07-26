package althgrithm.sort;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6};
        selectionSort(arr);
        for(int i:arr){
            System.out.print(i+"\t");
        }
    }

    private static void selectionSort(int[] arr) {
        //需要N-1轮循环
        for(int i =arr.length-1;i>0;i--){
            int maxValueIndex = i;
            for(int j=0;j<i;j++){
                //找最大的元素下表
                if(arr[j] > arr[maxValueIndex]){
                    maxValueIndex = j;
                }
            }
            if(maxValueIndex !=i){
                int temp = arr[i];
                arr[i] = arr[maxValueIndex];
                arr[maxValueIndex] = temp;
            }

        }
    }
}
