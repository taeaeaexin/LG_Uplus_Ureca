import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.jpa.HibernatePersistenceProvider;

import config.MyPersistenceUnitInfo;
import entity.Comment;
import entity.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

// ManyToOne - OneToMany BI
// 	1. 테이블이 3개, Entity 각각 1개씩, 연관관계를 표현하는 테이블 1개
//	2. 
// persist
public class Test2 {

	public static void main(String[] args) {

		Map<String, String> props = new HashMap<>();
		props.put("hibernate.show_sql","true");
//		props.put("hibernate.hbm2ddl.auto","create");	// create : drop & create, update : 있으면 안만들고 없으면 만든다.

		EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(
				new MyPersistenceUnitInfo(), props
		);
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();

		em.getTransaction().commit(); // 이 시점 테이블에 반영

		em.close();
	}
}