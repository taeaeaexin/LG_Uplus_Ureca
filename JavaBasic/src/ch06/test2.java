package ch06;

public class test2 {
    static {
        System.out.println("X");
    }

    public static void main(String[] args) {
        // static 필드
        System.out.println(Calculator.pi);

        // static 메소드
        System.out.println(Calculator.plus(10,20));

        // 객체로부터 접근 >> 실행은 되나 올바르지 않다
        Calculator c = new Calculator();
        System.out.println(c.pi);

        // non-static method call
//      hello(); // 호출 불가
        hello2(); // 호출 가능
    }
    static {
        System.out.println("Y");
    }

    public void hello(){

    }

    public static void hello2(){

    }
}
