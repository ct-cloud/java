package algorithm.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class leetcode01 {
    /**
     * 输入一个整型数组和一个整数，输出数组中两数和等于整数的下标
     * @param arr
     * @param num
     * @return
     */
    public static int[] findIndexOfTwoAdds(int [] arr, int num){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int [] index = new int[]{-1, -1};
        for(int i = 0; i < arr.length; i++){
            int another = num - arr[i];
            if(map.containsKey(another)){
                index = new int[] {i, map.get(another)};
                return index;
            }else{
                map.put(arr[i], i);
                System.out.println(String.format("%d=%d", arr[i], i));
            }
        }

        return index;
    }

    public static void main(String [] args){
        List list = new LinkedList<>();
        int num = 12;
        int [] arr = {0, 1, 9, 6, 5, 1};
        int [] index = findIndexOfTwoAdds(arr, num);
        System.out.println(String.format("find index %d, %d", index[0], index[1]));
    }
}
