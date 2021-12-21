package algorithm.nowcoder;

import java.util.*;


public class RmDupAndSort {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int len = scan.nextInt();
            Set<Integer> set = new HashSet();
            for(int i=0; i<len; i++){
                set.add(scan.nextInt());
            }
            set.stream().sorted().forEach(System.out::println);
        }
    }
}