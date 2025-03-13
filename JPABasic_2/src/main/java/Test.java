import config.MyPersistenceUnitInfo;
import entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        // EntityManager <= EntityManagerFactory
        // src/main/resources/META-INF/persistence.xml (Hibernate에서 Main 메소드 이용할 때)
        EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(
                new MyPersistenceUnitInfo(), new HashMap()
        ); // my persistence unit
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // persistence 작업
        // Class    - table
        // Product  - product

        Product p = new Product();
        p.setId(2L);
        p.setName("Book");

        em.persist(p); // 영속화 (이 시점에 insert 되지 않는다)

        em.getTransaction().commit(); // 이 시점에 insert 됨

        em.close();
    }
}