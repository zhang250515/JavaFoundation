package Coding;

import org.junit.Test;

/**
 * Created by ZhangQ on 2017/10/31.
 */
public class Day05 {

    /**
     * 获取32位整数的符号位
     * @param n 1正 0负
     * @return 符号
     */
    public int sign(int n){
        return (n>>31)^1;
    }

    @Test
    public void testMax(){
        //System.out.println(sign(1));

        /*for(int i=0;i<11;i++){
            System.out.println(RectCover(i));
        }*/

     /*   int a = 10;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.bitCount(10));*/

     int[] a = {1,2,3,4,5};
     reOrderArray(a);
    }
    /**
     * 用2*1覆盖2*n的矩形
     * @param target 边长
     * @return 覆盖方法
     */
    public int RectCover(int target) {
        if(target<=0) return 0;
        else if (target==1) return 1;
        else return target*RectCover(target-1);
    }

    /**
     * 输入一个整数，计算其中1的个数
     * @param n 输入
     * @return 1的个数
     */
    public int NumberOf1(int n) {
        int sum = 0;
        String a = Integer.toBinaryString(n);
        char[] b = a.toCharArray();
        for (char c : b) {
            if(c == '1') sum++;
        }
        return sum;
    }

    /**
     * 奇数在前面，偶数在后面
     * @param array 数组
     */
    public void reOrderArray(int [] array) {
        int temp;
        for (int i = 0; i < array.length; i++) {
            int index = 0;
            if (array[i]%2 == 0 && i < array.length-1){
                for (int j = i+1; j < array.length; j++) {
                    if (array[j]%2 != 0){
                        for (int k = 0; k <= index; k++) {
                            temp = array[j-k];
                            array[j-k] = array[j-k-1];
                            array[j-k-1] = temp;
                        }
                        break;
                    }
                    index++;
                }
            }
        }
    }

}
