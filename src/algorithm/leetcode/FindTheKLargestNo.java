package algorithm.leetcode;

import java.util.Scanner;

/**
 * 查找第K大的元素
 */
public class FindTheKLargestNo {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int len = scan.nextInt();
        int k = scan.nextInt();
        int [] arr = new int[len];
        while(scan.hasNext()){
            for(int i=0; i<len; i++){
                arr[i] = scan.nextInt();
            }
            System.out.println(findTheKLargestNo(arr, len, k,0, len-1));
        }
    }

    private static int findTheKLargestNo(int [] arr, int len, int k, int left, int right){
        int p = arr[left];
        int pos = partition(arr, 0, left, right);
        System.out.println(left + ", " + right + ", " + pos);
            if (pos == len - k) {
                return pos;
            } else if (pos < len - k) {
                //right
                return findTheKLargestNo(arr, len, k, pos + 1, len-1);
            } else {
                return findTheKLargestNo(arr, len, k, 0, pos-1);
            }
    }

    private static int partition(int [] arr, int p, int left, int right){
        while(left < right) {
            while (left < right && arr[right] > p) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] < p) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = p;
        return left;
    }



}
