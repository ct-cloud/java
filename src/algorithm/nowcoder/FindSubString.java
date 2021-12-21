package algorithm.nowcoder;

import java.util.*;

/**
 * 找出最长连续元音子串
 */
public class FindSubString {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            System.out.println(findSubStringLen(str));
        }
    }

    private static int findSubStringLen(String str){
        int res = 0;
        int strLen = str.length();
        List<Character> checkChars = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        for(int i = 0; i < strLen; i++){
            for(int j = i; j < strLen; j++){
                if(!checkChars.contains(str.charAt(j))){
                    res = Math.max(res, j-i);
                    i = j + 1;
                    break;
                }
                if(j == strLen - 1){
                    res = Math.max(res, j-i+1);
                }
            }
        }
        return res;
    }

}
