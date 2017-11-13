package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import negocio.Usuario;

public class UsuarioDao {
	private static EntityManagerFactory entityManagerFactory;
	
	
	
	public static List<Object> leerObjeto(Object o) throws Exception{
		setUp();
		return null;
	}
	
	
	private static void setUp() throws Exception {
			entityManagerFactory = Persistence.createEntityManagerFactory( "org.hibernate.tutorial.jpa" );
	}

	private static void tearDown() throws Exception {
		entityManagerFactory.close();
	}

	public static void persistir(Usuario u) throws Exception {
		setUp();
	
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		entityManager.persist(u);
		entityManager.getTransaction().commit();
		entityManager.close();

		tearDown();
	}
}
