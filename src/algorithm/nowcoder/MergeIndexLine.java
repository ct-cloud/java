package algorithm.nowcoder;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class MergeIndexLine{
    public static void main(String [] args){
        int a = 5;
        System.out.println(Integer.parseInt(String.valueOf(a), 2));
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int num = scan.nextInt();
            Map<Integer, Integer> map = new HashMap();
            for(int i=0; i<num; i++){
                int key = scan.nextInt();
                int value = scan.nextInt();
                map.put(key, map.getOrDefault(key, 0)+value);
            }
            for(Map.Entry entry: map.entrySet()){
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }
}
