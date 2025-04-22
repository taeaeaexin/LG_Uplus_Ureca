import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.jpa.HibernatePersistenceProvider;

import config.MyPersistenceUnitInfo;
import entity.Comment;
import entity.Post;
import jakarta.persistence.CascadeType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.ManyToOne;

// OneToMany
//   1. 테이블이 3개, Entity 각각 1개씩, 연관관계를 표현하는 테이블 1개
//   2. ManyToOne 은 Many 가 Owing Entity 이므로 Many 를 표현하는 테이블에 One 에 해당하는 컬럼을 추가
//   3. OneToMany 는 One 이 Owing Entity 인데, One 을 표현하는 테이블에 복수개의 Many 를 표현 X => 별도의 관계 테이블 추가
// persist
public class Test {

	public static void main(String[] args) {

		Map<String, String> props = new HashMap<>();
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.hbm2ddl.auto", "create"); // create : drop & create,  update : 있으면 안 건드리고 없으면 만든다.
		

		EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(
				new MyPersistenceUnitInfo(), props
		); 
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Post p = new Post();
		p.setTitle("게시글 1");
		p.setContent("게시글 1 내용");
		
		Comment c1 = new Comment();
		c1.setContent("코멘트 1 내용");
		
		Comment c2 = new Comment();
		c2.setContent("코멘트 2 내용");
		
		// #1 Post 1건만 persist
//		em.persist(p);
//		Hibernate: insert into Post (content,title) values (?,?)
		// Post 1건 정상 insert
		
		// #2 Comment 2건만 persist
//		em.persist(c1);
//		em.persist(c2);
//		Hibernate: insert into Comment (content) values (?)
//		Hibernate: insert into Comment (content) values (?)
		// Comment 2건 정상 insert
		
		// #3 연결 없이, Post 1건, Comment 2건 persist
//		em.persist(p);
//		em.persist(c1);
//		em.persist(c2);
//		Hibernate: insert into Post (content,title) values (?,?)
//		Hibernate: insert into Comment (content) values (?)
//		Hibernate: insert into Comment (content) values (?)
		// Post 1건, Comment 2건 정상 insert
		

		// #4 Post 에 comment 연결, Post 1건만 persist
//		p.setComments(List.of(c1, c2));
//		em.persist(p);
		// org.hibernate.TransientObjectException: persistent instance references an unsaved transient instance of 'entity.Comment' (save the transient instance before flushing)
		// OneToMany Post 에 연결된 Comment 객체들이 영속화 되지 않았다. 
		
		// #5 Post 에 comment 연결, Post 1건, Comment 2건 persist
		p.setComments(List.of(c1, c2));
		em.persist(p);
		em.persist(c1);
		em.persist(c2);
//		Hibernate: insert into Post (content,title) values (?,?)
//		Hibernate: insert into Comment (content) values (?)
//		Hibernate: insert into Comment (content) values (?)
//		Hibernate: insert into Post_Comment (Post_id,comments_id) values (?,?)
//		Hibernate: insert into Post_Comment (Post_id,comments_id) values (?,?)
		// OneToMany Post 에 연결된 Comment 객체들이 영속화 되지 않았다. 		
		
		
		// #6 Post 에 comment 연결, Post 1건만  persist
		// CascadeType.PERSIST 를 OneToMany 에 추가
//		p.setComments(List.of(c1, c2));
//		em.persist(p);

//		Hibernate: insert into Post (content,title) values (?,?)
//		Hibernate: insert into Comment (content) values (?)
//		Hibernate: insert into Comment (content) values (?)
//		Hibernate: insert into Post_Comment (Post_id,comments_id) values (?,?)
//		Hibernate: insert into Post_Comment (Post_id,comments_id) values (?,?)
		// OneToMany Post 에 연결된 Comment 객체들이 영속화 되지 않았다. 			
		
		em.getTransaction().commit();  // 이 시점에 테이블에 반영한다.
		
		em.close();
	}

}