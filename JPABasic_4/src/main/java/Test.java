import config.MyPersistenceUnitInfo;
import entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.Map;

// HashMAp 옵션
public class Test {
    public static void main(String[] args) {
        Map<String, String> props = new HashMap<>();
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.hbm2ddl.auto", "update"); // create : drop & create, update : 있으면 안 건드리고 없으면 새로 만듦

        /*
        create
        Hibernate : drop table if exists employee
        Hibernate : create table employee (id integer not null, address varchar(255), name varchar(255), primary key (id)) engine=InnoDB

        update
        테이블이 있으면 아무런 작업 X
        테이블이 없으면
        Hibernate : create table employee (id integer not null, address varchar(255), name varchar(255), primary key (id)) engine=InnoDB
        */

        EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(
                new MyPersistenceUnitInfo(), props
        );
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
//        }

        // #2. find
        // 현재 테이블에 있는 데이터를 객체로 전환 (select)
//        {
//            Employee e = em.find(Employee.class, 2); // id가 1
//            System.out.println(e);
//        }

        // #3. merge
        // 현재 테이블에 없는 객체를 생성한 경우면 insert, 이미 있는 객체면 update
//        {
//            // 테이블에 없는 경우 (insert)
//            Employee e = new Employee();
//            e.setId(3);
//            e.setName("고민정");
//            e.setAddress("군포 산본");
//
//            em.merge(e); // 영속화 (이 시점에 insert 되지 않음)

            // 테이블에 있는 경우 (update)
//            Employee e = new Employee();
//            e.setId(2);
//            e.setName("고양이");
//            e.setAddress("고양이 집");
//
//            em.merge(e); // 영속화 (이 시점에 insert 되지 않음)
//        }

        // create, update 테스트 후 데이터 없음
        // #1. Insert 수행

        // #4. remove
        // Hibernate: select e1_0.id,e1_0.address,e1_0.name from employee e1_0 where e1_0.id=?
        // Hibernate: delete from employee where id=?
//        {
//            Employee e = em.find(Employee.class, 2); // 삭제 대상 영속화
//            em.remove(e); // 이 시점에 삭제 X
//            try{
//                Thread.sleep(5000); // 5초 delay
//            }catch (Exception ee){
//                ee.printStackTrace();
//            }
//        }

        // #1. persist & find
        // 현재 영속화 되어 있는 객체를 find()
        // find()는 대상이 이미 영속화 되어있으면 테이블에서 조회 X
        {
            Employee e = new Employee();
            e.setId(3);
            e.setName("삼길동");
            e.setAddress("제주도 감귤나라");

            em.persist(e); // 영속화 (이 시점에 insert 되지 않음)

            Employee e2 = em.find(Employee.class, 3); // 아직 insert 되지 않은 데이터를 find()
            System.out.println(e2);
        }

        em.getTransaction().commit(); // 이 시점에 테이블에 반영 함

        em.close();
    }
}