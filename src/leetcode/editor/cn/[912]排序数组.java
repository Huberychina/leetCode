package leetcode.editor.cn;//给你一个整数数组 nums，请你将该数组升序排列。
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -5 * 10⁴ <= nums[i] <= 5 * 10⁴ 
// 
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 👍 622 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class SortSolution {
    public int[] sortArray(int[] nums) {
        return selectionSort(nums);
    }

    private static int[] selectionSort(int[] arr) {
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
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
