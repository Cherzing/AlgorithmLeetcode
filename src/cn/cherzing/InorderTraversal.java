package cn.cherzing;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cherzing
 * @date 2024/11/08 0008 16:46
 * @description InorderTraversal
 */
public class InorderTraversal {
    @Test
    public void testInorderTraversal(){
        InorderTraversalSolution inorderTraversalSolution = new InorderTraversalSolution();
        ArrayList<Integer> list = new ArrayList<>();
        InorderTraversalSolution.TreeNode root = new InorderTraversalSolution.TreeNode(1);
        root.right = new InorderTraversalSolution.TreeNode(2);
        root.left = null;
        root.right.left = new InorderTraversalSolution.TreeNode(3);

        System.out.println(inorderTraversalSolution.inorderTraversal(root));
    }
}

class InorderTraversalSolution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        inorder(root,result);
        return result;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        } else {
            inorder(root.left,res);
            res.add(root.val); //将中间的元素加入列表
            inorder(root.right,res);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
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