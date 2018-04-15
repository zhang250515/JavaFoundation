package chapter1;

import LamStudy.User;
import org.junit.Test;

import java.util.*;

/**
 * Created by ZhangQ on 2017/10/27.
 */
public class Collection01 {

    @Test
    public void listLearn(){
        List<Integer> list = new LinkedList<>();
        Thread l = new Thread();
        new Thread(() -> {
            System.out.println("123");
        }).start();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        System.out.println(list);
        Iterator it = list.iterator();
        it.next();
        it.remove();
        System.out.println(list);
    }


    @Test
    public void MapLearn(){
        Map<Integer,String> map = new HashMap<>();
        String h = map.put(1,"h");
        map.put(2,"j");
        map.put(3,"k");
        //System.out.println(map);
        map.forEach((k,v)->System.out.println(k+"-"+v));
        System.out.println(map.getOrDefault(4,"default"));
    }

    @Test
    public void testArrays(){
        User user = new User();
        user.setId(1);
        user.setName("kent");
        User[] users = new User[3];
        users[0] = user;
        List<User> userList = Arrays.asList(users);
        List<User> l = Collections.checkedList(userList,User.class);
        l.forEach(System.out::println);
        Calendar.getInstance();
        l.removeIf(u ->u.getName().equals("") );
    }

    @Test
    public void testHash(){
        String a = "a";
        int l = a.hashCode();
        System.out.println(l);
    }
}
