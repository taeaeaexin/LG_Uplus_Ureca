import entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Test {
    public static void main(String[] args) {
        // EntityManager <= EntityManagerFactory
        // src/main/resources/META-INF/persistence.xml (Hibernate에서 Main 메소드 이용할 때)
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // persistence 작업
        // Class    - table
        // Product  - product

        Product p = new Product();
        p.setId(1L);
        p.setName("Phone");

        em.persist(p); // 영속화 (이 시점에 insert 되지 않는다)

        em.getTransaction().commit(); // 이 시점에 insert 됨

        em.close();
    }
}