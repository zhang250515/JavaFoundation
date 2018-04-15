package onlineCoding;

import java.util.ArrayList;

/**
 * Created by ZhangQ on 2018/3/7.
 * 1.数字货币转换成中文显示
 * 2.质数分解
 */
public class DuoYi {

    private static String[] s = new String[15];
    static {
        s[0] = "零";
        s[1] = "壹";
        s[2] = "贰";
        s[3] = "叁";
        s[4] = "肆";
        s[5] = "伍";
        s[6] = "陆";
        s[7] = "柒";
        s[8] = "捌";
        s[9] = "玖";
        s[10] = "拾";
        s[11] = "佰";
        s[12] = "仟";
        s[13] = "万";
        s[14] = "亿";
    }
    public static String toRMB(long money){
        double temp;
        int p;
        int[] q = new int[11];
        StringBuilder rmb = new StringBuilder();
        for (int i = 10; i >=0 ; i--) {
            temp = money / Math.pow(10,i);
            p = (int) temp;
            money -= p* Math.pow(10,i);
            q[10-i] = p;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int a : q){
            if (list.size() == 0 && a == 0)
                continue;
            list.add(a);
        }
        System.out.println(list);
        int size = list.size();
        System.out.println(size);
        for (int i = size; i >= 0; i--) {
            int b = size-i-1;
            if(i==10) rmb.append(s[list.get(b)]).append(s[11]).append(s[14]);
            if(i==9) rmb.append(s[list.get(b)]).append(s[10]).append(s[14]);
            if(i==8) rmb.append(s[list.get(b)]).append(s[14]);
            if(i==7) rmb.append(s[list.get(b)]).append(s[12]).append(s[13]);
            if(i==6) rmb.append(s[list.get(b)]).append(s[11]).append(s[13]);
            if(i==5) rmb.append(s[list.get(b)]).append(s[10]).append(s[13]);
            if(i==4) rmb.append(s[list.get(b)]).append(s[13]);
            if(i==3) rmb.append(s[list.get(b)]).append(s[12]);
            if(i==2) {
                rmb.append(s[list.get(b)]).append(s[11]);
            }
            if(i==1) {
                rmb.append(s[list.get(b)]);
                if (b!=0) rmb.append(s[10]);
            }
            if(i==0) rmb.append(s[list.get(b)]);
        }
        rmb.append("圆");
        return rmb.toString();
    }

    public static String prime(int a){
        StringBuilder s = new StringBuilder();
        s.append(a).append("=");
        for (int i = 2; i <= a; i++) {
            while (a!=i){
                if (a%i == 0){
                    a = a / i;
                    s.append(i).append("*");
                }
                else break;
            }
        }
        s.append(a);
        return s.toString();
    }
    public static void main(String[] args) {
        System.out.println(prime(21));
    }
}
