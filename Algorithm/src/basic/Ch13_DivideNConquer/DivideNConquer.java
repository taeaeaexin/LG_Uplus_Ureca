package basic.Ch13_DivideNConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 반복문
public class DivideNConquer {
    static int N, r, c, ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        // 풀이
        N = (int) Math.pow(2, N); // 2의 제곱수이므로 계속 반으로 나눌 수 있다.

        // 원점 초기화
        int y = 0;
        int x = 0;

        while( true ) {

            if( N == 1 ) break;


            N /= 2;

            // r,c 가 4개의 영역 중 어디에 있는 지 판단
            if( r < y + N && c < x + N ) { // 상좌
                ;
            }else if( r < y && c >= x + N ) { // 상우
                ans += N * N * 1;
                x += N; // 원점 우로 이동
            }else if( r >= y + N && c < x + N ) { // 하좌
                ans += N * N * 2;
                y += N; // 원점 하로 이동
            }else {
                ans += N * N * 3;
                y += N; // 원점 하로 이동
                x += N; // 원점 우로 이동
            }
        }

        System.out.println(ans);
    }
}

