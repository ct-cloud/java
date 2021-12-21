import java.util.Scanner;

public class Main1 {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int concurrent = Integer.valueOf(scanner.nextLine());
            int len = Integer.valueOf(scanner.nextLine());
            int [] arr = new int[len];
            for(int i = 0; i < len; i++){
                arr[i] = scanner.nextInt();
            }
            System.out.println(countTime(arr, concurrent));
        }
    }

    private static int countTime(int [] arr, int concurrent){
        int sum = 0;
        int len = arr.length;
        int remain = 0;
        for(int i = 0; i < len; i++){
            int total = remain + arr[i];
            remain = total > concurrent ? total-concurrent : 0;
            sum++;
            if(i==len-1){
                sum += remain%concurrent==0 ? remain/concurrent : remain/concurrent+1;
            }
        }
        return sum;
    }
}
