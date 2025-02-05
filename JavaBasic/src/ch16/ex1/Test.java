package ch16.ex1;

public class Test {
    public static void main(String[] args) {
        Person person = new Person(); //일하는 사람을 만들고

        //할 일 부여
        //일의 종류마다 구현 클래스 및 객체를 만들지 않고
        //일 각각을 람다식으로 표현 전달
        person.action(() -> {
            System.out.println("출근!");
            System.out.println("코딩!");
            System.out.println("칼퇴!");
        });

        person.action(() -> {
            System.out.println("칼퇴!");
        });

        //실행문 한 개일 경우 {} 생략
        person.action(() -> System.out.println("칼퇴!"));
    }
}
