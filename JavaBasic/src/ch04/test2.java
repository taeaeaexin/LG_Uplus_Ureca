package ch04;

public class test2 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        for (int i = 0, j = 2; i < 10 && j > 0 ; i++, j--) {
            System.out.println(i+" "+j);
        }

        // nested
        for (int i = 0 ; i < 4 ; i++){
            for (int j = 0; j < 6; j++) {
                System.out.printf("%d %d ", i, j);
            }
            System.out.println();
        }

        // forEach
    }
}
