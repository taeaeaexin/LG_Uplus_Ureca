package ch05;

public class test4 {
    public static void main(String[] args) {
//        // 다차원 배열
//        int intArr[] = new int[4];          // 1차원 배열
//        int intArr2[][] = new int[4][3];    // 2차원 배열
//        int intArr3[][] = new int[4][];     // 2차원 배열이지만 1차원
//
//        intArr3[0] = new int[4];
//        intArr3[1] = new int[2];
//        intArr3[2] = new int[1];
//        intArr3[3] = new int[10];

        int intArr[] = {1,2,3,4};

        // for 문
        for (int i = 0; i < intArr.length; i++) {
            System.out.println(intArr[i]);
        }

        // for each 문
        for (int i : intArr) {
            System.out.println(i);
        }
    }
}
