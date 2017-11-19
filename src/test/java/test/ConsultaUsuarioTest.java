package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import daoImplementacion.UsuarioDaoImplHibernate;
import negocio.Usuario;

public class ConsultaUsuarioTest {
	UsuarioDaoImplHibernate udih = new UsuarioDaoImplHibernate();
	@Test
	public void consultarBase() {
		Usuario u1 = udih.consulta("jorgito");
		assertEquals(u1.getNick(),"jorgito");
		assertNotEquals(u1.getNick(),"kkk");
		
	}
	
	@Test
	public void usuarioNoExiste() {
		assertNull(udih.consulta("pepe"));
	}

}
