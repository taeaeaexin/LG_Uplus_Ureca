package ch06.B;

import ch06.A.a;

// 상속 관계에서 protected에 접근 가능하다는 같은 객체 내에서만 허용
public class b extends a{

//  a AA = new a();
    public void m() {
        a A = new a();
//      int x = A.n4; // 접근
    }

    public void m2() {
        int x = super.n4; // 부모 protected 클래스는 super로 접근
    }
}
