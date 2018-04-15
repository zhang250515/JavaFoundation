package onlineCoding;

import org.junit.Test;

import java.util.*;

/**
 * Created by ZhangQ on 2017/12/29.
 */
public class day04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        String a = scanner.nextLine();
        String[] b = a.split(" ");
        int i = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (i<b.length)
            arrayList.add(Integer.valueOf(b[i++]));
        int maxsum, maxhere;
        System.out.println(arrayList);
        maxsum = maxhere = arrayList.get(0);   //初始化最大和为a【0】
        for (int j=1; j<arrayList.size(); j++) {
            if (maxhere <= 0)
                maxhere = arrayList.get(j);  //如果前面位置最大连续子序列和小于等于0，则以当前位置i结尾的最大连续子序列和为a[i]
            else
                maxhere += arrayList.get(j); //如果前面位置最大连续子序列和大于0，则以当前位置i结尾的最大连续子序列和为它们两者之和
            if (maxhere > maxsum) {
                maxsum = maxhere;  //更新最大连续子序列和
            }
        }
        System.out.println(maxsum);
    }

    @Test
    public void testThread(){
        Integer a = 120;
        new Thread(()->{
            System.out.println("abc");
        }).start();
    }

    @Test
    public void testMap(){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"a");
        map.put(2,"b");
        map.keySet().iterator().forEachRemaining(System.out::println);
        Objects.equals(1,2);
    }

    @Test
    public void testScan(){
        Scanner in = new Scanner(System.in);
        System.out.println(in.nextLine());
    }

}
