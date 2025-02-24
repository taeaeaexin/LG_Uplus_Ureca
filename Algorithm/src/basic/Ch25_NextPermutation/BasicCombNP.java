package basic.Ch25_NextPermutation;

import java.util.Arrays;

// 조합인데 NP 를 이용, 전체 중 일부를 뽑는 조합에 적용 가능
public class BasicCombNP {

    static int[] src = {1, 2, 3, 4, 5};
    static int[] tgt = new int[3];  // __ __ __  <= 현재 자리를 채우기 위해, src 의 맨 앞에서부터 수를 선택/비선택 해가면서 tgt 개수를 채운다.
    static int[] index = new int[src.length];

    public static void main(String[] args) {
        // 00000
        // 00111 ------> 11100

        // tgt 의 1 만큰 index 배열의 뒤부터 채운다.
        for (int i = src.length - tgt.length; i < src.length; i++) {
            index[i] = 1;
        }

        System.out.println(Arrays.toString(index));

        while(true) {
            // 조합이 완성된 후 수행 코드
            int tgtIdx = 0;
            for (int i = 0; i < index.length; i++) {
                if( index[i] == 1 ) { // i 가 선택된 항목의  index
                    tgt[tgtIdx++] = src[i];
                }
            }

            System.out.println(Arrays.toString(index) + " : " + Arrays.toString(tgt));

            if( ! np(index) ) break;
        }
    }

    static boolean np(int[] array) {
        // 3
        // 맨 뒤에서 출발
        int i = array.length - 1;

        // 뒤보다 앞이 크거나 같으면( 내림차순으로 정렬되어 있으면 ) 계속 가다가 그렇지 않으면 멈춘다.
        // 5 <-- 4 <-- 2 까지는 계속
        // 1 X 5 <-- 4 <-- 2
        while( i > 0 && array[i-1] >= array[i] ) --i;

        // 맨 앞까지 왔으면 종료
        if( i == 0 ) return false;

        // 현재 src[i-1] 이 src[i] 보다 작은 상태
        // src[i] 이후 항목 (src[i] 보다 작은) 과 src[i-1]과 비교 필요

        // 맨 뒤에서 출발
        int j = array.length - 1;
        // i 이전 항목 중 src[i-1] 보다 작은 것은 무시하고, 큰 것이 있으면 멈춤
        //  만약 큰 것이 있으면 그것과  없으면 src[i] 와 교환
        while( array[i-1] >= array[j]) --j;
        swap( array, i-1, j );

        // i 부터 맨 뒤까지 reverse
        int k = array.length - 1;
        while( i < k ) {
            swap(array, i++, k--);
        }
        return true;

    }
    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}