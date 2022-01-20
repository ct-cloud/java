package algorithm.leetcode;

import java.util.HashMap;

public class Leetcode_3 {
    public static void main(String [] args){
        String str = "tmmuabc";
        System.out.println(lengthOfLongestSubstring1(str));
    }

    /**
     * arr用来记录滑动窗口内的字符出现的次数
     */
    public static int lengthOfLongestSubstring1(String s) {
        int ret = 0;
        int left = 0;
        int right = 0;
        int [] arr = new int [128];
        for (; left < s.length(); left++) {
            if(left != 0) {
                arr[s.charAt(left)]--;
            }
            while(right < s.length() && arr[s.charAt(right)] == 0) {
                arr[s.charAt(right)]++;
                right++;
            }
            ret = Math.max(ret, right-left);
            //放在循环开始处，逻辑上会更清晰，表示窗口左侧向右移动一位，将该位置计数减1
//            arr[s.charAt(left)]--;
        }
        return ret;
    }

    /**
     * map中存储的是字符以及字符出现的位置
     *
     */
    private static int lengthOfLongestSubstring2(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                //取left和map中该字符出现位置的最大值是因为，map中记录的字符位置可能在窗口左侧，也可能在窗口右侧，如果取到的位置比left还小，说明该字符已经在窗口外，位置是无效的
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;

    }
}
