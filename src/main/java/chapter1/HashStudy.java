package chapter1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ZhangQ on 2018/5/16.
 */
public class HashStudy {

    @Test
    public void testHashMap(){
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"hello");
        map.forEach((k,v) -> System.out.println(k+"-"+v));
    }

    @Test
    public void testGetArr(){
        String s = "12345ILoveChina123AGoodCompany312";
        ArrayList<String> result = new ArrayList<>();
        System.out.println(getArrayLength(s, result));
        System.out.println(result);
    }
    private int getArrayLength(String input, ArrayList<String> list){
        ArrayList<Character> temp1 = new ArrayList<>();
        ArrayList<Character> temp2 = new ArrayList<>();
        char[] in = input.toCharArray();
        int low = '0';
        int high = '9';
        int tempIndex;
        for (int i = 0; i < in.length; i++) {
            if (in[i] < low || in[i] > high ){
                tempIndex = i;
                for (int j = tempIndex; j < in.length; j++) {
                    if (in[j] > low && in[j] < high)
                        break;
                    temp1.add(in[j]);
                    i=j;
                }
                if (temp1.size() > temp2.size()){
                    temp2.clear();
                    temp2.addAll(temp1);
                }
                temp1.clear();
            }
        }
        StringBuilder s = new StringBuilder();
        temp2.forEach(s::append);
        list.add(s.toString());
        return list.size()>0 ? list.get(0).length() : 0;
    }
}
