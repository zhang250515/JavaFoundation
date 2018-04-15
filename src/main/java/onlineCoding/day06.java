package onlineCoding;

import Coding.Day06;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

/**
 * Created by ZhangQ on 2018/3/23.
 * 判断栈的压入，弹出序列
 */
public class day06 {

    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length!=popA.length)
            return false;
        if (pushA.length==0) return true;
        LinkedList<Integer> list = new LinkedList<>();
        int[] push = pushA;
        boolean f = true;
        int t = 0;
        for (int i : popA){
            for (int j = 0; push.length>1 && j < push.length; j++) {
                if (push[j] == i){
                    for (int k = 0; k < j; k++) {
                        list.add(push[k]);
                    }
                    if (f){
                        f = false;
                        t = j;
                    }else
                        t = t+j;
                    if (t+1 <= pushA.length) {
                        push = Arrays.copyOfRange(pushA, t + 1, pushA.length);
                        break;
                    }
                }
            }
            if (list.size()>0 && i == list.getLast()){
                list.removeLast();
                continue;
            }
            if (list.size()>0) continue;
        return false;
        }
        return list.size()==0;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = {2};
        int[] c = {2};
        int[] d = {3,5,4,2,1};
        boolean b1 = is(a,d);
        System.out.println(b1);
    }

    @Test
    public void testArrayCopy(){
        Vector s = new Vector();

        int[] a = {1,2,3,4,5};
        int[] b = Arrays.copyOfRange(a,1,a.length);
        for (int i : b) {
            System.out.println(i);
        }
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        System.out.println(list.getLast());
    }

    public static boolean is(int[] pushA,int[] popA){
        Stack<Integer> s = new Stack<Integer>();
        //用于标识弹出序列的位置
        int popIndex = 0;
        for(int i = 0; i< pushA.length;i++){
            s.push(pushA[i]);            //如果栈不为空，且栈顶元素等于弹出序列
             while(!s.empty() &&s.peek() == popA[popIndex]){
                 //出栈
                  s.pop();                //弹出序列向后一位
                  popIndex++;            }        }        return s.empty();
    }

    @Test
    public void test02(){
        int n = 5;
        int m = 3;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n ; i++) {
            list.add(i);
        }

        int k = 0;
        while (list.size()>0){
            k = k + m;
            k = k%list.size() - 1;
            if (k<0){
                System.out.println(list.getLast());
                list.removeLast();
            }else {
                System.out.println(list.get(k));
                list.remove(k);
            }
        }
    }
}
