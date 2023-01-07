package leetcode.editor.cn;//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 二分查找 👍 2090 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class SearchRangeSolution {
    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        System.out.println(Arrays.toString(new SearchRangeSolution().searchRange(nums, 8)));
    }
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1,-1};
        int leftIndex = binarySearch(nums,target,0,nums.length-1,true);
        int rightIndex = binarySearch(nums,target,0,nums.length-1,false);
        return new int[]{leftIndex,rightIndex};
    }

    //输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4]
//
// 示例 2：
//
//
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1]
    public int binarySearch(int[] nums,int target,int left,int right,boolean isLeft){
        int targetIndex = -1;
        while (left <= right){
            int mid = (left + right) >> 1;
            if(nums[mid] == target){
                if(isLeft){
                    right = mid-1;
                }else {
                    left = mid + 1;
                }
                targetIndex = mid;
            }else if(nums[mid] > target){
                right = mid -1;
            }else {
                left = mid +1;
            }
        }
        return targetIndex;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
