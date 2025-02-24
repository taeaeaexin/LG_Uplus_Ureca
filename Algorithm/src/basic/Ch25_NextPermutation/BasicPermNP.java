package basic.Ch25_NextPermutation;

import java.util.Arrays;

// NP : 일부 추출 X, 전체 순열만 빠르게!
//      항상 가장 작은 수부터 출발해서 가장 큰수를 만드는 과정
// while 포함 np() swap() 이용
public class BasicPermNP {

    // 기본 순열
    static int[] src = {3, 1, 5, 4, 2};


    public static void main(String[] args) {
        // 가장 작은 수로 대상을 정렬
        Arrays.sort(src); // 순열의 경우의 수 중 하나

        // 시작은 1 2 3 4 5
        while(true) {
            // 완성된 순열로 처리 코드
            System.out.println(Arrays.toString(src));

            if( ! np( src ) ) break; // 가장 큰 수( 5 4 3 2 1 )이면 종료
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