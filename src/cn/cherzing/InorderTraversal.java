package cn.cherzing;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    /**  递归：（不懂这种方法）
     * 使用了一个栈来存储节点，并初始化当前节点为根节点。然后，进入一个循环，当当前节点不为空或栈不为空时，我们执行以下操作：
     * 如果当前节点不为空，我们将其推入栈中，并将其移动到左子节点。
     * 如果当前节点为空，我们从栈中弹出一个节点，访问它，并将其移动到右子节点。
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalIteration(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {  // 当前节点不为空或栈不为空
            // 当前节点不为空
            while (current != null) {
                // 如果当前节点不为空，推入栈中，并将其移动到左子节点
                stack.push(current);
                current = current.left;
            }

            // 当前节点为空，从栈中弹出一个节点
            current = stack.pop();
            result.add(current.val);  // Add the node value to result
            current = current.right;  // 已经访问了节点及其左子树，轮到右子树
        }

        return result;
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