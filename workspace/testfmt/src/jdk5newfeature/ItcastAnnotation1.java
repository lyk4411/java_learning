package jdk5newfeature;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


//将定义的注解的生命周期设置在运行时期    
@Retention(RetentionPolicy.RUNTIME)
// 定义注解的放置位置
@Target({ ElementType.TYPE, ElementType.METHOD })
// 自定义注解
public @interface ItcastAnnotation1 {
	// 定义属性
	String str();

	int val() default 1;

	int[] arr() default { 2, 3, 4 };

	Class cls() default AnnotionTest.class;

	EnumText.TrafficLamp lamp() default EnumText.TrafficLamp.YELLOW;

	MetaAnnotation annotation() default @MetaAnnotation("sss");
}