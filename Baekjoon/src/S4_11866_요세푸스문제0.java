import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class S4_11866_요세푸스문제0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        Deque<Integer> queue = new ArrayDeque<>();

        int count = 1;
        int depth = 0;
        for (int i = 1; i <= N; i++) {
            queue.addLast(i);
        }
        while(!queue.isEmpty()){
            if(count == K){
                arr[depth] = queue.pollFirst();
                depth++;
                count = 1;
            }else{
                queue.addLast(queue.pollFirst());
                count++;
            }
        }
        System.out.print("<");
        for (int i = 0; i < N; i++) {
            if(i == N-1) System.out.print(arr[i]+">");
            else System.out.print(arr[i]+", ");
        }
    }
}