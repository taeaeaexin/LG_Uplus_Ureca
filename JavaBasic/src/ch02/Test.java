package ch02;

public class Test {
    public static void main(String[] args) {
        // Primitive type 형 변환
//        byte b1 = 10;
//        int i1 = b1; // 큰 타임 int <- 작은 타입 byte (자동 형변환O)
//        System.out.println(b1);
//        System.out.println(i1);
////      byte b2= i1; // 작은 타입 byte <- 큰 타임 int (자동 형변환X)
//
//        byte b2 = (byte) i1; // 작은 타입 byte <- 큰 타임 int (강제 형변환)
//        System.out.println(b2); // 값 손실 위험
//
//        byte b4 = 10;
//        byte b5 = 20;
//        int i6 = b4 + b5;
//        byte b6 = (byte) (b4 + b5);
//
//        System.out.println(i6);
//        System.out.println(b6);

        // LocMen
        LocMem locMem1 = new LocMem();
        locMem1.num = 10;
        locMem1.name = "AAA";

        LocMem locMem2 = new LocMem();
        locMem2.num = 20;
        locMem2.name = "BBB";

        System.out.println(locMem1.sum(100, 200));
        System.out.println(locMem2.sum(300, 400));
    }
}
