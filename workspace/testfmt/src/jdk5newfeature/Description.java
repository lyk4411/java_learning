package jdk5newfeature;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
// �����עӦ������
@Retention(RetentionPolicy.RUNTIME)
// ��ע��һֱ����������ʱ
@Documented
// ����ע�������javadoc��
public @interface Description {
	String value();
}