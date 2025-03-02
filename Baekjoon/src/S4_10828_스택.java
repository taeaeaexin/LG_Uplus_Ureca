import java.util.Scanner;
import java.util.Stack;

public class S4_10828_스택 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            switch(str) {
                case "push" :
                    int num = sc.nextInt();
                    stack.push(num);
                    break;
                case "pop" :
                    if(stack.isEmpty()) System.out.println(-1);
                    else System.out.println(stack.pop());
                    break;
                case "size" :
                    System.out.println(stack.size());
                    break;
                case "empty" :
                    if(stack.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;
                case "top" :
                    if(stack.isEmpty()) System.out.println(-1);
                    else System.out.println(stack.peek());
                    break;
            }
        }
    }
}