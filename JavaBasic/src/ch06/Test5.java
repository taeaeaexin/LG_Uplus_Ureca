package ch06;
import ch06.A.a;

public class Test5 {
    public static void main(String[] args) {
        // private
        a A = new a();
//      int x = A.n; // not visible
        int x = A.n2;

        // default
//      int x = A.n3; // not visible <= 다른 패키지
    }
}
