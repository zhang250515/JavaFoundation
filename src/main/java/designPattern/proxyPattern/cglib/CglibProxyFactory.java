package designPattern.proxyPattern.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by ZhangQ on 2018/4/4.
 */
public class CglibProxyFactory implements MethodInterceptor {

    private Object target;
    public CglibProxyFactory(Object target){
        this.target = target;
    }

    //给目标对象创建代理对象
    public Object getProxyInstance(){
        //1.工具类
        Enhancer en = new Enhancer();
        //2.设置父类，由于是子类代理，所以父类是目标对象的类
        en.setSuperclass(target.getClass());
        //3.设置回调函数
        en.setCallback(this);
        //4.创建子类（代理对象）
        return en.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib proxy");

        return method.invoke(target,objects);
    }
}
