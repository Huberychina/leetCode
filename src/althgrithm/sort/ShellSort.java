package althgrithm.sort;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6};//直接复制数组
        shellSort(arr);
        for(int i : arr){
            System.out.print(i + "\t");
        }
    }

    private static void shellSort(int[] arr) {
        for(int step = Math.floorDiv(arr.length,2);step>=1;step = Math.floorDiv(step,2) ){
            //用插入排序，将步长为i的组调整为有序
            for(int i = step;i<arr.length;i +=step){
                int tmp = arr[i];
                int j = i;
                while (j-step >= 0 && arr[j-step] > tmp){
                    //元素右移
                    arr[j] = arr[j-step];
                    j -= step;
                }
                if(i != j){
                    arr[j] = tmp;
                }
            }

        }
    }

}
