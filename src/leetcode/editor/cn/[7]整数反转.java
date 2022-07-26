package leetcode.editor.cn;
//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
// Related Topics 数学 👍 3475 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionReverse {
    public int reverse(int x) {

        int flag = x < 0 ? -1 : 1;
        int abs = Math.abs(x);
        int result = reverseCommon(abs);

        return flag * result;
    }

    public int reverseCommon(int abs) {
        if(abs==0){
            return abs;
        }
        Deque<Character> stack = new ArrayDeque<Character>();
        String absStr = String.valueOf(abs);
        char[] chars = absStr.toCharArray();
        for(char c : chars){
            stack.push(c);
        }
        StringBuilder result = new StringBuilder();
        boolean beginWithZero = true;
        for(char c : chars){
            Character pop = stack.pop();
            if(!(pop.equals('0') && beginWithZero)){
                result.append(pop);
                beginWithZero = false;
            }
        }
        int resultToInt =  Long.parseLong(result.toString())>= Integer.MAX_VALUE? 0 :Integer.parseInt(result.toString());
        return resultToInt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
