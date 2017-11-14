package daoImplementacion;

import java.util.List;

import javax.persistence.EntityManager;


import daoInterfaz.PostDao;
import negocio.Post;

public class PostDaoImplHibernate extends DaoImplHibernate<Post> implements PostDao {

	@Override
	public List<Post> leer() {
		setUp();
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
        List<Post> posts = entityManager.createQuery( "from Post", Post.class ).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        
        tearDown();
        
        return posts;
	}
	
	
	
	@Override
	public void guardar(Post entidad) {
		DaoImplHibernate<Post> di = new DaoImplHibernate<>();
		di.guardar(entidad);
	}
	@Override
	public Post get(String id) {
		return null;
	}
	@Override
	public void delete(String id) {
	}
	
//	public static void main(String[] args) {
//		Post p = new Post("Hola");
//		PostDaoImplHibernate pdi = new PostDaoImplHibernate();
//		pdi.guardar(p);
//	}

	
}
