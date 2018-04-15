package chapter2;

/**
 * Created by ZhangQ on 2018/3/5.
 * 利用多态改变初始化次序
 */
class Base {
    int num = 1;
    public Base(){
        this.print();
        num = 2;
    }

    public void print(){
        System.out.println("Base.num="+num);
    }
}

class Sub extends Base{
    int num = 3;
    public Sub(){
        this.print();
        num = 4;
    }
    public void print(){
        System.out.println("Sub.num="+num);
    }
}

public class Test{
    public Test(){
        System.out.println("no args");
    }
    public Test(int a){
        System.out.println(a);
    }
    public static void main(String[] args) {
        Base b = new Sub();
        System.out.println(b.num);
        Test t = new Test(1);
        System.out.println(100*(1.0/5));
    }
}
