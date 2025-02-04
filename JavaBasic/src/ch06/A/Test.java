package ch06.A;

public class Test {
    public static void main(String[] args) {
        // 같은 패키지에서 default에 대한 접근
        a A = new a(); // import 필요 X
        int x = A.n3; // 같은 패키지로 접근 가능
    }
}
