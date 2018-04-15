package Coding;

import LamStudy.User;
import dataStructure.TreeNode;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by ZhangQ on 2017/10/13.
 */
public class Day04 {
   /* @Test
    public void pickStudents(int n,int[] m,int k,int d){
       *//* 3  n个学生
        7 4 7  每个学生的能力值
        2 50    选出的学生数  两个学生之间位置的差值
        *//*
    }*/

    @Test
    public void testList() {
        char a = '你';
        int[] i = {1, 2, 3};
        System.out.println(i.length);
        System.out.println(a);
    }

    /**
     * 已知二叉树的根和两个叶子，找出两个叶子的父节点
     * @param root 根
     * @param left 左子树
     * @param right 右子树
     * @return 两个叶子的父节点
     */
    public TreeNode find(TreeNode root,TreeNode left,TreeNode right){
        if(left.equals(root.left) && right.equals(root.right))
            return root;
        if(root.left != null) this.find(root.left,left,right);
        if (root.right != null) find(root,left,right);
        return null;
    }
}