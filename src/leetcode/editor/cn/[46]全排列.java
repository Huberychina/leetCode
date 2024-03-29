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
//    public static void main(String[] args) {
//        System.out.println(new PermuteSolution().permute(new int[]{
//                1,2,3
//        }));
//    }
//    List<List<Integer>> result = new ArrayList<>();
//    int targetLen = 0;
//    public List<List<Integer>> permute(int[] nums) {
//        targetLen = nums.length;
//        List<Integer> tempResult = new ArrayList<>();
//        boolean[] used = new boolean[nums.length];
//        helper(nums,tempResult,used);
//        return result;
//    }
//
//    private void helper(int[] nums, List<Integer> tempResult, boolean[] used) {
//        if(tempResult.size() == targetLen){
//            result.add(new ArrayList<>(tempResult));
//        }else {
//            for(int j=0;j<nums.length;j++){
//                if(!used[j]){
//                    tempResult.add(nums[j]);
//                    used[j] = true;
//                    helper(nums,tempResult,used);
//                    used[j] = false;
//                    tempResult.remove(tempResult.size()-1);
//                }
//
//            }
//
//        }
//    }

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length; // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();
        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, List<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (depth == len) {
            res.add(path);
            return;
        } // 在非叶子结点处，产生不同的分支，这一操作的语义是：在还未选择的数中依次选择一个元素作为下一个位置的元素，这显然得通过一个循环实现。
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, len, depth + 1, path, used, res); // 注意：下面这两行代码发生 「回溯」，回溯发生在从 深层结点 回到 浅层结点 的过程，代码在形式上和递归之前是对称的
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        PermuteSolution solution = new PermuteSolution();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
