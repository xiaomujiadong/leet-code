package com.saint.other;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by wdcao on 2018/5/11.
 */
public class Tree {
    public static void preOrder(TreeNode1 biTree){
        LinkedList<TreeNode1> stack  = new LinkedList();
        TreeNode1 pNode = biTree;

        while(pNode!=null || !stack.isEmpty()){
            if (pNode != null) {
                System.out.print(pNode.val+"  ");
                stack.addFirst(pNode);
                pNode = pNode.left;
            } else { //pNode == null && !stack.isEmpty()
                TreeNode1 node = stack.removeFirst();
                pNode = node.right;
            }
        }
    }

    public static void main(String[] args){
        TreeNode1 treeNode1 = new TreeNode1(1);

        TreeNode1 treeNode2 = new TreeNode1(2);
        treeNode1.left = treeNode2;
        TreeNode1 treeNode3 = new TreeNode1(3);
        treeNode1.right = treeNode3;

        TreeNode1 treeNode4 = new TreeNode1(4);
        treeNode2.left = treeNode4;
        TreeNode1 treeNode5 = new TreeNode1(5);
        treeNode2.right = treeNode5;

        TreeNode1 treeNode6 = new TreeNode1(6);
        treeNode3.right = treeNode6;

        TreeNode1 treeNode7 = new TreeNode1(7);
        treeNode5.left = treeNode7;
        TreeNode1 treeNode8 = new TreeNode1(8);
        treeNode5.right = treeNode8;

        preOrder(treeNode1);
    }
}

class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;
    TreeNode1(int x) { val = x; }
}