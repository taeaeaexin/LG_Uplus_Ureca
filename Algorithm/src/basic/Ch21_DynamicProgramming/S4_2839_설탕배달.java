package basic.Ch21_DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;
// DP
// N 을 만들기 위해 사용할 수 있는 수는 3, 5 2가지
// N <= N-3 에서 3을 쓰는 방법 <= N-3 을 만드는 데 사용한 최소 봉지 수
//   <= N-5 에서 5를 쓰는 방법 <= N-5 를 만드는 데 사용한 최소 봉지 수
//   중 최소값을 선택 + 1
// 초기값
// 3 <= 1 봉지, 5 <= 1 봉지
// 만들지 못하는 무게 ??
//   6 를 만들려면  6-5 한 1에서 5를 사용하는 방법, 6-3 한 3에서 3을 사용하는 방법
//   만들지 못하는 무게는 최소값 선태에서 제외되도록 <= 충분히 큰 수로 변경
public class S4_2839_설탕배달 {
    static int[] memoi; // n kg 을 만드는 데 드는 최소 봉지 수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 문제로부터 파악된 작은 수 미리
        if( N <= 5 ) {
            if( N == 3 || N == 5 ) System.out.println(1);
            else System.out.println(-1);
            return;
        }

        memoi = new int[N + 1];
        Arrays.fill(memoi, 5000); // 최소값 비교가 유효하기 위해 충분히 큰 값으로 초기화

        // 초기값 설정
        memoi[3] = 1;
        memoi[5] = 1;

        for (int i = 6; i <= N; i++) {
            memoi[i] = Math.min(memoi[i-3] + 1, memoi[i-5] + 1);
        }

        if( memoi[N] >= 5000 ) System.out.println(-1);
        else System.out.println(memoi[N]);
    }
}
