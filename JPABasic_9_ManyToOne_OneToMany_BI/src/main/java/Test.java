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
public class Test {

	public static void main(String[] args) {

		Map<String, String> props = new HashMap<>();
		props.put("hibernate.show_sql","true");
		props.put("hibernate.hbm2ddl.auto","create");	// create : drop & create, update : 있으면 안만들고 없으면 만든다.

		EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(
				new MyPersistenceUnitInfo(), props
		);
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Post p = new Post();
		p.setContent("게시글 1");
		
		Comment c1 = new Comment();
		c1.setContent("댓글 1 내용");
		
		Comment c2 = new Comment();
		c2.setContent("댓글 2 내용");
		
		// #1. 연결 없이, Post만 1건 persist
//		em.persist(p);
		
		// #2. 연결 없이, Comment만 2건 persist
//		em.persist(c1);
//		em.persist(c2);
		
		// #2. 연결 없이, Comment만 2건 persist
//		em.persist(p);
//		em.persist(c1);
//		em.persist(c2);
		
		// #4. Comment 2개에만 post 연결 (ManyToOne)
//		c1.setPost(p);
//		c2.setPost(p);
//		
//		em.persist(c1);
//		em.persist(c2);
		
		// #5. Comment 2개에만 post 연결 (ManyToOne)
//		c1.setPost(p);
//		c2.setPost(p);
//		
//		em.persist(p);
//		em.persist(c1);
//		em.persist(c2);
		
		// #5. Post에만 comment 2개 연결
		p.setComments(List.of(c1,c2));
		em.persist(p);

		em.getTransaction().commit(); // 이 시점 테이블에 반영

		em.close();
	}

}