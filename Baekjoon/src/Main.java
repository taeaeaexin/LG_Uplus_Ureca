public class Main {
    public static void main(String[] args) {
        int num = 0;
        int n = 2;
        int n2 = 3;
        System.out.println(num |= (1 << n-1));
        System.out.println(num |= (1 << n2-1));
    }
}