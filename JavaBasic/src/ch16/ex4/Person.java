package ch16.ex4;

import ch16.ex3.Calcuable;

public class Person {
    //전달되는 일 수행
    public void action(Calcuable calcuable) {
        int result = calcuable.calculate(6, 3);
        System.out.println(result);
    }
}
