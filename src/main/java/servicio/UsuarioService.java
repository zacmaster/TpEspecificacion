package servicio;

import daoImplementacion.UsuarioDaoImplHibernate;
import negocio.Usuario;

public class UsuarioService {
	
	public void guardarUsuario(Usuario usuario) {
		UsuarioDaoImplHibernate udih = new UsuarioDaoImplHibernate();
		udih.guardar(usuario);
	}
}
