package leetcode.editor.cn;//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 栈 字符串 动态规划 👍 2114 👎 0


import java.util.ArrayDeque;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class LongestParentheses {
    /**
     * 思考栈中应该存什么东西，另外哑元素占位，可以同链表头节点一样处理
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int length = s.length();
        int startIndex = 0;
        int maxValidLength = 0;
        stack.push(-1);
        for(int i=0;i<length;i++){
            //从第一个字符开始找有效括号长度
            char c = s.charAt(i);
            if(c == '('){
                stack.push(i);
            }
            if(c == ')' ){
                //合法匹配
                stack.pop();
                if( !stack.empty()){
                    maxValidLength = Math.max(i-stack.peek(),maxValidLength);
                }else{
                    stack.push(i);
                }
            }
        }
        return maxValidLength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
