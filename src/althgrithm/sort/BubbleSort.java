package althgrithm.sort;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2,8,200,10,4,50};
        bubbleSort(arr);
        for(int i: arr){
            System.out.print(i+"\t");
        }
     }

    public static int[] bubbleSort(int[] arr){
        //代表外层多少趟循环
        for(int i=0;i<arr.length-1;i++){
            boolean hasBeenInOrder = true;
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    //如果交换过，则表示还有元素前后关系不对
                    hasBeenInOrder = false;
                }
            }
            //有了标志位，则最优的时候时间复杂度将为o(N)
            if(hasBeenInOrder){
                break;
            }
        }
        return arr;
    }

}
