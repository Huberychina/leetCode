package leetcode.editor.cn;//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 数组 回溯 👍 1242 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempResult = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        helper(nums,result,0,tempResult,used);
        return result;
    }

    private void helper(int[] nums, List<List<Integer>> result, int depth, List<Integer> tempResult, boolean[] used) {
        if(depth == nums.length){
            result.add(new ArrayList<>(tempResult));
            return;
        }

            for(int i=0;i<nums.length;i++){
                if(!used[i] && !(i>0 && nums[i]==nums[i-1] && !used[i-1])){
                    tempResult.add(nums[i]);
                    used[i] = true;
                    helper(nums,result,depth+1,tempResult,used);
                    used[i] = false;
                    tempResult.remove(tempResult.size()-1);
                }

            }
        }


    public static void main(String[] args) {
        int[] nums = {1, 1, 3};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.permuteUnique(nums);
        System.out.println(lists);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
