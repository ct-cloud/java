package algorithm.nowcoder;


import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.lang.String;

/**
 * 实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 * 注意每个输入文件有多组输入，即多个字符串用回车隔开,输入的字符中只包含小写字母
 */

public class RmLstOccurCharOfStr {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int len = str.length();
        Map<Character, Integer> map = new HashMap();
        for (char ch : str.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
        int minTimes = str.length();
        for(Integer charTime : map.values()){
            minTimes = charTime < minTimes ? charTime : minTimes;
        }
        System.out.println("minTimes : " + minTimes);
        for(Character ch : map.keySet()){
            if(minTimes == map.get(ch)){
                str = str.replace(String.valueOf(ch), "");
            }
        }

    }
}
