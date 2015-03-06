
public class Caesar {
        public static void encode (char[] text) {
              	char ch;
        		for (int i = 0; i < text.length ; i++) {
                        ch = (char) ((text[i] + 3 - 'a') % 26 + 'a');        //每个字符往后推3位，如果是 x y z 就回头开始
                        text[i]=ch;
                }
        }

        public static void main (String args[]) {
                String text = "helloworld";
                encode(text.toCharArray());
                System.out.println(new String(text));
        }
}