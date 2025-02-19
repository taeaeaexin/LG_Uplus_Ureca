package basic.Ch21_DynamicProgramming;

public class fibonacci {
    public static void main(String[] args) {
        //#1 재귀 호출
        System.out.println(fibo_rc(20)); //오래 걸림

        //#2 메모이제이션
        System.out.println(fibo_rc_memoi(50));

        //#3 동적 계획법 (점화식 + 메모이제이션)
        System.out.println(fibo_dp(50));
    }

    public static long fibo_rc(int n){
        if(n == 1 || n == 2) return 1;
        return fibo_rc(n-1) + fibo_rc(n-2);
    }

    static long[] memoi_rc = new long[51];
    public static long fibo_rc_memoi(int n) {
        if(n == 1 || n == 2) return 1;
        if(memoi_rc[n] > 0) return memoi_rc[n];
        else return memoi_rc[n] = fibo_rc_memoi(n-1) + fibo_rc_memoi(n-2);
    }

    static long[] memoi_dp = new long[51];
    public static long fibo_dp(int n) {
        if(n == 1 || n == 2) return 1;

        memoi_dp[1] = 1;
        memoi_dp[2] = 1;

        for (int i = 3; i <= n ; i++) {
            memoi_dp[i] = memoi_dp[i-1] + memoi_dp[i-2];
        }

        return memoi_dp[n];
    }
}

//완탐 문제에서 시간초과가 발생하는 경우
// 1. 가지치기 (갈 필요 없는 반복 탐색)
// 2. 메모이제이션 (반복적으로 수행되는 탐색)

// dp 풀이는 문제에서 점화식을 파악해야 적용할 수 있다.
// 현재 상태 => 미래 상태 고민 X
// 과거 상태 => 현재 상태 고민 O
// 점화식은 항상 이전 상태가 현재 상태를 만들 지 못할 수도 있다. dp 로 7 번째 답을 dp 의 6 번째로 만들 지 못하는 경우도 있다.