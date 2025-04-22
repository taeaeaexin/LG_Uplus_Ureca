import java.util.HashMap;
import java.util.Map;

import org.hibernate.jpa.HibernatePersistenceProvider;

import config.MyPersistenceUnitInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

// ManyToMany 양방향
// teams, users, teams_users 3개의 테이블 생성 확인
// persist
public class Test2 {

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
		
		// Test.java #8, #9번
		// Test2 는 여러분 맘대로 테스트 코드 작성해서 워크샵으로.
		// Test2 + Test 8,9번 발표
		// 같이 find하는지. fetch는 default LAZY.
		// 한거번에 가져오려면 EAGER로 바궈서 테스트
		
		
		em.getTransaction().commit(); // 이 시점에 테이블에 반영한다.
		em.close();
	}
}