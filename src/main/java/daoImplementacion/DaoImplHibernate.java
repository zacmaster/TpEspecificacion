package daoImplementacion;

import daoInterfaz.GenericDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DaoImplHibernate<E>  implements GenericDao<E>{
	protected static EntityManagerFactory entityManagerFactory;

	public DaoImplHibernate() {
	}
	
	@Override
	public void guardar(E entidad) {
		setUp();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		entityManager.persist(entidad);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		tearDown();
		
	}

	protected void tearDown() {
		entityManagerFactory.close();
	}


	protected void setUp() {
		entityManagerFactory = Persistence.createEntityManagerFactory( "daoImplementacion.jpa" );
	}


	@Override
	public E get(String id) {
		return null;
	}

	@Override
	public void delete(String id) {
	}


	@Override
	public List<E> leer() {
		return null;
	}

}
