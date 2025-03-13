//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class S2_1654_랜선자르기 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int K = Integer.parseInt(st.nextToken());
//        int N = Integer.parseInt(st.nextToken());
//        int sum = 0;
//        int[] arr = new int[K];
//
//        for (int i = 0; i < K; i++) {
//            arr[i] = Integer.parseInt(br.readLine());
//            sum += arr[i];
//        }
//
//        Arrays.sort(arr);
//
//        if(arr[0] < sum/N)
//    }
//}