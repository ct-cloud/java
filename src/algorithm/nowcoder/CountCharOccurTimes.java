package algorithm.nowcoder;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class CountCharOccurTimes{
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        String str = "";
        String ch = "";
        while(true){
            str = scan.nextLine();
            ch = scan.nextLine();
            System.out.println(countTimesOfChar(str, ch));
        }

    }

    public static int countTimesOfChar(String str, String checkStr){
        int total = 0;
        char ch = checkStr.toCharArray()[0];
        Set<Character> checkList = new HashSet();
        if(ch >= 'a' && ch <= 'z'){
            checkList.add((char)(ch-32));
            checkList.add(ch);
        }else if(ch >= 'A' && ch <= 'Z'){
            checkList.add((char)(ch+32));
            checkList.add(ch);
        }else{
            checkList.add(ch);
        }
        System.out.println(checkList);
        for(int i=0; i<str.length(); i++){
            if(checkList.contains(str.charAt(i))){
                total ++;
            }
        }
        return total;
    }
}