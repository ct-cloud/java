package algorithm.leetcode;

import java.util.*;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0
 *
 */
public class Leetcode_209 {
    public static void main(String [] args) {
        int [] nums = new int [] {1,4,4};
        int target = 4;
        System.out.println(getLstSubString(nums, target));
    }
    private static int getLstSubString(int [] nums, int target){
        int i = 0, j = 0;
        int res = -1;
        int sum = nums[0];
        while(i<=j && j < nums.length) {
            if(sum >= target) {
                res = res==-1 ? j-i+1 : Math.min(res, j-i+1);
                sum -= nums[i];
                i++;
            }else{
                j++;
                if(j < nums.length){
                    sum += nums[j];
                }
            }
        }
        res = res == -1 ? 0: res;
        return res;
    }
}
