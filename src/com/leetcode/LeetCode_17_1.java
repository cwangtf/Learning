package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xing_seng
 * @date 2020/8/26
 */
public class LeetCode_17_1 {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> wordMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        letter(combinations, wordMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public void letter(List<String> combinations, Map<Character, String> wordMap,
                       String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = wordMap.get(digit);
            int count = letters.length();
            for (int i = 0; i < count; i++) {
                combination.append(letters.charAt(i));
                letter(combinations, wordMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }
}
