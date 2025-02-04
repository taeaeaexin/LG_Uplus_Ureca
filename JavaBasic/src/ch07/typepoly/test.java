package ch07.typepoly;

public class test {
    public static void main(String[] args) {
        // 타입 다형성 = assign
        {
            A a = new A(); // 부모 - 부모
            B b = new B(); // 자식 - 자식
            A ab = new B(); // 부모 - 자식
//          B ba = new A(); // 자식 - 부모 (X)
        }

        // 타입 다형성 : parameter
        {
            A a = new A();
            B b = new B();

            m1(a);
            m1(b);
//          m2(a); // X
            m2(b);
        }
    }
    // 타입 다형성 : parameter
    static void m1(A a) {}
    static void m2(B b) {}

    // 타입 다형성 : return type
    static A m3() {return new A();}
    static A m4() {return new B();}
//  static A m5() {return new A();} // X
    static A m6() {return new B();}
}
