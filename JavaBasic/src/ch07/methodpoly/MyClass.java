package ch07.methodpoly;

import java.util.Objects;

public class MyClass {
    int n;
    String str;

    @Override // 어노테이션
    public String toString() {
        return "n = "+n+", str = "+str;
    }

    @Override
    public int hashCode() {
        return Objects.hash(n, str);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MyClass other = (MyClass) obj;
        return n == other.n && Objects.equals(str, other.str);
    }
}
