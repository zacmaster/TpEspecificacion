package servicio;

import daoImplementacion.UsuarioDaoImplHibernate;
import negocio.Usuario;

public class UsuarioService {
	private UsuarioDaoImplHibernate udih;
	
	public void guardarUsuario(Usuario usuario) {
		UsuarioDaoImplHibernate udih = new UsuarioDaoImplHibernate();
		udih.guardar(usuario);
	}
	
	public boolean seAceptaLogin(String usuario, String pass) {
		Usuario u = udih.consulta(usuario);
		if(u != null) {
			if(u.getPassword().equals(pass)) {
				return true;
			}
		}
		return false;
		
	}
}
