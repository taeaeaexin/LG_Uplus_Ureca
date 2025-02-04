package ch13;

//Home을 빌려주는 실제 구현체
//Generic P를 가진 Rentable 인터페이스를 사용하므로 이때, 타입을 지정
public class HomeAgency implements Rentable<Home>{
    @Override
    public Home rent() {
        return new Home();
    }
}
