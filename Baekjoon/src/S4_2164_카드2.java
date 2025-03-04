import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class S4_2164_카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) q.add(i);

        while(q.size() > 1) {
            q.poll();
            if(q.size() > 1) q.add(q.poll());
            else break;
        }

        System.out.println(q.peek());

    }
}