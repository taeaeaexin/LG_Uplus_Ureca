import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_2805_나무자르기 {
    static int N, M;
    static int[] tree;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tree = new int[N];

        int max = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            if (tree[i] > max) max = tree[i];
        }

        cutTree(0, max);
        System.out.println(result);
    }

    public static void cutTree(int low, int high) {
        if (low > high) return;

        int mid = (low + high) / 2;
        long sum = 0;
        for (int i = 0; i < N; i++) {
            if (tree[i] > mid) {
                sum += tree[i] - mid;
            }
        }

        if (sum >= M) {
            result = mid;
            cutTree(mid + 1, high);
        } else {
            cutTree(low, mid - 1);
        }
    }
}