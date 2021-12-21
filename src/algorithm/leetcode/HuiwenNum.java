package algorithm.leetcode;

import java.util.Scanner;
/**
 * 找出一个字符串的最长回文子串
 */
public class HuiwenNum {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String str =scan.nextLine();
//            System.out.println(str + " num is a huiwen " + isHuiWen(str));
            System.out.println("the max length of substring is " + countLongestHuiWen(str));
        }

    }

    private static int countLongestHuiWen(String str){
        int len = str.length();
        int res = 0;
        for(int i=1; i<len; i++){
            for(int j=i-1; j>=0; j--){
                if(2*i-j<len && str.charAt(j)==str.charAt(2*i-j)){
                    res = Math.max(res, 2*(i-j)+1);
                }else{
                    break;
                }
            }
            for(int j=i-1; j>=0; j--){
                if(2*i-j-1< len && str.charAt(j)==str.charAt(2*i-j-1)){
                    res = Math.max(res, 2*(i-j));
                }
                else{
                    break;
                }
            }
        }
        return res;
    }

    private static boolean isHuiWen(String str){
        int len = str.length();
        int i = 0, j= len-1;
        while(i<j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }else{
                i++;
                j--;
            }
        }
        return true;
    }
}
