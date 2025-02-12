package basic.Ch14_Bitmask;

// 전체 부분집합을 재귀호출의 과정에서 완성하지 않고, bit 연산을 통해 한 꺼번에 전체부분집합을 만든 뒤에 반복문으로 처리
public class BasicSubsetBinaryCounting {

    static int[] src = {1, 2, 3, 4, 5};
    // 00000 ~> 11111 까지 만드는 모든 수가 바로 부분집합 1개 의미
    static int subsetCnt = 1 << src.length;
    public static void main(String[] args) {
        System.out.println(subsetCnt);  // 32

        // i 의 범위 : 00000 ~> 11111
        // i 는 0 ~ 31 의 정수가 되는 데, 이 각각의 i 가 바로 모든 부분집합의 BitMask 역할
        for (int i = 0; i < subsetCnt; i++) {
//			System.out.println(i + " => [" + Integer.toBinaryString(i) +  "]");

            for (int j = 0; j < src.length; j++) {
                if( (i & 1 << j) != 0 ) System.out.print(src[j] + " ");
            }

            System.out.print(" => " + i + " => [" + Integer.toBinaryString(i) +  "]");
            System.out.println();
        }
    }

}