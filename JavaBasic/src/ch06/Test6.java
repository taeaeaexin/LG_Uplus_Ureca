package ch06;

public class Test6 {
    public static void main(String[] args) {
        // getter setter{
//        GetterSetter gs = new GetterSetter();
//        gs.n = 100; // 변경 가능
//        gs.m();
//    }
        // private int n 변경
        {
            GetterSetter gs = new GetterSetter();
//          gs.n = 1000; // 오류 발생 (직접 접근)
            gs.setN(100);
            gs.m();
        }
    }
}
