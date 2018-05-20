package algorithm;

import org.junit.Test;

/**
 * Created by ZhangQ on 2018/3/20.
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] a = {3,2,1};
        // insertion(a);
        //shellSort(a);
        //simpleSelectionSort(a);
        SimpleSelectionSort01(a);
        for (int i : a){
            System.out.println(i);
        }
    }

    private static void insertion(int[] a){
        if (a.length < 2) return;
        int temp,j;
        for (int i = 1; i < a.length; i++) {
            temp = a[i];
            j=i;
            while ( j>0 && temp<a[j-1]){
                a[j] = a[j-1];
                j--;
            }
            a[j] = temp;
        }
    }

    private static void shellSort(int[] a){
        int j,temp;
        for (int gap = a.length/2; gap > 0; gap /= 2) {
            for (int k = gap; k < a.length; k++) {
                temp = a[k];
                for (j=k;j>0 && temp<a[j-gap];j -= gap){
                    a[j] = a[j-gap];
                }
                a[j] = temp;
            }
        }
    }

    private static void simpleSelectionSort(int[] a){
        int temp,p;
        for (int i = 0; i < a.length; i++) {
            temp = i;
            for (int j = i; j < a.length; j++) {
                if (a[j] < a[temp]) temp = j;
            }
            p = a[i];
            a[i] = a[temp];
            a[temp] = p;
        }
    }

    private static void SimpleSelectionSort01(int[] a){
        int temp,min,max;
        for (int i = 0; i < a.length/2; i++) {
            min = i; max = i;
            for (int j = i+1; j < a.length-i; j++) {
                if (a[j]>a[max]){
                    max = j; continue;
                }
                if (a[j]<a[min]){
                    min = j;
                }
            }
            if (min!=i){
                temp = a[i];a[i] = a[min]; a[min] = temp;
            }
            if (max!=i) {
                temp = a[a.length - i - 1];
                a[a.length - i - 1] = a[max];
                a[max] = temp;
            }
        }
    }

    private void bubboSort(int[] a){
        if (a.length<2)
            return;
        int modCount = 0;
        int temp;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length-i-1; j++) {
                if (a[j]>a[j+1]){
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    modCount++;
                }
            }
            if (modCount == 0)
                return;
            else modCount=0;
        }
    }

    @Test
    public void testSort(){
        int[] a = {3,2,1};
        bubboSort(a);
        for (int i : a){
            System.out.println(i);
        }
    }
}
