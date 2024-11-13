package cn.cherzing;

/**
 * @author Cherzing
 * @date 2024/11/13 0013 20:26
 * @description IsSymmetric
 */

import org.junit.Test;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class IsSymmetric {
    @Test
    public void testIsSymmetric() {
        IsSymmetricSolution isSymmetricSolution = new IsSymmetricSolution();
        IsSymmetricSolution.TreeNode tree = new IsSymmetricSolution.TreeNode(1);

        IsSymmetricSolution.TreeNode treeNodeLeft = new IsSymmetricSolution.TreeNode(2);
        IsSymmetricSolution.TreeNode treeNodeRight = new IsSymmetricSolution.TreeNode(2);

        IsSymmetricSolution.TreeNode treeNodeLeftSonLeft = new IsSymmetricSolution.TreeNode(3);
        IsSymmetricSolution.TreeNode treeNodeLeftSonRight = new IsSymmetricSolution.TreeNode(4);
        IsSymmetricSolution.TreeNode treeNodeRightSonRight = new IsSymmetricSolution.TreeNode(3);
        IsSymmetricSolution.TreeNode treeNodeRightSonLeft = new IsSymmetricSolution.TreeNode(4);

        tree.left = treeNodeLeft;
        tree.right = treeNodeRight;

        treeNodeLeft.right = treeNodeLeftSonRight;
        treeNodeLeft.left = treeNodeLeftSonLeft;


        treeNodeRight.right = treeNodeRightSonRight;
        treeNodeRight.left = treeNodeRightSonLeft;

        System.out.println(isSymmetricSolution.isSymmetricMe(tree));
    }
}

class IsSymmetricSolution {
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

    /**
     * 根据上一题的经验：首先排除遍历！<br>
     * <p>
     * 我的想法：
     * 递归根节点的左右子树
     *
     * @param root
     * @return
     */
    public boolean isSymmetricMe(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return recursion(root.left, root.right);
        }
    }

    private boolean recursion(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        } else {
            return recursion(left.left, right.right) && recursion(left.right, right.left);
        }
    }
}