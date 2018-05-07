package algorithm;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ZhangQ on 2018/5/5.
 */
public class Ch02 {

    /**
     * 最大子序列和
     * -2 11 -4 13 -5 -2  max = 20
     */
    public static void main(String[] args) {

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
}
