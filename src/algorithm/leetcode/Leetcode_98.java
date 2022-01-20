package algorithm.leetcode;


/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 解题思路，递归
 * 因为val定义的是int类型，有可能是最大整数，判断的时候可以用Long.MIN_VALUE, Long.MAX_VALUE来判断，也可以用Interger类型，null代表最大值
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}

public class leetcode_98 {
    public static void main(String [] args){
        TreeNode node = new TreeNode(5);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(7);
        TreeNode right_right = new TreeNode(9);
        right.right = right_right;
        node.left = left;
        node.right = right;
        List<Integer> list = new ArrayList<>();
        inOrder(node, list);
        list.forEach(System.out::println);
    }

    private static void inOrder(TreeNode root, List<Integer> list){
        if (root == null){
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    public boolean isValidBST(TreeNode root) {
        return checkOrder(root, null, null);

    }
    private boolean checkOrder(TreeNode node, Integer minValue, Integer maxValue){
        if(node == null){
            return true;
        }
        if((minValue!=null && node.val <= minValue) || (maxValue!=null && node.val >= maxValue)){
            return false;
        }
        return checkOrder(node.left, minValue, node.val) && checkOrder(node.right, node.val, maxValue);
    }
}
