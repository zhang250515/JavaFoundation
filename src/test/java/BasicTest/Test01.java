package BasicTest;

import org.junit.Test;

import java.util.LinkedList;

public class Test01 {

    @Test
    public void testSize(){
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }
    }
}
