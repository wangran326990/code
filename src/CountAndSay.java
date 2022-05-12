public class CountAndSay {
    public static void main(String[] args) {
        countAndSay(4);
    }

    public static String countAndSay(int n) {
        String base = "1";
        for(int i = 0; i < n -1; i++) {
            String say = base;
            int k = 0;
            base = "";
            while(k < say.length()) {
                char baseChar = say.charAt(k);
                int count = 0;
                for(int j = k; j < say.length(); j++) {
                    char current = say.charAt(j);
                    if(current == baseChar) {
                        count++;
                        k++;
                    }else {
                        break;
                    }
                }
                base += count + "" + baseChar + "";
            }
        }
        return base;
    }
}
