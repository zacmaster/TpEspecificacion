package test;

import org.junit.Before;
import org.junit.Test;

import daoImplementacion.PostDaoImplHibernate;
import negocio.Post;

public class PostPersistenciaTest {
	private Post p;
	@Before
	public void crearPost() {
		p = new Post("Este es un post de prueba");
	}
	
	@Test
	public void persistir() {
		PostDaoImplHibernate pdi = new PostDaoImplHibernate();
		System.out.println("Sigue programando, puto!");
		pdi.guardar(p);
	}

}
