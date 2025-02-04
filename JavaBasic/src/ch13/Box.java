package ch13;

//한 개의 타입이 아닌 여러 타입 (String, Integer, ...)의 객체를 담고자 함
//public class Box {
//    //Object는 모든 타입을 담을 수 있지만, 사용 시 instanceof로 어떤 타입인지 확인, 형 변환도 해야 함
//    public Object content;
//}

public class Box<T> {
    public T content;
}