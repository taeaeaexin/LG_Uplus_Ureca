package ch18.ex5;

import java.io.Serializable;

//Serializable은 추상 메소드가 없는 단순 Marking 용도
public class MyClass implements Serializable {
    int n;
    String str;
}
