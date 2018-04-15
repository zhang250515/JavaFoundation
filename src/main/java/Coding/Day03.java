package Coding;

import org.junit.Test;

import java.util.Objects;
import java.util.Stack;

/**
 * Created by ZhangQ on 2017/10/19.
 */

public class Day03 {
    //用两个栈实现队列
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
        stack1.push(node);
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
    }

    public int pop() {
        return stack1.pop();
    }

    //旋转数组的最小数字
    public int minNumberInRotateArray(int [] array) {
        if(array.length == 0) return 0;
        int min = array[0];
        for(int i : array){
            if(i<min) min = i;
        }
        return min;
    }

    //斐波那契数列第n项
    public int Fibonacci(int n) {
        if(n==0) return 0;
        if(n<3) return 1;
        else return Fibonacci(n-2)+Fibonacci(n-1);
    }

    //target为台阶数，青蛙跳1或2，求跳法
    public int JumpFloor(int target) {
        if(target<=0) return 0;
        if(target==1 || target==2) return target;
        int one = 1;
        int two = 2;
        int three = 0;
        for (int i = 3; i <= target ; i++) {
            three = one+two;
            one = two;
            two = three;
        }
        return three;
    }

    /**
     * 青蛙一次可以跳上一级或者n级台阶，求跳法
     * @param target 台阶数
     * @return 跳法
     */
    public int JumpFloorII(int target){
        if(target<=0) return 0;
        if(target ==1 || target==2) return target;
        int one = 1;
        int two = 2;
        int three = 0;
        for(int i=3;i<=target;i++){
            three = one + two + (int)Math.pow(2,i-3);
            one = two;
            two = three;
        }
        return three;
    }


    @Test
    public void testJump(){
        //29 832040
         for(int i = 1; i<30 ; i++) {
            System.out.println("i="+i+"----"+JumpFloorII(i));
        }
    }
}
