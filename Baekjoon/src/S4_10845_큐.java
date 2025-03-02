import java.util.ArrayDeque;
import java.util.Scanner;

public class S4_10845_큐 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            switch(str) {
                case "push" :
                    int num = sc.nextInt();
                    queue.addLast(num);
                    break;
                case "pop" :
                    if(queue.isEmpty()) System.out.println(-1);
                    else System.out.println(queue.pollFirst());
                    break;
                case "size" :
                    System.out.println(queue.size());
                    break;
                case "empty" :
                    if(queue.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;
                case "front" :
                    if(queue.isEmpty()) System.out.println(-1);
                    else System.out.println(queue.peekFirst());
                    break;
                case "back" :
                    if(queue.isEmpty()) System.out.println(-1);
                    else System.out.println(queue.peekLast());
                    break;
            }
        }
    }
}