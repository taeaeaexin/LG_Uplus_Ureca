package Methodchain;

public class Calculator {
    private int first;
    private int second;

    //pattern 적용 전
//    public void setFirst(int first) {
//        this.first = first;
//    }
//
//    public void setSecond(int second) {
//        this.second = second;
//    }
//
//    public void add() {
//        System.out.println(this.first + this.second);
//    }
//
//    public void sub() {
//        System.out.println(this.first - this.second);
//    }

    //pattern 적용 후
    public Calculator setFirst(int first) {
        this.first = first;
        return this;
    }

    public Calculator setSecond(int second) {
        this.second = second;
        return this;
    }

    public Calculator add() {
        System.out.println(this.first + this.second);
        return this;
    }

    public Calculator sub() {
        System.out.println(this.first - this.second);
        return this;
    }
}
