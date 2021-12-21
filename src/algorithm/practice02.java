package algorithm;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import javax.swing.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class practice02 {
    /**
     * 一个有序数组，查找是否存在某数num, 二分法，时间复杂度O(log2N)
     */

    /**
     * 在某个数组中找到大于等于num最左侧的位置，二分法，停止条件是
     */

    /**
     * 无序，任何相邻的数不相等，求一个局部最小位置，时间复杂度好于O(N)
     */

    /**
     * 递归，求arr[L..R]范围上求最大值
     */
    public int maxBetweenIndexLAndIndexR(int [] arr, int L, int R){
        return process(arr, L, R);
    }

    private int process(int [] arr, int L, int R){
        if (L==R){
            return arr[L];
        }
        int mid = L + (R-L)>>2;
        int maxLeft = process(arr, L, mid);
        int maxRight = process(arr, mid+1, R);
        return Math.max(maxLeft, maxRight);
    }



    public static void main(String [] args){
//        int []arr = new int []{1,2,3,4,5};
//        Map map = new HashMap();
//        algorithm.MyLinkedList<Integer> list = new algorithm.MyLinkedList<Integer>();
//        for(int i: arr) {
//            list.add(i);
//        }
        int [] arr = {5, 3, 2, 6, 8, 1};
        int res = findKLarger(arr, 4);
        System.out.println(res);
    }

    //判断非负整数是两数之和
    public static boolean isSquare(int num){
        if(num < 0){
            return false;
        }
        int i=0;
        int j= (int) Math.sqrt(num);
        while(i<j){
            int result = i*i + j*j;
            if(result == num){
                return true;
            }else if(result > num){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }

    //反转元音字符
    public static String swapYuanyinElement(String str){
        char [] yuanyinEement = {'a', 'o', 'i', 'e', 'u'};
        return "";
    }


    public static int findKLarger(int [] arr, int k){
        merge_order(arr, 0, arr.length-1);
        return arr[k-1];
    }

    public static void merge_order(int [] arr, int p, int q){
        if(p >= q){
            return;
        }
        int mid = p +(q-p)/2;
        merge_order(arr, p, mid);
        merge_order(arr, mid+1, q);
        merge(arr, p, q, mid);

    }

    public static void merge(int [] arr, int p, int q, int mid){
        int [] result = new int [q-p+1];
        int m = p, n = mid+1, k=0;
        while(m <= mid && n <= q){
            if(arr[m] <= arr[n]){
                result[k++] = arr[m++];
            }else{
                result[k++] = arr[n++];
            }
        }
        while(m <= mid){
            result[k++] = arr[m++];
        }
        while(n <= q){
            result[k++] = arr[n++];
        }
        for(k = p; k <= q; k++ ){
            arr[k] = result[k-p];
        }

    }

    public int [] max_square(int [] arr){
        return new int [0];
    }


}
