import java.util.Arrays;
import java.util.Scanner;

public class S3_15649_perm {
    static int[] Number;
    static int[] Pick;
    static boolean[] Select;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        Number = new int[N];
        Pick = new int[M];
        Select = new boolean[N];

        for (int i = 0; i < N ; i++) {
            Number[i] = i+1;
        }

        func(0);
    }

    public static void func(int index) {
        if(index == Pick.length){
            printFunc(Pick);
            return;
        }

        for (int i = 0; i < Number.length; i++) {
            if(Select[i]) continue;

            Pick[index] = Number[i];
            Select[i] = true;
            func(index + 1);
            Select[i] = false;
        }

    }

    public static void printFunc(int[] pick) {
        String result="";
        for (int i = 0; i < pick.length; i++) {
            result = Arrays.toString(pick).replace("[", "").replace("]", "").replace(",","");
        }
        System.out.println(result);
    }
}
