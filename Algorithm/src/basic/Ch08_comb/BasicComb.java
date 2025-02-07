package basic.Ch08_comb;

import java.util.Arrays;

public class BasicComb {

    //기본 조합
    static int[] src = {1, 2, 3, 4, 5};
    static int[] tgt = new int[3]; //__ __ __ <= 현재 자리를 채우기 위해, src의 맨 앞에서부터 수를 선택/비선택 해가면서 tgt 개수를 채운다.
    //이전에 사용된 수 고려 X <= select 배열 X

    public static void main(String[] args) {
        comb(0, 0);
    }

    //조합
    //src의 srcIdx 자리의 수를 tgtIdx 자리에 선택? 비선택?
    static void comb(int srcIdx, int tgtIdx) {
        //기저조건
        if(tgtIdx == tgt.length) {
            System.out.println(Arrays.toString(tgt));
            return;
        }
        if(srcIdx == src.length) return; //기저조건 1개 더

        tgt[tgtIdx] = src[srcIdx]; //선택
        comb(srcIdx + 1, tgtIdx + 1); //위 선택을 받아들이고 다음 자리로 재귀호출
        comb(srcIdx + 1, tgtIdx); //위 선택을 받아들이지 않고 srcIdx만 증가시키는 효과
    }
}