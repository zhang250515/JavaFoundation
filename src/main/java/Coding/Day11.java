package Coding;

import dataStructure.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by ZhangQ on 2018/5/16.
 * abc,acb,bac,bca,cab和cba。
 */
public class Day11 {
    public ArrayList<String> Permutation(String str) {
        if (str.length() < 1)
            return new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        permutation(list, str.toCharArray(), 0, str.toCharArray().length);
        return list;
    }

    public static char[] text = { 'a', 'b', 'c', 'd', 'e' };

    @Test
    public void testPerm() {
        ArrayList<String> list = new ArrayList<>();
        char[] t = "aa".toCharArray();
        permutation(list, t, 0, t.length);
        System.out.println(list);
    }

    private  void permutation(ArrayList<String> list, char a[], int m, int n) {
        int i;
        char t;
        if (m < n - 1) {
            permutation(list, a, m + 1, n);
            for (i = m + 1; i < n; i++) {
                t = a[m];
                a[m] = a[i];
                a[i] = t;
                permutation(list, a, m + 1, n);
                t = a[m];
                a[m] = a[i];
                a[i] = t;
            }
        } else {
            String temp = charToString(a);
            if (!list.contains(temp))
                list.add(temp);
        }
    }

    private String charToString(char[] a) {
        if (a == null)
            return "";
        int iMax = a.length - 1;
        if (iMax == -1)
            return "";

        StringBuilder b = new StringBuilder();
        for (char i : a)
            b.append(i);
        return b.toString();
    }

    /**
     * 输出指定字符数组
     *
     * @param text 将要输出的字符数组
     */
    public static void printResult(char[] text) {
        for (int i = 0; i < text.length; i++) {
            System.out.print(text[i]);
        }
        System.out.println();
    }

    public int TreeDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(TreeDepth(root.left), TreeDepth(root.right))+1;
    }

    @Test
    public void testDepth(){
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.right = new TreeNode(12);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(7);
        System.out.println(TreeDepth(node));
    }

    public int Add(int num1,int num2) {
        return 0;
    }

    @Test
    public void testAdd(){
        String a = "+2147483647";
        System.out.println(StrToInt("-123"));
        System.out.println(StrToInt(a));
    }

    public int StrToInt(String str) {
        int result = 0;
        if (str.length()<1)
            return 0;
        int f = str.toCharArray()[0];
        for (int i : str.toCharArray()) {
            i = i - 48;
            if (i < 10 && i > 0) {
                if (result * 10 + i <= Integer.MAX_VALUE)
                    result = result * 10 + i;
                else
                    return 0;
            } else if (result > 0)
                return 0;
        }
        if (f == 45)
            return ~result+1;
        return result;
    }
}
