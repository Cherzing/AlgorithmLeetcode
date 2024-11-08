package cn.cherzing;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Cherzing
 * @date 2024/11/09 0009 17:27
 * @description IsSameTree
 * 100. 相同的树
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class IsSameTree {
    @Test
    public void testIsSameTree() {
        InorderTraversalSolution.TreeNode treeNodeP = new InorderTraversalSolution.TreeNode(1);
        InorderTraversalSolution.TreeNode treeNodeQ = new InorderTraversalSolution.TreeNode(1);

        treeNodeQ.right = new InorderTraversalSolution.TreeNode();
        treeNodeQ.right.val = 2;


        treeNodeP.left = new InorderTraversalSolution.TreeNode();
        treeNodeP.left.val = 2;

        //System.out.println(new IsSameTreeSolution().isSameTree(treeNodeP, treeNodeQ));
        System.out.println(new IsSameTreeSolution().isSameTreeTest1(treeNodeP, treeNodeQ));
    }

}

class IsSameTreeSolution {
    /**
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(InorderTraversalSolution.TreeNode p, InorderTraversalSolution.TreeNode q) {
        // 使用二叉树的先序遍历，如果遍历结果相同，在true
        List<Integer> listP = preorderTraversal(p);
        List<Integer> listQ = preorderTraversal(q);

        for (int i : listP) {
            System.out.println(i);
        }
        for (int i : listQ) {
            System.out.println(i);
        }
        return listQ.equals(listP);
    }

    /**
     * 使用递归的方式：
     * 1. 如果p与q为null，则相同；
     * 2. 如果其中一个节点为空而另一个不为空，则这两个节点不同。
     * 3. 如果两个节点的值不同，则这两个节点不同。
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTreeTest1(InorderTraversalSolution.TreeNode p, InorderTraversalSolution.TreeNode q) {

        if (p == null && q == null) {
            return true;
        } else if (p == null && q != null || q == null && p != null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }
        return isSameTreeTest1(p.left, q.left) && isSameTreeTest1(p.right, q.right);
    }

    /**
     * 中序遍历
     *
     * @param treeNode
     * @return
     */
    public List<Integer> preorderTraversal(InorderTraversalSolution.TreeNode treeNode) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(treeNode, res);
        return res;
    }

    /**
     * 先序遍历
     *
     * @param root
     * @param res
     */
    public List<Integer> inorder(InorderTraversalSolution.TreeNode root, List<Integer> res) {
        if (root == null) {
            return null;
        } else {
            //先序遍历
            res.add(root.val); //根
            inorder(root.left, res);  // 左
            inorder(root.right, res);  // 左
        }
        return res;
    }
}
