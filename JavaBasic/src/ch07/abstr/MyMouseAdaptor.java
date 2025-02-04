package ch07.abstr;

public class MyMouseAdaptor extends MouseAdaptor {
    @Override
    public void over() {
        System.out.println("YourMouseAdaptor over()");
    }

    @Override
    public void out() {
        System.out.println("YourMouseAdaptor out()");
    }
}