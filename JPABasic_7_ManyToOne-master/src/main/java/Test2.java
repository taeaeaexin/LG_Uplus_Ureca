import java.util.HashMap;
import java.util.Map;

import org.hibernate.jpa.HibernatePersistenceProvider;

import config.MyPersistenceUnitInfo;
import entity.Comment;
import entity.Post;
import jakarta.persistence.CascadeType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

// find
public class Test2 {

	public static void main(String[] args) {

		Map<String, String> props = new HashMap<>();
		props.put("hibernate.show_sql","true");
//		props.put("hibernate.hbm2ddl.auto","create");	// create : drop & create, update : 있으면 안만들고 없으면 만든다.

		EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(
				new MyPersistenceUnitInfo(), props
		); // my persistence unit
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		
		// 1. Post
//		Post post = em.find(Post.class, 1);
		// Hibernate: select p1_0.id,p1_0.content,p1_0.title from Post p1_0 where p1_0.id=?
		
		// 2. Comment
//		Comment comment = em.find(Comment.class, 1);
		// Hibernate: select c1_0.id,c1_0.content,p1_0.id,p1_0.content,p1_0.title from Comment c1_0 left join Post p1_0 on p1_0.id=c1_0.post_id where c1_0.id=?
		// ManyToOne Ownership 을 가진 Comment 가 Post 를 함께 join 으로 select
		
		// 3. Comment
		// @ManyToOne (cascade=CascadeType.PERSIST, fetch=FetchType.LAZY) 일 경우
//		Comment comment = em.find(Comment.class, 1);
		// Hibernate: select c1_0.id,c1_0.content,c1_0.post_id from Comment c1_0 where c1_0.id=?
		// 자신 Comment 만 가져 온다.
		
		// 4. Comment
		// @ManyToOne (cascade=CascadeType.PERSIST, fetch=FetchType.LAZY) 일 경우
//		Comment comment = em.find(Comment.class, 1);
//		System.out.println(comment);
/*
		Hibernate: select c1_0.id,c1_0.content,c1_0.post_id from Comment c1_0 where c1_0.id=?
		Hibernate: select p1_0.id,p1_0.content,p1_0.title from Post p1_0 where p1_0.id=?
 */		
		// 자신 Comment 만 가져 온 후, post 사용할 때 다시 post 를 가져온다.
		
		// 5. find 한 Post 와 new 한 Comment
		Post post = em.find(Post.class, 1);
		
		Comment c3 = new Comment(); // 새로운 댓글
		c3.setContent("댓글 3");
		
		c3.setPost(post);
		em.persist(c3);
		// Hibernate: select p1_0.id,p1_0.content,p1_0.title from Post p1_0 where p1_0.id=?
		// Hibernate: insert into Comment (content,post_id) values (?,?)
		
		em.getTransaction().commit();  // 이 시점에 테이블에 반영한다.

		

		em.close();
	}

}