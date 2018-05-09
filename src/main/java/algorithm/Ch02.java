package algorithm;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ZhangQ on 2018/5/5.
 */
public class Ch02 {

    /**
     * 最大子序列和
     * -2 11 -4 13 -5 -2  max = 20
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] read = scanner.nextLine().split(" ");
        int[] num = new int[read.length];
        for (int i = 0; i < read.length; i++) {
            num[i] = Integer.valueOf(read[i]);
        }
        for (int j : num)
            System.out.println(j);
    }

    @Test
    public void testMax(){
        int[] a = {5,-2,11,-4,13,-5,-2};
        List<Integer> tempList = new LinkedList<>();
        List<Integer> resultList = new LinkedList<>();
        int max = 0;
        for (int i : a) {
            tempList.add(i);
            if (getListValue(tempList) < 0)
                tempList.clear();
            if (max<getListValue(tempList)){
                max = getListValue(tempList);
                resultList.clear();
                resultList.addAll(tempList);
            }
        }
        System.out.println(max);
        resultList.forEach(System.out::println);
        System.out.println(maxSequence(a));
    }

    private int maxSequence(int[] array){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            int temp = 0;
            for (int j = i; j < array.length; j++) {
                temp += array[j];
                if (max < temp)
                    max = temp;
            }
        }
        return max;
    }

    private int getListValue(List<Integer> list){
        if (list.size() < 1) return 0;
        int sum = 0;
        for (int i : list)
            sum += i;
        return sum;
    }

    @Test
    public void testRemove(){
        List<Integer> list01 = new LinkedList<>();
        List<Integer> list02 = new LinkedList<>();
        list01.add(1);
        list01.add(2);
        list02.add(1);
        boolean f = list02.removeAll(list01);
        System.out.println(f);
        list01.clear();
        System.out.println(list01.size());
    }

    @Test
    public void testContains(){
        String a = "abc";
        System.out.println(a.contains("ab"));
    }

    @Test
    public void textMax3(){
        System.out.println(max3(1,2,3));
        System.out.println(max3(4,5,6));
    }

    private int max3(int a, int b, int c){
        return a>b ? (a>c ? a : c) : (b>c ? b : c);
    }
}
