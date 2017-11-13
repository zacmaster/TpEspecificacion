package daoImplementacion;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import negocio.Post;

public class PostDaoViejo{
	
	private static EntityManagerFactory entityManagerFactory;
	
	public PostDaoViejo(Post post) {
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
		entityManagerFactory = Persistence.createEntityManagerFactory( "daoImplementacion.jpa" );
	}
	public PostDaoViejo() {
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
