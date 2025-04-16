import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class S2_1927_최소힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        while(N-- > 0){
            int n = Integer.parseInt(br.readLine());
            if(n == 0) {
                if(queue.isEmpty()) System.out.println(0);
                else System.out.println(queue.poll());
            }
            else queue.add(n);
        }
    }
}
