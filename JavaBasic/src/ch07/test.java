package ch07;

public class test {
    public static void main(String[] args) {
        // 상속
//        {
//            Parent p = new Parent();
//            Child c = new Child();
//        }

        // Parent 생성자 추가, 필드 추가
        {
            Child c = new Child();
            c.m();
        }

        // Up Casting, Down Casting
        {
            Parent P = new Child();
            Child c = new Child();
            Parent p2 = c;

            c.m();
//          p2.m(); // 접근 불가
            Child c2 = (Child) new Parent(1); // 문법적 오류는 없지만 ClassCastException 발생
            // 명시적으로 Casting 하는것은 되도록 지양 (부득이한 경우에 수행)
        }
    }
}

// 컴파일러가 자동으로 하는 일
// 1. 생성자가 없으면 추가
// 2. java.lang 자동 import
// 3. 생성자에 super()가 없으면 자동으로 추가
