import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class S4_4949_균형잡힌세상 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();
            if (str.equals(".")) break;

            Stack<Character> stack = new Stack<>();
            boolean flag = true;

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                if (ch == '(' || ch == '[') {
                    stack.push(ch);
                } else if (ch == ')' || ch == ']') {
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                    char top = stack.pop();
                    if ((top == '(' && ch != ')') || (top == '[' && ch != ']')) {
                        flag = false;
                        break;
                    }
                }
            }

            if (!stack.isEmpty()) flag = false;

            System.out.println(flag ? "yes" : "no");
        }
    }
}
