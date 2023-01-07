package leetcode.editor.cn;//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
//
// 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
// Related Topics 数组 哈希表 字符串 排序 👍 1333 👎 0


import java.util.*;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
class GroupAnagramsSolution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> result = new HashMap<>();
        Arrays.stream(strs).forEach(str ->{
            String arrayKey = getArrayKey(str);
            List<String> tempResult = (result.get(arrayKey) == null? new ArrayList<>(): result.get(arrayKey)) ;
            tempResult.add(str);
            result.put(arrayKey,tempResult);
        });
        return new ArrayList<>(result.values());
    }
    public String getArrayKey(String str){
        int[] characterArray = new int[26];
        char[] chars = str.toCharArray();
        for(char c:chars){
            characterArray[c-'a'] +=1;
        }
        StringBuilder key = new StringBuilder();
        for (int i=0;i<26;i++){
            key.append(characterArray[i]>0?i+"$"+characterArray[i]:"");
        }
        return key.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
