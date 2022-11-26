package leetcode.editor.cn;////给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
////
//// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
////
//// 
////
//// 
////
//// 示例 1： 
////
//// 
////输入：digits = "23"
////输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
//// 
////
//// 示例 2： 
////
//// 
////输入：digits = ""
////输出：[]
//// 
////
//// 示例 3： 
////
//// 
////输入：digits = "2"
////输出：["a","b","c"]
//// 
////
//// 
////
//// 提示： 
////
//// 
//// 0 <= digits.length <= 4 
//// digits[i] 是范围 ['2', '9'] 的一个数字。 
//// 
//// Related Topics 哈希表 字符串 回溯 👍 2072 👎 0
//


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class PhoneNumberCombineSolution {
    public static void main(String[] args) {
        System.out.println((new PhoneNumberCombineSolution()).letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        //回溯便利
        back(phoneMap,combinations,0,new StringBuffer(),digits);
        return combinations;
    }

    private void back(Map<Character, String> phoneMap, List<String> combinations, int i, StringBuffer stringBuffer,String digits) {
        if(i == digits.length()){
            combinations.add(stringBuffer.toString());
        }else {
            Character c = digits.charAt(i);
            String tempStr = phoneMap.get(c);
            int length = tempStr.length();
            for(int j=0;j<length;j++){
                stringBuffer.append(tempStr.charAt(j));
                back(phoneMap, combinations, i+1, stringBuffer, digits);
                stringBuffer.deleteCharAt(i);
            }
        }
    }


    public static List<String> letterCombinationsOne(String digits) {
        String[] maps = new String[]{
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }
        String firstButtonStr = maps[digits.charAt(0) - '2'];

        for (int i = 0; i < firstButtonStr.length(); i++) {
            result.add(String.valueOf(firstButtonStr.charAt(i)));
        }
        for (int j = 1; j < digits.length(); j++) {
            String temp = maps[digits.charAt(j) - '2'];
            for (int tempIndex = 0; tempIndex < temp.length(); tempIndex++) {
                int resultLen = result.size();
                for (int resultIndex = 0; resultIndex < resultLen; resultIndex++) {
                    result.add(result.get(resultIndex) + temp.charAt(tempIndex));
                }
                for (int resultIndex = 0; resultIndex < resultLen; resultIndex++) {
                    result.remove(0);
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
