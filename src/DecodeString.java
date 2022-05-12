import java.util.Stack;

class DecodeStringSolution {
    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        decodeString.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef");
    }
}


public class DecodeString {
    public String decodeString(String s) {
        Stack<String> stack =new Stack<>();
        for(char ch : s.toCharArray()) {
            if(ch != ']') {
                stack.push(ch+"");
            }else {
                String sb = "";
                while(!stack.peek().equals("[")) {
                    sb = stack.pop()+sb;
                }
                stack.pop();
                String countStr = "";

                while(!stack.isEmpty() && stack.peek().length() == 1 && Character.isDigit(stack.peek().charAt(0))) {

                    countStr = stack.pop() + countStr;
                }
                int count = Integer.valueOf(countStr);
                String subStrBuilder = "";

                for(int i = 0; i < count; i++) {
                    subStrBuilder += sb;
                }

                stack.push(subStrBuilder);
            }
        }
        String result = "";
        while(!stack.isEmpty()) {
            result = stack.pop() + result;
        }
        return result;
    }
}