package Coding;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by ZhangQ on 2017/11/18.
 */
public class Day07 {

    @Test
    public void test01(){
        System.out.println(find01(new String[]{"abc","abcd","abd"}));
    }

    public int find01(String[] n){
        ArrayList<Character> list = new ArrayList<>();
        String temp = n[0];
        for (int i = 0; i < temp.length(); i++) {
            list.add(temp.charAt(i));
        }
        for (int i = 1; i < n.length; i++) {
            temp = n[i];
            for (int j = 0; j < temp.length(); j++) {
                if(j>=list.size()) break;
                if (temp.charAt(j) != list.get(j))
                    for (int k = list.size()-1; k >=j ; k--) {
                        list.remove(k);
                    }
            }
        }
        return list.size();
    }
}
