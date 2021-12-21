package algorithm.nowcoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.lang.String;

public class ConvertHexToInteger{

    public static void main(String [] args){
        Map<Integer, Integer> map = new HashMap();
        String pattern = "^[A,D,S,W]%d%d";
        System.out.println("A30".matches(pattern));
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String hexIn = scan.nextLine();
            System.out.println(convertToInt(hexIn));
        }
    }

    private static int convertToInt(String hexIn){
        String valueToComp = hexIn.substring(2, hexIn.length());
        int len = valueToComp.length();
        int res = 0;
        int factor = 1;
        for(int i=len-1; i>=0; i--){
            System.out.print(getDigit(valueToComp.charAt(i)) + "-");
            System.out.print(factor);
            System.out.println("\n");
            res += factor * getDigit(valueToComp.charAt(i));
            factor = factor * 16;
        }
        return res;
    }

    private static int getDigit(char ch){
        if(ch >='0' && ch <= '9'){
            return Integer.valueOf(String.valueOf(ch));
        }else{
            return 10+ch-'A';
        }
    }
}