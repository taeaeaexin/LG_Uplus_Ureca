import config.MyPersistenceUnitInfo;
import entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// JPQL
// select 수행, insert 수행 불가, update O, delete O
// transaction begin, commit 사용 X

public class Test {
    public static void main(String[] args) {
        Map<String, String> props = new HashMap<>();
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.hbm2ddl.auto", "update");

        EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(
                new MyPersistenceUnitInfo(), props
        );
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // #1 normal query
//        {
//            // SQL : "select * from employee"
//            String jpql = "select e from Employee e"; // Entity를 이용한 query 형식
//            Query query = em.createQuery(jpql);
//            List<Employee> list = query.getResultList();
//
//            for (Employee e : list) {
//                System.out.println(e);
//            }
//        }

        // #2 typed query
//        {
//            // SQL : "select * from employee"
//            String jpql = "select e from Employee e"; // Entity를 이용한 query 형식
//            TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
//            List<Employee> list = query.getResultList();
//
//            for (Employee e : list) {
//                System.out.println(e);
//            }
//        }

        // #3 named parameter
//        {
//            // SQL : "select * from employee where id = 3"
//            String jpql = "select e from Employee e where id = :id"; // Entity를 이용한 query 형식
//            TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
//            query.setParameter("id", 3);
//            List<Employee> list = query.getResultList();
//
//            for (Employee e : list) {
//                System.out.println(e);
//            }
//        }

        // #4 positional parameter
//        {
//            // SQL : "select * from employee where id = 3"
//            String jpql = "select e from Employee e where id >= ?1"; // Entity를 이용한 query 형식
//            TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
//            query.setParameter(1, 3);
//            List<Employee> list = query.getResultList();
//
//            for (Employee e : list) {
//                System.out.println(e);
//            }
//        }

        // #5 single result
//        {
//            // SQL : "select * from employee where id = 3"
//            String jpql = "select e from Employee e where id >= ?1"; // Entity를 이용한 query 형식
//            TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
//            query.setParameter(1, 3);
//            Employee e = query.getSingleResult();
//
//            System.out.println(e);
//        }

        // #6 like
        {
            // SQL : "select * from employee where name like %민정%"
            String jpql = "select e from Employee e where e.name like : searchWord"; // Entity를 이용한 query 형식
            String searchWord = "%민정%";
            TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
            query.setParameter("searchWord", searchWord);
            List<Employee> list = query.getResultList();

            for (Employee e : list) {
                System.out.println(e);
            }
        }

//        em.getTransaction().commit(); // 이 시점에 테이블에 반영 됨

        em.close();
    }
}