import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class S2_1874_스택수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        Queue<Character> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 1;
        boolean flag = true;

        for (int i = 0; i < n; i++) {
            int target = arr[i];

            while (cnt <= target) {
                stack.push(cnt);
                q.offer('+');
                cnt++;
            }

            if (!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                q.offer('-');
            } else {
                flag = false;
                break;
            }
        }

        if (flag) {
            for (char print:q) {
                System.out.println(print);
            }
        } else {
            System.out.println("NO");
        }
    }
}