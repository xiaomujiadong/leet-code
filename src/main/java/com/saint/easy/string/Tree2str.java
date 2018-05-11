package com.saint.easy.string;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。

 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。

 示例 1:

 输入: 二叉树: [1,2,3,4]
 1
 /   \
 2     3
 /
 4

 输出: "1(2(4))(3)"

 解释: 原本将是“1(2(4)())(3())”，
 在你省略所有不必要的空括号对之后，
 它将是“1(2(4))(3)”。
 示例 2:

 输入: 二叉树: [1,2,3,null,4]
 1
 /   \
 2     3
 \
 4

 输出: "1(2()(4))(3)"

 解释: 和第一个示例相似，
 除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
 */
public class Tree2str {
    public static String tree2str(TreeNode2 t) {
        LinkedList<TreeNode2> list = new LinkedList<TreeNode2>();

        TreeNode2 nowNode = t;
        boolean isRight = false;
        while(nowNode!=null || !list.isEmpty()){
            if(nowNode!=null){
                if(!isRight){
                    System.out.print("( ");
                }

                System.out.print(nowNode.val);
                if(isRight){
                    System.out.print(")");
                }

                list.addFirst(nowNode);
                nowNode = nowNode.left;
                isRight = false;
            }else{
                isRight = true;
                nowNode = list.removeFirst();
                nowNode = nowNode.right;
            }
        }

        return null;
    }
   public static void main(String[] args){
       TreeNode2 treeNode1 = new TreeNode2(1);

       TreeNode2 treeNode2 = new TreeNode2(2);
       treeNode1.left = treeNode2;
       TreeNode2 treeNode3 = new TreeNode2(3);
       treeNode1.right = treeNode3;

       TreeNode2 treeNode4 = new TreeNode2(4);
       treeNode2.left = treeNode4;
       TreeNode2 treeNode5 = new TreeNode2(5);
       treeNode2.right = treeNode5;

       TreeNode2 treeNode6 = new TreeNode2(6);
       treeNode3.right = treeNode6;

       TreeNode2 treeNode7 = new TreeNode2(7);
       treeNode5.left = treeNode7;
       TreeNode2 treeNode8 = new TreeNode2(8);
       treeNode5.right = treeNode8;

       tree2str(treeNode1);
   }
}
class TreeNode2 {
    int val;
    TreeNode2 left;
    TreeNode2 right;
    TreeNode2(int x) { val = x; }
}

