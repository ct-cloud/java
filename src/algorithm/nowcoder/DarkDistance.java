package algorithm.nowcoder;

import java.util.Scanner;

public class DarkDistance {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int len = Integer.valueOf(scanner.nextLine());
            String str = scanner.nextLine();
            System.out.println(getDarkDistance(len, str));
        }
    }

    private static int getDarkDistance(int len, String str){
        String [] arr = str.split(" ");
        int res = 0;
        for(int i=0; i<len-1; i++){
            int r1 = Integer.valueOf(arr[i]);
            int r2 = Integer.valueOf(arr[i+1]);
            int d1 = r1+r2 > 100 ? 0 : 100-r1-r2;
            res += d1;
        }
        return res;
    }
}
