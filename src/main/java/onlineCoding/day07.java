package onlineCoding;

import dataStructure.TreeNode;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Created by ZhangQ on 2018/3/24.
 */
public class day07 {
    public  static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root!= null) {
            System.out.println(root.val);
            TreeNode left = root.left;
            TreeNode right = root.right;
            while (left!=null && right!=null){
                System.out.println(left.val);
                System.out.println(right.val);
                left = left.left;
                right = left.right;
            }
        }
        return null;
    }

    public static void main(String[] args) {
       Object[] objects = new Object[2];
       String[] s1 = {"a","b","c"};
       String[] s2 = {"d","e","f"};
       objects[0] = s1;
       objects[1] = s2;
       LinkedList<String> r = new LinkedList<>();
       print(objects,r,0,new LinkedList<String>());
       r.forEach(System.out::println);
    }

     static void print(Object[] objects,LinkedList<String> result, int layer,LinkedList<String> curList){
        if (layer<objects.length-1) {
            if (objects[layer] instanceof String[]) {
                String[] s1 = (String[]) objects[layer];
                if (s1.length == 0)
                    print(objects, result, layer + 1, curList);
                else
                    for (String s : s1) {
                        LinkedList<String> linkedList = new LinkedList<>();
                        linkedList.add(s);
                        print(objects, result, layer + 1, linkedList);
                    }
            }
        } else if (layer == objects.length-1)
                if (objects[layer] instanceof String[]){
                    String[] s2 = (String[])objects[layer];
                    if (s2.length == 0)
                        result.addAll(curList);
                    else
                        for (String s : s2){
                            LinkedList<String> list = new LinkedList<>();
                            list.add(s);
                            result.addAll(list);
                        }
                }
    }

    @Test
    public void test01(){
        int totalNum = 5;
        int countNum = 3;
        // 初始化人数
        List<Integer> start = new ArrayList<Integer>();
        for (int i = 1; i <= totalNum; i++) {
            start.add(i);
        }
        //从第K个开始计数
        int k = 0;
        while (start.size() >0) {
            k = k + countNum;
            //第m人的索引位置
            k = k % (start.size()) - 1;
            // 判断是否到队尾
            if (k < 0) {
                System.out.println(start.get(start.size()-1));
                start.remove(start.size() - 1);
                k = 0;
            } else {
                System.out.println(start.get(k));
                start.remove(k);
            }
        }
    }
    /*找出数组中绝对值相差最小的两个数*/
    @Test
    public void test03(){
        HashMap map = new HashMap();
        map.put(1,2);
        Hashtable hashtable = new Hashtable();
        hashtable.put(null,2);
        int[] a = {3,2,1};
        Arrays.sort(a);
        for (int i : a)
            System.out.println(i);
    }

    @Test
    public void testTime(){
        LocalDateTime dateTime = LocalDateTime.now();
        StringBuilder s = new StringBuilder("当前时间： ");
        s.append(dateTime.getYear()).append("年");
        s.append(dateTime.getMonthValue()).append("月");
        s.append(dateTime.getDayOfMonth()).append("日 ");
        s.append(dateTime.getHour()).append("点");
        s.append(dateTime.getMinute()).append("分");
        s.append(dateTime.getSecond()).append("秒");
        System.out.println(s.toString());
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));
    }

    public void getIn(int a){
        System.out.println("int");
    }

    @Test
    public void testC(){
        String[] s1 = {"a","b","c"};
        String[] s2 = {"d","e","f"};
        Object[] objects = {s1,s2};
        for (int i =0;i<objects.length-1;i++)
            if (objects[i] instanceof String[]){
            String[] t1 = (String[]) objects[i];
            String[] t2 = (String[]) objects[++i];
                for (String j : t1)
                    for (String k : t2)
                        System.out.println(j+k);
            }

    }

    @Test
    public void getV(){
        int[] a = {3,2,1};
        List<Integer> list = new LinkedList<>();
        for (int i : a)
            list.add(i);
        quickSort(list);
        int temp = Math.abs(list.get(0)-list.get(1));
        int p=0,q=1;
        for (int i = 1; i < list.size()-1; i++) {
            int t = Math.abs(list.get(i)-list.get(i+1));
            if (temp>t){
                temp = t;
                p = i;
                q = i+1;
            }
        }
        System.out.println(list.get(p)+"  "+list.get(q));
    }


    private void quickSort(List<Integer> items){
        if (items.size()>1){
            int comp = items.get(items.size()/2);
            List<Integer> smaller = new LinkedList<>();
            List<Integer> bigger = new LinkedList<>();
            List<Integer> same = new LinkedList<>();
            items.forEach(i -> {
                if (i<comp)
                    smaller.add(i);
                if (i>comp)
                    bigger.add(i);
                if (i==comp)
                    same.add(i);
            });
            quickSort(smaller);
            quickSort(bigger);
            items.clear();
            items.addAll(smaller);
            items.addAll(same);
            items.addAll(bigger);
        }
    }
}
