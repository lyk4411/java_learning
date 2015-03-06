package jdk5newfeature;

@ItcastAnnotation()
public class AnnotionTest {
	@SuppressWarnings("deprecation")
	@ItcastAnnotation()
	public static void main(String[] args) {
		System.runFinalizersOnExit(true);
		// ���䷽ʽ�鿴ע��
		// ��������Ƿ���ע��
		if (AnnotionTest.class.isAnnotationPresent(ItcastAnnotation.class)) {
			// ͨ�������ȡ��ע��
			ItcastAnnotation annotation = AnnotionTest.class
					.getAnnotation(ItcastAnnotation.class);
			System.out.println(annotation);
		}
	}
}