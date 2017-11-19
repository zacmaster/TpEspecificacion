package daoImplementacion;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import daoInterfaz.UsuarioDao;
import negocio.Usuario;

public class UsuarioDaoImplHibernate extends DaoImplHibernate<Usuario> implements UsuarioDao{
	@Override
	public void guardar(Usuario entidad) {
		DaoImplHibernate<Usuario> di = new DaoImplHibernate<>();
		di.guardar(entidad);
	}
	
	@Override
	public List<Usuario> leer() {
		setUp();
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
        List<Usuario> usuarios = entityManager.createQuery( "from Usario", Usuario.class ).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        
        tearDown();
        
        return usuarios;
	}

	@Override
	public Usuario consulta(String nick) {
		try{
			setUp();
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			
			String cadena = "from Usuario where Nick = '"+nick+"'";
			Usuario usuario = entityManager.createQuery(cadena, Usuario.class ).getSingleResult();
					
			tearDown();
			return usuario;
	    } catch(NoResultException e) {
	        return null;
	    }
	}

	
	
}
