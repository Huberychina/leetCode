package leetcode.editor.cn;//给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 
//输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 10⁹ 
// 
// Related Topics 贪心 字符串 排序 👍 956 👎 0

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionMaxNumber {
    public String largestNumber(int[] nums) {
        //按照首字母排序，找出最大的一个数字
        //第二位，判断最大位数的同位开头的，若没有，则进行第二轮，若有，则进行再排序，再进行排序
        //5,9,99,95
        //9->99->95->5
        sort(nums);
        StringBuilder str = new StringBuilder();
        if(nums[0]==0){
            return "0";
        }
        Arrays.stream(nums).forEach(str::append);
        return str.toString();
    }

    public void sort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                //冒泡比较a[j] 和 a[j+1]的大小,小的放后面
                if (lessThan(nums[j],nums[j+1])){
                    int tmp = nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
    }

    public boolean lessThan(int a, int b) {
        return (String.valueOf(a)+String.valueOf(b)).compareTo(String.valueOf(b)+String.valueOf(a)) <0 ;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
