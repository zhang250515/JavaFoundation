package AdvancedFeature.annotation01;

/**
 * Created by ZhangQ on 2018/4/5.
 */
public class BusinessCode {

    @MyAnnotation(author = "ken",status = MyAnnotation.Status.STARTED)
    public void testAnnotation(){
        System.out.println("annotation");
    }
}
