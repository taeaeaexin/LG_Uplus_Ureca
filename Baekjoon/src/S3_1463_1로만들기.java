import java.io.*;

public class S3_1463_1로만들기 {
    public static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(divide(N, 0));
    }

    public static int divide(int x, int count){
        if(x < 2) return count;
        return Math.min((divide(x/3,count+x%3+1)),(divide(x/2,count+x%2+1)));
    }
}