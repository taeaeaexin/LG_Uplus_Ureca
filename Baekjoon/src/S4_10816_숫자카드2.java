import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_10816_숫자카드2 {
    static int N, M;
    static int[] card;
    static int[] number;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        card = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        number = new int[M];
        result = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(card);

        for (int i = 0; i < M; i++) {
            result[i] = high(number[i]) - low(number[i]);
        }

        for (int i = 0; i < M; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static int low(int target) {
        int start = 0, end = N;
        while (start < end) {
            int mid = (start + end) / 2;
            if (card[mid] >= target) end = mid;
            else start = mid + 1;
        }
        return start;
    }

    public static int high(int target) {
        int start = 0, end = N;
        while (start < end) {
            int mid = (start + end) / 2;
            if (card[mid] > target) end = mid;
            else start = mid + 1;
        }
        return start;
    }
}
