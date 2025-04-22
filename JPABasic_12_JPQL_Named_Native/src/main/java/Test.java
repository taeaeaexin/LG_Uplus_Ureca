import java.util.HashMap;
import java.util.Map;

import org.hibernate.jpa.HibernatePersistenceProvider;

import config.MyPersistenceUnitInfo;
import entity.Orders;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

// join + 서브쿼리

public class Test {

	public static void main(String[] args) {
		Map<String, String> props = new HashMap<>();
		props.put("hibernate.show_sql", "true");
//		props.put("hibernate.hbm2ddl.auto", "create");	// create: drop & create // update: 있으면 그대로 두고, 없으면 만든다
														// create로 돼있으면 코드실행시마다 항상 초기화되면서 employee 테이블 생성됨
		EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(
				new MyPersistenceUnitInfo(), props
				); // my persistence unit
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		
		// #1. join
//		String jpql = "select p, o from Product p inner join p.orders o";
////		String jpql = "select p, o from Product p, Orders o where p.id=o.product.id"; // where
//		
//		em.createQuery(jpql, Object[].class)
//				.getResultList()
//				.forEach(objArr -> {
//					System.out.println(objArr[0]); // Product p
//					System.out.println(objArr[1]); // Orders o
//				});
		
		// #2. left outer join
		// Customer 기준
//		String jpql = "select c, o from Customer c left join Orders o where p = o.product"; // select 객체 순서 변경
//	
//		em.createQuery(jpql, Object[].class)
//			.getResultList()
//			.forEach(objArray -> {
//				System.out.println(objArray[0] + ", " + objArray[1]);
//			});
		
		// #3. left outer join + count + group by
		// Customer 기준
		// orders에서 모든 고객을 대상으로 몇 건 주문했는지 확인
//		String jpql = "select c, count(o) from Customer c left join c.orders o group by c"; // select 객체 순서 변경
//	
//		em.createQuery(jpql, Object[].class)
//			.getResultList()
//			.forEach(objArray -> {
//				System.out.println(objArray[0] + ", " + objArray[1]);
//			});
		
		// #4. join + 조건
//		String jpql = 
//				"""
//				select p.id, p.name, p.pirce, o.orderQuantity, o.orderDate
//				  from Product p join p.orders o
//				where p.price > 1000
//				  and p.quantity > 10
//				  and o.orderQuantity = 10
//				""";
//	
//		em.createQuery(jpql, Object[].class)
//			.getResultList()
//			.forEach(objArray -> {
//				System.out.println(
//						// 대응되는 Dto 객체를 생성 Spring 자동 처리 등
//						objArray[0] + ", " + objArray[1] + ", " + objArray[2] + ", " + objArray[3] + ", " + objArray[4]);
//			});
		
		// #5. subquery + where
		// 주문 건 중에, 제품 가격이 5000원 미만인 건에 대해서 질의 subquery 이용
//		String jpql = 
//				"""
//					select o
//					  from Orders o
//					where o.product in(select p from Product p where p.price < 5000)
//				""";
//	
//		em.createQuery(jpql, Orders.class)
//			.getResultList()
//			.forEach(orders -> System.out.println(orders));
		
		// #6. subquery + select
		// 모든 주문 건에 대해 주묺나 고객의 이름을 함께 select
		// 아래 jpql 중 select o, (select c.name from Customer) as customerName로 처리하면
//		String jpql = 
//				"""
//					select o, (select c.name from Customer c)as customerName
//					  from Orders o
//				""";
//	
//		em.createQuery(jpql, Object[].class)
//			.getResultList()
//			.forEach(objArray -> System.out.println(objArray[0] + "," + objArray[1]));
		
		em.getTransaction().commit(); // 이 시점에 테이블에 반영한다.
		em.close();
	}
}