package servicio;

import java.util.ArrayList;

import daoImplementacion.PostDaoImplHibernate;
import negocio.Post;

public class PostService {
	//crear instancia dao
	PostDaoImplHibernate postDao = new PostDaoImplHibernate();
	public void guardar(negocio.Post post) {
		postDao.guardar(post);
	}
	
	public ArrayList<Post> leer(){
		ArrayList<Post> posts = new ArrayList<Post>();
		for (Post post : postDao.leer()) {
			posts.add(post);
		}
		
		return posts;
	}

	public void actualizarPuntaje(Long id, Integer puntaje) {
		postDao.actualizarPuntaje(id, puntaje);
	}
	

}
