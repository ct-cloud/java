package algorithm.nowcoder;

import java.util.*;

public class SelectBestDispatcher {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int len = Integer.valueOf(scanner.nextLine());
            int res = 0;
            Map<Integer, Integer> chosen = new HashMap<>();
            for(int i=0; i<len; i++){
                String str = scanner.nextLine();
                String [] arr = str.split(" ");
                int choose = selectDispatcher(arr, i, chosen);
                res += choose;
            }
            System.out.println(res);
        }
    }

    private static int selectDispatcher(String [] arr, int index, Map<Integer, Integer> chosen){
        int lastIndex = chosen.getOrDefault(index-1, -1);
        int min = Integer.MAX_VALUE;
            for(int i=0; i<arr.length; i++){
                if(index > 0 && i==lastIndex) {
                    continue;
                }
                if(Integer.valueOf(arr[i]) < min){
                    min = Integer.valueOf(arr[i]);
                    chosen.put(index, i);
                }
            }
            return min;
    }
}
