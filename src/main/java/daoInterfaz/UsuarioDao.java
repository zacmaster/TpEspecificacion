package daoInterfaz;

import negocio.Usuario;
public interface UsuarioDao extends GenericDao<Usuario>{
	public Usuario consulta(String u);
	
}
