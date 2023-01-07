package leetcode.editor.cn;//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 3989 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

class CatchWaterSolution {
    public static void main(String[] args) {
        System.out.println((new CatchWaterSolution()).trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public int trap(int[] h) {
        int n = h.length, ans = 0;
        int[] left = new int[n], right = new int[n];
        left[0] = h[0];
        right[n - 1] = h[n - 1];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(h[i], left[i - 1]);
            right[n - i - 1] = Math.max(h[n - i - 1], right[n - i]);
        }
        for (int i = 0; i < n; i++) ans += Math.min(left[i], right[i]) - h[i];
        return ans;
    }


//
//    /**
//     * 动态规划
//     * @param heights
//     * @return
//     */
//    public int trap(int[] heights) {
//        int len = heights.length;
//        int[] leftMax = new int[len];
//        int[] rightMax = new int[len];
//        int lmax = 0;
//        int rmax = 0;
//        for(int i=0;i<len;i++){
//            if(heights[i] > lmax){
//                lmax = heights[i];
//
//            }
//            leftMax[i] = lmax;
//            if(heights[len-1-i] > rmax){
//                rmax = heights[len-1-i];
//            }
//            rightMax[len-1-i] = rmax;
//        }
//        int ans = 0;
//        for(int i=0;i<len;i++){
//            ans += Math.min(leftMax[i],rightMax[i]) - heights[i];
//        }
//        return ans;
//    }


//
//    /**
//     * 单调递减栈解法
//     * @param height
//     * @return
//     */
//    public int trap(int[] height) {
//        //height = [0,1,0,2,1,0,1,3,2,1,2,1]
//        //单调递减栈实现
//        Stack<Integer> stack = new Stack<>();
//        int ans = 0;
//        int i = 0;
//        while(i < height.length){
//            while(!stack.isEmpty() && height[i] > height[stack.peek()]){
//                Integer pop = stack.pop();
//                if(stack.isEmpty()){
//                    break;
//                }
//                Integer peek = stack.peek();
//                ans += (Math.min(height[peek],height[i])-height[pop]) * (i-peek-1);
//             }
//            stack.push(i);
//            i++;
//        }
//        return ans;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
