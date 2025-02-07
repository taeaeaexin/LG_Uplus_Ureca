package basic.Ch03_input;

import java.util.Arrays;
import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        //Scanner
        //편리하나 상대적(java.io)으로 무겁다
        //매우 간단한 입력 처리에만 사용

        //1 A 2 B 3 <= 문자
//        {
//            Scanner sc = new Scanner(System.in);
//            char[] input = new char[5];
//
//            for (int i = 0; i < 5; i++) {
//                input[i] = sc.next().charAt(0); //"1" -> '1'
//            }
//            System.out.println(Arrays.toString(input));
//        }

//        //ABCDE <= 연속된 문자
//        {
//            Scanner sc = new Scanner(System.in);
////            char[] input = new char[5]; //불필요한 garbage 생산
//            char[] input;
//
//            //한 줄 전체를 읽는다. 읽은 문자열은 char 배열로 변환
//            input = sc.nextLine().toCharArray(); //배열을 새로 생성해서 return
//
//            System.out.println(Arrays.toString(input));
//        }

        //5
        //1 2 3 4 5
//        {
//            Scanner sc = new Scanner(System.in);
//            int N = sc.nextInt();
//            int[] input = new int[N]; //위에 읽은 수만큼 배열 생성
//            for (int i = 0; i < N; i++) {
//                input[i] = sc.nextInt();
//            }
//            System.out.println(N);
//            System.out.println(Arrays.toString(input));
//        }

        //5[개행]
        //A B C D E
        //next(), nextInt()는 개행문자를 포함하지 않는다
        //nextLine()은 개행문자를 만나면 읽는 처리는 종료
        {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            sc.nextLine(); //5 뒤의 개행 처리
            char[] input = sc.nextLine().toCharArray();

            System.out.println(N);
            System.out.println(Arrays.toString(input));
        }
    }
}