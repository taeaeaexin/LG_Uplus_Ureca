package ch07.abstr;

public class YourMouseAdaptor extends MouseAdaptor {
    @Override
    public void over() {
        System.out.println("MyMouseAdaptor over()");
    }

    @Override
    public void out() {
        System.out.println("MyMouseAdaptor out()");
    }

    @Override
    public void click() {
        System.out.println("MyMouseAdaptor click()");
    }
}