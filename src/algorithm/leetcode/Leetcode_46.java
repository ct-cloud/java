package algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Leetcode_46 {

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>(len);

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                     Deque<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            System.out.printf("i = %d, used = [%b %b %b] \n", i, used[0], used[1], used[2]);
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;

                System.out.printf("  递归之前, i = %d,  => %s \n" , i, path);
                dfs(nums, len, depth + 1, path, used, res);

                used[i] = false;
                path.removeLast();
                System.out.printf("递归之后, i=%d, => %s \n", i, path);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Leetcode_46 solution = new Leetcode_46();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);
    }
}


