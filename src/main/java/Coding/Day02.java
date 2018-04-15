package Coding;

import dataStructure.TreeNode;

import java.util.Arrays;

/**
 * Created by ZhangQ on 2017/10/9.
 */
public class Day02 {

    //输入先序遍历和中序遍历，重建二叉树
    private TreeNode reConstructBinaryTree(int [] pre, int [] in) {

        if(pre.length==0 || in.length==0)
            return null;
            TreeNode root = new TreeNode(pre[0]);
            for(int i=0;i<in.length;i++){
                if(pre[0] == in[i]){
                    root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),
                            Arrays.copyOfRange(in,0,i));
                    root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),
                            Arrays.copyOfRange(in,i+1,in.length));
                }
            }
       return root;
    }
}
