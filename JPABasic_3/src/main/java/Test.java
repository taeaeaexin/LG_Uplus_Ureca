import config.MyPersistenceUnitInfo;
import entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        // EntityManager <= EntityManagerFactory
        // src/main/resources/META-INF/persistence.xml (Hibernate에서 Main 메소드 이용할 때)
        EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(
                new MyPersistenceUnitInfo(), new HashMap<>()
        ); // my persistence unit
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // persistence 작업
        // Class    - table
        // Employee  - employee

        // #1. persist
        // 현재 테이블에 없는 객체를 생성한 후 객체의 내용을 테이블에 반영 (insert)
//        {
//            Employee e = new Employee();
//            e.setId(2);
//            e.setName("문태신");
//            e.setAddress("대전 성심당");
//
//            em.persist(e); // 영속화 (이 시점에 insert 되지 않는다)
//
//            e.setAddress("군포 산본동");
//        }

        // #2. find
        // 현재 테이블에 있는 데이터를 객체로 전환 (select)
//        {
//            Employee e = em.find(Employee.class, 2); // id가 1
//            System.out.println(e);
//            e.setAddress("여수 밤바다"); // 이 시점에 update X
//            System.out.println(e);
//            //....
//            e.setAddress("부산 광안리"); // 이 시점에 update X
//            System.out.println(e);
//        }

        // #3. merge
        // 현재 테이블에 없는 객체를 생성한 경우면 insert, 이미 있는 객체면 update
        {
//            // 테이블에 없는 경우 (insert)
//            Employee e = new Employee();
//            e.setId(3);
//            e.setName("고민정");
//            e.setAddress("군포 산본");
//
//            em.merge(e); // 영속화 (이 시점에 insert 되지 않음)

            // 테이블에 있는 경우 (update)
            Employee e = new Employee();
            e.setId(1);
            e.setName("고양이");
            e.setAddress("고양이 집");

            em.merge(e); // 영속화 (이 시점에 insert 되지 않음)
        }

        em.getTransaction().commit(); // 이 시점에 테이블에 반영 함

        em.close();
    }
}