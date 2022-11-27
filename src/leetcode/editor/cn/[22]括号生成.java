package leetcode.editor.cn;//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 2983 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }
    List<String> resultList = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    int size = 0;
    public List<String> generateParenthesis(int n) {
        this.size = n;
        helperRecursive("",0,0);
        return resultList;
    }

    //递归剪枝法
    public void helperRecursive(String str,int left,int right){
        if(left==right && left == size){
            resultList.add(str);
        }
        if(right>left){
            return ;
        }
        if(left>size){
            return;
        }
        helperRecursive(str+"(",left+1,right);
        helperRecursive(str+")",left,right+1);
    }

    //回溯法
    public void backTrackerHelper(int left,int right){
        if(left == right && left == size){
            resultList.add(sb.toString());
        }
        if(right > left){
            return ;
        }
        if(left>size){
            return ;
        }
        sb.append("(");
        backTrackerHelper(left+1,right);
        sb.deleteCharAt(sb.length()-1);
        sb.append(")");
        backTrackerHelper(left,right+1);
        sb.deleteCharAt(sb.length()-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
