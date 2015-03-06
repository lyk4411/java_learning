package jdk5newfeature;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


//�������ע���������������������ʱ��    
@Retention(RetentionPolicy.RUNTIME)
// ����ע��ķ���λ��
@Target({ ElementType.TYPE, ElementType.METHOD })
// �Զ���ע��
public @interface ItcastAnnotation1 {
	// ��������
	String str();

	int val() default 1;

	int[] arr() default { 2, 3, 4 };

	Class cls() default AnnotionTest.class;

	EnumText.TrafficLamp lamp() default EnumText.TrafficLamp.YELLOW;

	MetaAnnotation annotation() default @MetaAnnotation("sss");
}