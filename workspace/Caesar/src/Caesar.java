
public class Caesar {
        public static void encode (char[] text) {
              	char ch;
        		for (int i = 0; i < text.length ; i++) {
                        ch = (char) ((text[i] + 3 - 'a') % 26 + 'a');        //ÿ���ַ�������3λ������� x y z �ͻ�ͷ��ʼ
                        text[i]=ch;
                }
        }

        public static void main (String args[]) {
                String text = "helloworld";
                encode(text.toCharArray());
                System.out.println(new String(text));
        }
}