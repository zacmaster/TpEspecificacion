package daoInterfaz;

import negocio.Post;
public interface PostDao extends GenericDao<Post>{
	public void actualizarPuntaje(Long id, Integer puntaje);
}
