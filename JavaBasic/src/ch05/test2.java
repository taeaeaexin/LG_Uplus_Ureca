package ch05;

public class test2 {
    public static void main(String[] args) {
//        // String 객체의 비교
//        String str1 = new String("Hello"); // heap 100
//        String str2 = new String("Hello"); // heap 200
//        String str3 = ("Hello"); // heap 300
//        String str4 = ("Hello"); // heap 300
//
//        // ==
//        System.out.println(str1 == str2);
//        System.out.println(str3 == str4);
//        System.out.println(str1 == str4);
//
//        // equals()
//        System.out.println(str1.equals(str2));
//        System.out.println(str3.equals(str4));
//        System.out.println(str1.equals(str4));

        // String 메소드
        {
            String str = "Hello";
            // length()
            System.out.println(str.length());

            // charAt()
            System.out.println(str.charAt(0));

            // replace()
            System.out.println(str.replace("He", "AA")); //원본 유지
            System.out.println(str);

            // indexOf()
            System.out.println(str.indexOf("l"));

            // substring()
            System.out.println(str.substring(0,2));
            System.out.println(str.substring(0, str.indexOf("l"))+ "X" + str.substring(str.indexOf("l"), str.length()));
        }

    }
}
