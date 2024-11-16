package cn.cherzing;

import org.junit.Test;

/**
 * @author Cherzing
 * @date 2024/11/16 0016 20:08
 * @description MaxDepth
 */
public class MaxDepth {
    @Test
    public void testMaxDepth() {
        MaxDepthSolution.TreeNode treeNode = new MaxDepthSolution.TreeNode(3);
        MaxDepthSolution.TreeNode treeNodeLeft = new MaxDepthSolution.TreeNode(9);
        MaxDepthSolution.TreeNode treeNodeRight = new MaxDepthSolution.TreeNode(20);

        MaxDepthSolution.TreeNode treeNodeRightRight = new MaxDepthSolution.TreeNode(7);
        MaxDepthSolution.TreeNode treeNodeRightLeft = new MaxDepthSolution.TreeNode(15);

        treeNode.left = treeNodeLeft;
        treeNode.right = treeNodeRight;
        treeNodeRight.right = treeNodeRightRight;
        treeNodeRight.left = treeNodeRightLeft;

        System.out.println(new MaxDepthSolution().maxDepth(treeNode));
    }

}

class MaxDepthSolution {

    /**
     * 我的想法：
     * 递归的深度就是二叉树的深度
     *
     */

    /**
     * 给定一个二叉树root，返回其最大深度。
     * 二叉树的最大深度是指从根节点到最远叶子节点的最长路径上的节点数。
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftTimes = maxDepth(root.left);
            int rightTimes = maxDepth(root.right);
            return Math.max(leftTimes, rightTimes) + 1;  // 加上1，是因为递归从根节点开始，加上根节点的1
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}