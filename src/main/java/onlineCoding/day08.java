package onlineCoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
}
