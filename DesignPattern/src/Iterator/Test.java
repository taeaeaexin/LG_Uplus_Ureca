package Iterator;

//자바 컬렉션에서 제공하는 Iterator를 사용하기 위해서는
//해당 컬렉션이 Iterator 패턴을 적용해야 한다
public class Test {
    public static void main(String[] args) {
        StringContainer container = new StringContainer();

        Iterator itr = container.getIterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
