package basic.Ch14_Bitmask;

import java.util.Arrays;

public class BasicPermBitMask {

    // 기본 순열
    static int[] src = {1, 2, 3, 4, 5};
    static int[] tgt = new int[3];  // __ __ __  <= 현재 자리를 채우기 위해 src 전체를 고려하되, 현재 자리 이전 자리에 사용된 수 제외
    // 사용 X
//	static boolean[] select = new boolean[src.length]; // _f_  _t_  _f_  _t_  _f_

    public static void main(String[] args) {
        perm(0, 0);  // 두 번재 파라미터로 bitmask 전달 0000 0000

    }

    // mask 는 이전 단계까지의 선택 비선택이 표현
    static void perm(int tgtIdx, int mask) { // 31 bit mask 표현
        // 기저조건
        // 이 조건 이전의 재귀호출로 이미 tgt 배열이 완성
        if( tgtIdx == tgt.length ) {
            System.out.println(Arrays.toString(tgt));
            return;
        }

        // 현재 파라미터로 넘어온 tgtIdx 자리에 src 로부터 채울 수를 선택,고려
        // src 전체를 대상으로 하되, select 배열에 사용중인 것은 제외
        for (int i = 0; i < src.length; i++) {
            // 앞자리에 사용된 수이면 skip
            if( ( mask & 1 << i ) != 0  ) continue; // i = 3    0000 0001 => 0000 1000
            // 0000 1000
            // 0001 0100
            // -----------
            // 0000 0000
            tgt[tgtIdx] = src[i]; // 선택

//			select[i] = true; // 선택 표시
            perm(tgtIdx + 1, mask | 1 << i ); // 다음 자리를 위한 재귀 호출
            // 원복 X : 전역변수가 아닌 파라미터 복사 전달
        }
    }

}