package algorithm;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ZhangQ on 2018/3/20.
 */
public class Ch01 {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        System.out.println(kMax01(1,a));
        System.out.println(kMax02(1,a));
    }

    /**
     * @author  ZhangQ
     * 找出第k个最大的数
     * planA 先做排序，然后找到下标是k-1的数 插入法排序
     * planB 先对前k个树排序，然后依次插入到有序序列b中，取第k个
     */
    private static int kMax01(int k,int[] a){
        int temp,j;
        for (int i = 1; i < a.length; i++) {
            temp = a[i];
            for (j=i; j>0 && temp>a[j-1]; j--) {
                a[j] = a[j-1];
            }
            a[j] = temp;
        }
        return a[k-1];
    }
    private static int kMax02(int k,int[] a){
        int[] b = Arrays.copyOf(a,k);
        int temp,j;
        for (int l = 1; l < b.length; l++) {
            temp = b[l];
            for (j=l;j>0 && temp>b[j-1]; j--) {
                b[j] = b[j-1];
            }
            b[j] = temp;
        }
        if (a.length>k)
        for (int i = k; i < a.length; i++) {
            if (a[i]>b[k-1]){
                int l;
                for (l=k-1; l>0 && a[i]>b[l]; l--) {
                    b[l] = b[l-1];
                }
                b[l] = a[i];
            }
        }
        return b[k-1];
    }
    @Test
    public void testCopyOf(){
        int[] a = {1,2,3};
        int[] b = Arrays.copyOf(a,2);
        for (int i : b){
            System.out.println(i);
        }
        System.out.println(Arrays.toString(b));
    }
}
