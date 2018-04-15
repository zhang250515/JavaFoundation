package AdvancedFeature.annotation01;

import java.lang.reflect.Method;

/**
 * Created by ZhangQ on 2018/4/5.
 */
public class TestMyAnnotation {

    public static void main(String[] args) {
        Class code = BusinessCode.class;
        for (Method method : code.getMethods()){
            MyAnnotation annotation =  method.getAnnotation(MyAnnotation.class);
            if (annotation!=null){
                System.out.println(annotation.author());
                System.out.println(annotation.status());
            }
        }
    }
}
