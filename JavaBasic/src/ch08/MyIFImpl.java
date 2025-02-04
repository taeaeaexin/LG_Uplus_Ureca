package ch08;

// team 2
public class MyIFImpl implements MyIF, YourIF{

    @Override
    public void m() {
        System.out.println("MyIFImpl m()");
    }

    @Override
    public void m2() {
        System.out.println("MyIFImpl m()");
    }
}
