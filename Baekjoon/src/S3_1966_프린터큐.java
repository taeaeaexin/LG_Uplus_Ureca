import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class S3_1966_프린터큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            LinkedList<int[]> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                queue.add(new int[]{j, Integer.parseInt(st.nextToken())});
            }

            int count = 0;
            while (!queue.isEmpty()) {
                int[] first = queue.poll();
                boolean isMax = true;

                for (int[] q : queue) {
                    if (first[1] < q[1]) {
                        queue.offer(first);
                        isMax = false;
                        break;
                    }
                }

                if (!isMax) {
                    continue;
                }

                count++;
                if (first[0] == M) {
                    break;
                }
            }
            System.out.println(count);
        }
    }
}