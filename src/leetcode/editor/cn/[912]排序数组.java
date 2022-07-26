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


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArray(int[] nums) {
        return shellSort(nums);
    }
    private static int[] shellSort(int[] arr) {
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
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
