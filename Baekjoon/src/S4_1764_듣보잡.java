import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_1764_듣보잡 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayDeque<String> arr = new ArrayDeque<>();
        String[] name = new String[N];

        int count = 0;

        for (int i = 0; i < N; i++) name[i] = br.readLine();
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if(Arrays.asList(name).contains(str)){
                arr.add(str);
                count++;
            }
        }

        System.out.println(count);
        while (!arr.isEmpty()){
            System.out.println(arr.poll());
        }
    }
}
