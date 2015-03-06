package jdk5newfeature;

@ItcastAnnotation()
public class AnnotionTest {
	@SuppressWarnings("deprecation")
	@ItcastAnnotation()
	public static void main(String[] args) {
		System.runFinalizersOnExit(true);
		// 反射方式查看注解
		// 检查类上是否有注解
		if (AnnotionTest.class.isAnnotationPresent(ItcastAnnotation.class)) {
			// 通过反射获取到注解
			ItcastAnnotation annotation = AnnotionTest.class
					.getAnnotation(ItcastAnnotation.class);
			System.out.println(annotation);
		}
	}
}