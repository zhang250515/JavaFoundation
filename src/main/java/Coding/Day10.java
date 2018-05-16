package Coding;

import dataStructure.TreeNode;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by ZhangQ on 2018/3/10.
 */
public class Day10 extends Day09{



        {
            System.out.println("dd code block");
        }

        public Day10(){
            System.out.println("dd construct");
        }

        public static void main(String[] args) {

            Day10 day10 = new Day10();

        }


    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null)
            return new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        findPath(root,target,path,result);
        return result;
    }

    private void findPath(TreeNode root, int target, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result) {
            if (root == null)
                return;
            path.add(root.val);
            if (root.left != null)
                findPath(root.left, target, path, result);
            if (root.right != null)
                findPath(root.right, target, path, result);
            if (root.right == null && root.left == null)
                if (path.stream().reduce(Integer::sum).orElse(0) == target)
                    result.add(new ArrayList<>(path));

        path.remove(path.size()-1);
    }

    @Test
    public void testFind(){
         TreeNode node = new TreeNode(10);
         node.left = new TreeNode(5);
         node.right = new TreeNode(12);
         node.left.left = new TreeNode(4);
         node.left.right = new TreeNode(7);
        ArrayList<ArrayList<Integer>> lists = FindPath(node, 22);
        System.out.println(lists);
    }
    @Test
    public void testAdd(){
        ArrayList<Integer> path = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        path.add(1);
        path.add(2);
        result.add(path);
        result.add(path);
        System.out.println(result.size());
        System.out.println(path.stream().reduce(Integer::sum).orElse(0));
        System.out.println(path.size());
    }


}
