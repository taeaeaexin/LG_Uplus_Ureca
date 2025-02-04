package ch02;

public class LocMem {
    // 클래스로 표현하려는 객체별로 변수(상태)와 메소드(동작)를 선언

    // Member variable
    // 객체가 존재하는 한 지속 (객체 가비지 되면 사라짐)
    int num;
    String name;

    // 메소드
    // 파라미터와 메소드 내에서 선언된 변수 모두 메소드가 호출될 때 만들어 지고, 종료될 때 사라진다
    public int sum(int n1, int n2) {
        int n3 = 3;
        return n1 + n2 + n3;
    }
}