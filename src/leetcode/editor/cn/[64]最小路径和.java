package leetcode.editor.cn;//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
// 说明：每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 100 
// 
// Related Topics 数组 动态规划 矩阵 👍 1412 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static void main(String[] args) {
        int[][] num = new int[][]{
                {1,3,1},{1,5,1},{4,2,1}
        };
        System.out.println(new Solution().minPathSum(num));
    }
    public int minPathSum(int[][] grid) {
        if(grid.length == 0) return 0;
        //改进措施，可以在原数组上进行计算，节约空间复杂度
        int[][] dp = new int[grid.length][grid[0].length];
        int length = grid.length;
        int width = grid[0].length;
        dp[0][0] = grid[0][0];
        //这个步骤可以直接放到两层循环中，符合从上到下，从左到右的顺序
        for(int i=1;i<length;i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        //同上
        for(int j=1;j<width;j++) {
            dp[0][j] = dp[0][j-1]+ grid[0][j];
        }
        for(int i=1;i<length;i++){
            for(int j=1;j<width;j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[length-1][width-1];

    }

    /**
     * 在原数组进行更改
     */
    class Solution1 {
        public int minPathSum(int[][] grid) {
            for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid[0].length; j++) {
                    if(i == 0 && j == 0) continue;
                    else if(i == 0)  grid[i][j] = grid[i][j - 1] + grid[i][j];
                    else if(j == 0)  grid[i][j] = grid[i - 1][j] + grid[i][j];
                    else grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
            return grid[grid.length - 1][grid[0].length - 1];
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
