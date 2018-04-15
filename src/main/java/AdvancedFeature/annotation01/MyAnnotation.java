package AdvancedFeature.annotation01;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by ZhangQ on 2018/4/5.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
     enum Status {STARTED,NOT_STARTED}
     String author() default "kent";
     Status status() default Status.STARTED;
}
