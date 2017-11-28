package daoImplementacion;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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



	@Override
	public void actualizarPuntaje(Long id,Integer puntaje) {
		setUp();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		String consulta = "UPDATE Post p set p.puntuacion = :nuevoPuntaje where p.id = :id";
		Query query = entityManager.createQuery(consulta);
		query.setParameter("nuevoPuntaje", puntaje);
		query.setParameter("id",id);
		int updateCount = query.executeUpdate();
		System.out.println(updateCount);
		
		
				
		tearDown();
	}
	
	

	
}
