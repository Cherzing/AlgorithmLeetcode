package cn.cherzing;

import org.junit.Test;
import java.util.List;

/**
 * @author Cherzing
 * @date 2024/11/16 0016 21:05
 * @description 给你二叉树的根节点root，返回其节点值的层序遍历。（即逐层地，从左到右访问所有节点）。
 */
public class LevelOrder {
    @Test
    public void levelOrder() {

    }
}

class LevelOrderSolution {
    /**
     * 我的想法：<p>
     * 递归：
     * - 左->右
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        return null;
    }
    private int recursion(TreeNode left,TreeNode right){

        return 0;
    }
}

class TreeNode {
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