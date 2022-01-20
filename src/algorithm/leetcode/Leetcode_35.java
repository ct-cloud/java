package algorithm.leetcode;

import java.util.Arrays;

public class Leetcode_35 {
    public static void main(String [] args){
        int row = 5, col = 6;
        int [][] arr = new int[row][col];
        int num = 5;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                arr[i][j] = (int)(Math.random()*10);
            }
            Arrays.sort(arr[i]);
            System.out.printf("arr[%d]: %s\n", i, Arrays.toString(arr[i]));
            System.out.println(insertPos(arr[i], num));
        }
    }

    private static int insertPos(int [] arr, int num){
        int left = 0, right = arr.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if (arr[mid] < num){
                left = mid + 1;
            }else if (arr[mid] >= num){
                right = mid-1;
            }
        }
        return left;
    }
}
