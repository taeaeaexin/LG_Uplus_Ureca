package ch16.ex2;

public class Person {
    //Person은 전달되는 일을 수행
    public void action(Workable workable) {
        workable.work("홍길동", "코딩");
    }

    public void action2(Speakable speakable) {
        speakable.speak("안녕하세요");
    }
}
