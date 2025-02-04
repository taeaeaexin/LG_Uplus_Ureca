package ch07.abstr;

public class Test {
    public static void main(String[] args) {
        MyMouseAdaptor adaptor = new MyMouseAdaptor();
        adaptor.click();
        adaptor.over();

        YourMouseAdaptor adaptor2 = new YourMouseAdaptor();
        adaptor2.click();
        adaptor2.over();
    }
}
