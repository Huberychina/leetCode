package althgrithm.sort;

/**
 * 堆排序，时间复杂度o(NlogN),空间复杂度o(1)
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6};//直接复制数组
        heapSort(arr);
        for(int i :arr){
            System.out.print(i+"\t");
        }
    }

    private static void heapSort(int[] arr) {
        //将数组调整成最大堆
        buildMaxHeap(arr);
        int len = arr.length;
        //循环处理堆
        for(int i=len;i>0;i--){
            swap(arr,0,len-1);
            len --;
            adjust(arr,0,len);
        }
    }

    private static void buildMaxHeap(int[] arr) {
        for(int i = arr.length/2-1;i>=0;i--){
            adjust(arr,i,arr.length);
        }
    }

    private static void adjust(int[] arr, int i, int length) {
        int left = 2* i +1;
        int right = 2*i+2;
        int maxIndex = i;
        if(left < length && arr[left]>arr[maxIndex]){
            //这个时候还没有真正的交换，只是在寻找3个节点中，哪个的值最大
            maxIndex = left;
        }
        if(right < length && arr[right]>arr[maxIndex]){
            //这个时候还没有真正的交换，只是在寻找3个节点中，哪个的值最大
            maxIndex = right;
        }
        if(maxIndex != i ){
            //真正执行交换
            swap(arr,i,maxIndex);
            //有可能使交换后的节点不再满足最大堆，递归进行调整
            adjust(arr,maxIndex,length);
        }
    }

    public static void swap(int[] arr ,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
