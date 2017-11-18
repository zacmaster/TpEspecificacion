package daoImplementacion;

import daoInterfaz.UsuarioDao;
import negocio.Usuario;

public class UsuarioDaoImplHibernate extends DaoImplHibernate<Usuario> implements UsuarioDao{
	@Override
	public void guardar(Usuario entidad) {
		DaoImplHibernate<Usuario> di = new DaoImplHibernate<>();
		di.guardar(entidad);
	}
	
}
