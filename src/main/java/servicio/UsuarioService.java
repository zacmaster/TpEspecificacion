package servicio;

import daoImplementacion.UsuarioDaoImplHibernate;
import negocio.Usuario;

public class UsuarioService {
	private UsuarioDaoImplHibernate udih;
	public static Usuario usuarioActual; 
	
	public UsuarioService() {
		udih = new UsuarioDaoImplHibernate();
	}
	
	public void guardarUsuario(Usuario usuario) {
		UsuarioDaoImplHibernate udih = new UsuarioDaoImplHibernate();
		udih.guardar(usuario);
	}
	
	public boolean seAceptaLogin(String usuario, String pass) {
		System.out.println(usuario);
		System.out.println(pass);
		Usuario u = udih.consulta(usuario);
		if(u != null) {
			if(u.getPassword().equals(pass)) {
				usuarioActual = u;
				return true;
			}
		}
		return false;
		
	}
}
