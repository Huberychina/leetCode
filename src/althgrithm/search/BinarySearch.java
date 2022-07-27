package althgrithm.search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {-11,-13,-5,-2,4,6,11,28,39,420,7777};
        System.out.println(searchInLoop(arr,4));
    }

    /**
     * 递归实现
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchRecursion(int[] nums, int target) {
        return searchHelper(nums,0,nums.length-1,target);
    }
    public  static int searchHelper(int[] nums,int left,int right,int target){
        if(left >= right){
            return nums[left] == target ? left:-1;
        }
        int middle = (left + right)/2;
        if(nums[middle] == target){
            return middle;
        }
        if(nums[middle] < target){
            //注意这里要做+1,以防止栈溢出
            return searchHelper(nums,middle+1,right,target);
        }
        if(nums[middle] > target){
            //注意这里要做-1，以防止栈溢出
            return searchHelper(nums,left,middle-1,target);
        }
        return -1;
    }

    /**
     * 循环实现二分查找
     *
     * @param arr
     * @param target
     * @return
     */
    public static int searchInLoop(int[] arr, int target){
        int left = 0;
        int right = arr.length -1;
        //注意这个等值条件，因为有可能middle 的结果和left或者right相等
        while (left <= right){
            int middle = (left + right)/2;
            if(arr[middle] == target){
                return middle;
            }
            if(arr[middle] < target){
                left = middle +1;
            }
            if(arr[middle] > target){
                right = middle -1;
            }
        }
        return -1;
    }

}
