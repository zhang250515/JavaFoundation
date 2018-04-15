package onlineCoding;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.nio.ByteOrder;
import java.util.Random;

/**
 * Created by ZhangQ on 2017/10/29.
 */
public class chapter01 {
    public void hello(){
        System.out.println("hello");
    }


    @Test
    public void testBigJava() throws IOException{
        //大端小端问题
        byte[] arr = new byte[4];
        arr[0] = 0x78;
        arr[1] = 0x56;
        arr[2] = 0x34;
        arr[3] = 0x12;
        ByteArrayInputStream bais = new ByteArrayInputStream(arr);
        DataInputStream dis = new DataInputStream(bais);
        System.out.println(Integer.toHexString(dis.readInt()));
        ByteOrder order = ByteOrder.nativeOrder();
        System.out.println(order);
    }

    @Test
    public void testRandom(){
        System.out.println(Math.random());
        System.out.println(new Random().nextInt(11));
    }

    public static void main(String[] args) {
        ((chapter01)null).hello();
    }
}
