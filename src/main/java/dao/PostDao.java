package dao;
import negocio.Post;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



import java.util.List;
public class PostDao{
	
	private static EntityManagerFactory entityManagerFactory;
	
	public PostDao(Post post) {
		setUp();
		persistir(post);
		tearDown();
	}
	private void persistir(Post post) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		entityManager.persist(post);
		entityManager.getTransaction().commit();
		entityManager.close();

		
	}
	private void tearDown() {
		entityManagerFactory.close();
		
	}
	private void setUp() {
		entityManagerFactory = Persistence.createEntityManagerFactory( "dao.jpa" );
	}
	public PostDao() {
	}
	public List<Post> leer(){
		
		setUp();
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
        List<Post> posts = entityManager.createQuery( "from Post", Post.class ).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        
        tearDown();
        
        return posts;
	}
	
	
	
    
}
