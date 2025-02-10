package basic;

import java.util.ArrayDeque;
import java.util.Scanner;

public class S5_9012_stack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T  = sc.nextInt();
        for (int i = 0; i < T; i++) {
            String str = sc.next();
            if(solution(str)) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    public static boolean solution(String str){
        char[] arr = str.toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int j = 0; j < arr.length; j++) {
            if(arr[j] == '(') stack.push(arr[j]);
            else{
                if(stack.isEmpty() || stack.pop() == arr[j]){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}