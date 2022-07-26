package althgrithm.sort;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6};//直接复制数组
        insertSort(arr);
        for (int i:
             arr) {
            System.out.print(i + "\t");
        }
    }
    public static int[] insertSort(int[] arr){
        for(int i =1;i<arr.length;i++){
            int tmp = arr[i];
            //如果之前的元素比这个元素大，则将这个值插入，相应元素进行后移
            int j = i;
            //如果整个数据已经有序，那么这个条件一直进不去，则时间复杂度退化成o(N)
            while(j>0 && arr[j-1] > tmp){
                arr[j] = arr[j-1];
               j--;
            }
            if(i != j){
                arr[j] = tmp;
            }
        }
        return arr;
    }
}
