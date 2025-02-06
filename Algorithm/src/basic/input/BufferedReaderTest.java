package basic.input;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BufferedReaderTest {
    public static void main(String[] args) throws Exception {
        //BufferedReader(InputStreamReader())
        //단점 : 처리 코드 Scanner에 비해 다소 복잡
        //장점 : 매우 빠른 성능 보장

        //1 2 3 4 5
//        {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            String str = br.readLine();
//
//            int[] input = new int[5];
//            StringTokenizer st = new StringTokenizer(str);
//
//            for (int i = 0; i < 5; i++) {
//                input[i] = Integer.parseInt(st.nextToken());
//            }
//
//            System.out.println(Arrays.toString(input));
//        }

        //1 A 3 B 5
//        {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            String str = br.readLine();
//
//            char[] input = new char[5];
//            StringTokenizer st = new StringTokenizer(str);
//
//            for (int i = 0; i < 5; i++) {
//                input[i] = st.nextToken().charAt(0);
//            }
//
//            System.out.println(Arrays.toString(input));
//        }

        //ABCDE
//        {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            String str = br.readLine(); //"ABCDE"
//
//            char[] input = str.toCharArray();
//
//            System.out.println(Arrays.toString(input));
//        }

        //5
        //ABCDE
//        {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            int N = Integer.parseInt(br.readLine());
//            char[] input = br.readLine().toCharArray();
//
//            System.out.println(N);
//            System.out.println(Arrays.toString(input));
//        }

        //첫 라인에서 읽은 N만큼 가로 세로가 N인 2차원 배열
//        {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            int N = Integer.parseInt(br.readLine());
//
//            int[][] input = new int[N][N];
//
//            for (int i = 0; i < N; i++) {
//                String str = br.readLine();
//                StringTokenizer st = new StringTokenizer(str);
//                for (int j = 0; j < N; j++) {
//                    input[i][j] = Integer.parseInt(st.nextToken());
//                }
//            }
//            System.out.println(N);
//
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < N; j++) {
//                    System.out.print(input[i][j]+" ");
//                }
//                System.out.println();
//            }
//        }
        //첫 줄에 가로, 세로 각각 주어졌을 때
//        {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            int N = Integer.parseInt(br.readLine());
//            int M = Integer.parseInt(br.readLine());
//
//            int[][] input = new int[N][M];
//
//            for (int i = 0; i < N; i++) {
//                String str = br.readLine();
//                StringTokenizer st = new StringTokenizer(str);
//                for (int j = 0; j < M; j++) {
//                    input[i][j] = Integer.parseInt(st.nextToken());
//                }
//            }
//            System.out.println(N+"X"+M);
//
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < M; j++) {
//                    System.out.print(input[i][j]+" ");
//                }
//                System.out.println();
//            }
//        }

        //출력에 대한 자료구조
        //입력 자료 >> 출력 자료
        //출력 자료구조가 간단한 정수정도면 별도의 자료 구조 X
        //출력이 문자열이고 크기가 계속 증가한다
        // -BufferedWriter : 코드가 길다
        // -StringBuilder : 코드가 짧다
    }
}