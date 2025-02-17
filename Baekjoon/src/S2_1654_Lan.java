import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class S2_1654_Lan {
    static int K, N;
    static long left, right, mid;
    static int[] input;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        input = new int[K];

        for (int i = 0; i < K; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        // 풀이
        // N 길이 1 ~ 가장 큰 값

        Arrays.sort(input);

        left = 1; // 길이 최소
        right = input[K-1]; // 길이 최대

        while( left <= right ) {
            long count = 0;

            // 중간값으로 계산
            mid = (left + right ) / 2;

            // 모든 K 개에 대해서 mid 로 잘라 본다.
            for (int i = 0; i < K; i++) {
                count += ( input[i] / mid ); // 나눈 몫 0, 1.7 = 1, 2.3 = 2
            }

            if( count >= N ) { // N 개 보다 더 많이 만드는 게 아니고 가장 큰 N 개
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        System.out.println(right);
//      System.out.println(left - 1);
    }
}

