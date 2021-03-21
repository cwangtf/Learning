package interview;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangtf
 * @date 2021/3/21
 */
public class CountChar {
    public static void main(String[] args) {
        String test = "AAAAABBBCCCCCC";
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < test.length(); i++) {
            countMap.merge(test.charAt(i), 1, Integer::sum);
        }
        countMap.forEach((k , v) -> {
            System.out.format("key: %s, value: %d%n", k, v);
        });
    }
}
