package onlineCoding;

import dataStructure.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Stack;

/**
 * Created by ZhangQ on 2018/3/3.
 * 1、二叉树的镜像
 * 2、顺时针打印矩阵
 */
public class day05 {
    public void Mirror(TreeNode root) {
        if (root != null)
            ex(root);
        else return;
        if(root.left != null && root.right != null){
            Mirror(root.left);
            Mirror(root.right);
        }else if (root.left == null && root.right != null){
            Mirror(root.right);
        }else if (root.left != null){
            Mirror(root.left);
        }

    }

    public void ex(TreeNode t){
        TreeNode node = t.left;
        t.left = t.right;
        t.right = node;
    }

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = matrix.length;
        int j = matrix[0].length;
        int sum = i*j;
        int k = 0,m = 0,n=0;
        if (i==1)
            while (m<j)
                list.add(matrix[0][m++]);
        if (j==1 && list.size()<sum)
            while (k<i)
                list.add(matrix[k++][0]);
        while (i>0 && j>0 && list.size()<sum){
            while (k<j)
                list.add(matrix[m][k++]);
            m++;
            k--;
            while (m<i)
                list.add(matrix[m++][k]);
            m--;
            k--;
            while (k>=n)
                list.add(matrix[m][k--]);
            k++;
            m--;
            while (m>n)
                list.add(matrix[m--][k]);
            k++;
            m++;
            i--;
            j--;
            n++;
        }
        return list;
    }

    @Test
    public void testSecondArr(){
        int[][] a =  {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] b = {{1},{2},{3},{4},{5}};
        int[][] c = {{1}};
        System.out.println(printMatrix(c));
    }

    @Test
    public void testP(){
        Integer a = 200;
        change(a);
        String b = "111";
        StringBuilder c = new StringBuilder("hello");
        change01(b);
        change02(c);
        System.out.println(c.toString());
    }

    void change02(StringBuilder a){
        a.append("haha");
    }

    public void change(Integer a){
        a = 300;
    }

    public void change01(String a){
        Stack<Integer> stack = new Stack<>();
        Optional<Integer> optional = stack.stream().min((e1, e2)->e1-e2);
        optional.get();
    }


}
