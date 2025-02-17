import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Test2 {

    static int T, N, M, ans;
    static int[][] memoi;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            memoi = new int[M + 1][N + 1]; // 0 dummy,
            System.out.println( comb(M, N) ); // 구하고자 하는 큰 수를 전달, 재귀 과정에서 점점 작은 수를 처리
        }
    }

    static int comb(int n, int r) {

        if( n == r || r == 0 ) { // 파스칼 삼각형을 생각해 보면 맨 앞과 맨뒤 4C1 4C4
            return memoi[n][r] = 1;
        }
        // 이미 계산된 것 활용
        if( memoi[n][r] > 0 ) {
            return memoi[n][r];
        }
        // nCr
        // 한 개를 고정하면 아래 두 경의 합이 nCr 이다.
        //   그 한 개가 포함되는 경우 => n-1 개에서 r-1 개를 뽑는 경우의 수
        //   그 한 개가 포함되지 않는 경우 의 합 => n-1 개에서 r 개를 뽑는 경우의 수
        return memoi[n][r] = comb(n-1, r-1) + comb(n-1, r);
    }
}
