package leetcode.editor.cn;//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 👍 2315 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class PermuteSolution {
    public static void main(String[] args) {
        System.out.println(new PermuteSolution().permute(new int[]{
                1,2,3
        }));
    }
    List<List<Integer>> result = new ArrayList<>();
    int targetLen = 0;
    public List<List<Integer>> permute(int[] nums) {
        targetLen = nums.length;
        List<Integer> tempResult = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        helper(nums,tempResult,used);
        return result;
    }

    private void helper(int[] nums, List<Integer> tempResult, boolean[] used) {
        if(tempResult.size() == targetLen){
            result.add(new ArrayList<>(tempResult));
        }else {
            for(int j=0;j<nums.length;j++){
                if(!used[j]){
                    tempResult.add(nums[j]);
                    used[j] = true;
                    helper(nums,tempResult,used);
                    used[j] = false;
                    tempResult.remove(tempResult.size()-1);
                }

            }

        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
