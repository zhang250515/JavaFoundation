package onlineCoding;

import dataStructure.ListNode;
import org.junit.Test;

import java.util.*;

/**
 * Created by ZhangQ on 2018/4/4.
 */
public class day08 {

    public static void main(String[] args) {
        String[] vs1 = "a b c d".split(" ");
        String[] vs2 = "e f g h".split(" ");
        List<String[]> list = new LinkedList<>();
        list.add(vs1);
        list.add(vs2);
        print2(list,0,new LinkedList<>());
    }
    static void print2(List<String[]> vs, int level, List<String> chars){
        if (level == vs.size()) {
            System.out.println(Arrays.asList(chars));
            return;
        }
        for (int i = 0; i < vs.get(level).length; i++){
            chars.add(vs.get(level)[i]);
            print2(vs, level + 1, chars);
            chars.remove(chars.size() - 1);
        }
    }

    public int FirstNotRepeatingChar(String str) {
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
        char[] array = str.toCharArray();
        for (int i=0; i<array.length; i++) {
            if (map.containsKey(array[i])){
                map.put(array[i],-1);
            }else {
                map.put(array[i], i);
            }
        }
        ArrayList<Integer> list = new ArrayList<>(1);
        map.values().stream().filter(i -> i>-1).findFirst().ifPresent(list::add);
        return list.size()>0 ? list.get(0) : -1;
    }

    @Test
    public void testFirstNot(){
        //System.out.println(FirstNotRepeatingChar("WSLoobEFiHVQBDQULKOxQGpclyxaHJgEXWMqkVNylRSaaQZYdVPvhKHdiVZwdjEteETIUATxUjzfQ"));
        System.out.println(getFile("Abc/file.txt"));
    }

    public String getFile(String str){
        String[] name = str.split("\\.");
        return name.length>1 ? name[1] : null;
    }
}
