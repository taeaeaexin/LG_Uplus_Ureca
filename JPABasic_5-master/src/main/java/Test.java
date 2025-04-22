import config.MyPersistenceUnitInfo;
import entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		// EntityManager <= EntityManagerFactory
		// src/main/resources/META-INF/persitence.xml

		Map<String, String> props = new HashMap<>();
		props.put("hibernate.show_sql","true");
		props.put("hibernate.hbm2ddl.auto","create");	// create : drop & create, update : 있으면 안만들고 없으면 만든다.

		/*
		create
		Hibernate : drop table if exists employee
		Hibernate: create table employee (id integer not null, address varchar(255), name varchar(255), primary key (id)) engine=InnoDB
		 */

		/*
		update
		테이블이 있으면 아무런 작업X
		테이블이 없으면
		hibernate: create table employee (id integer not null, address varchar(255), name varchar(255), primary key (id)) engine=InnoDB
		 */

		EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(
				new MyPersistenceUnitInfo(), props
		); // my persistence unit
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		// persistence 작업
		// class   - table 
		// Employee - employee


		// #1 ~ #3 으로 이전 프로젝트의 insert, update, select sql 문 수행 확인
//		 #1. persist
//		 현재 테이블에 없는 객체를 생성한 후 객체의 내용을 테이블에 반영 (insert)
		{
			Employee e = new Employee();
			e.setId(2);
			e.setName("이길동");
			e.setAddress("서울 어디");

			em.persist(e); // 영속화 ( 이 시점에 insert 되지 않는다. )
		}

		// #2. find
		// 현재 테이블에 있는 데이터를 객체로 전환 (select) 영속화
		// 영속화 된 객체의 필드값을 변경하면 DB 반영된다.
//		{
//			Employee e = em.find(Employee.class, 1); // id 가 1
//			System.out.println(e);
//			e.setAddress("대전 어디");  // 이 시점에 update X
//			System.out.println(e);
//			//....
//			e.setAddress("부산 어디");  // 이 시점에 update X
//			System.out.println(e);
//		}


		// #3. merge
		// 현재 테이블에 없는 객체를 생성한 경우면 insert, 이미 있는 객체이면 update
		// persist 는 insert 만
		{
			// 테이블에 없는 경우 (insert)
//			Employee e = new Employee();
//			e.setId(3);
//			e.setName("삼길동");
//			e.setAddress("춘천 어디");
//
//			em.merge(e); // 영속화 ( 이 시점에 insert 되지 않는다. )

			// 테이블에 있는 경우 (update)
//			Employee e = new Employee();
//			e.setId(1);
//			e.setName("홍길동2");
//			e.setAddress("창원 어디");
//
//			em.merge(e); // 영속화 ( 이 시점에 insert 되지 않는다. )

		}

		// create, update 테스트 후 데이터 없다.
		// #1. insert 수행

		// #4. remove
		// Hibernate: create table employee (id integer not null, address varchar(255), name varchar(255), primary key (id)) engine=InnoDB
		// Hibernate: select e1_0.id,e1_0.address,e1_0.name from employee e1_0 where e1_0.id=?
//		{
//			Employee e = em.find(Employee.class, 2);	// 삭제 대상 영속화
//			em.remove(e);	//( 이 시점에 삭제 X)
//
//			try{
//				Thread.sleep(3000);
//			} catch (Exception ee) {
//				ee.printStackTrace();
//			}
//		}

//		#1. persist & find
//		현재 영속화 되어 있는 객체를 find()
//		find() 는 대상이 이미 영속화 되어 있으면 테이블에서 조회하지 않음

		{
			Employee e = new Employee();
			e.setId(3);
			e.setName("삼길동");
			e.setAddress("제주 어디");

			em.persist(e); // 영속화 ( 이 시점에 insert 되지 않는다. )

			Employee e2 = em.find(Employee.class, 3);	// 아직 insert 되지 않은 삼길동 데이터를 find() 한다.
			System.out.println(e2);
		}
		em.getTransaction().commit();  // 이 시점에 테이블에 반영한다.

		em.close();
	}

}