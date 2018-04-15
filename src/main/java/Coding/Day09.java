package Coding;

import LamStudy.User;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by ZhangQ on 2018/1/5.
 */
public class Day09 {

    public Day09(){
        System.out.println("Day09 construct");
    }

    {
        System.out.println("Day09 code block");
    }

    @Test
    public void testSet(){
        User user = new User();
        List ab = new LinkedList();
        System.out.println(user.hashCode());
        user.setId(1);
        System.out.println(user.hashCode());
        Integer a = 2;
        System.out.println(a.hashCode());
        String b = "1";
        int c = b.hashCode();
        System.out.println(c);
        char d = '1';
        System.out.println(d);
    }

    @Test
    public void testHashMap(){
        BigDecimal b1 = new BigDecimal(1.02D);
        BigDecimal b2 = new BigDecimal(1.01D);
        System.out.println(b1.subtract(b2).doubleValue());
        BigDecimal b3 = new BigDecimal(0.02D);
        BigDecimal b4 = new BigDecimal(0.01D);
        System.out.println(b3.subtract(b4).doubleValue());
        System.out.println(1.2 - 1.1);
        BigDecimal s1 = new BigDecimal("1.002");
        BigDecimal s2 = new BigDecimal("1.001");
        System.out.println(s1.subtract(s2));
        HashMap map  = new HashMap();
        map.put(null,1);
        Stack stack = new Stack();
        System.out.println(map);
    }


}
