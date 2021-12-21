//System.out.println("sum " + sum + " posOne " + posOne + " posTwo " + posTwo);

import java.util.Scanner;

public class Main2 {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.nextLine();
            findElementWithAbsSumMin(str);
        }
    }

    private static void findElementWithAbsSumMin(String str){
        String [] arr = str.split(" ");
        int len = arr.length;
        int sum = Integer.MAX_VALUE;
        int posOne = 0, posTwo = 0;
        for(int i=0; i<len; i++){
            int addOne = Integer.valueOf(arr[i]);
            for(int j=i+1; j<len; j++){
                int addTwo = Integer.valueOf(arr[j]);
                int tempAbsSum = Math.abs(addOne+addTwo);
                if(tempAbsSum < sum){
                    posOne = i;
                    posTwo = j;
                    sum = tempAbsSum;
                }
            }
        }
        if(Integer.valueOf(arr[posOne]) < Integer.valueOf(arr[posTwo])) {
            System.out.println(arr[posOne] + " " + arr[posTwo] + " " + sum);
        }else{
            System.out.println(arr[posTwo] + " " + arr[posOne] + " " + sum);
        }
    }
}
