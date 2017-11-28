package servicio;

import java.util.ArrayList;

import daoImplementacion.PostDaoImplHibernate;
import negocio.Post;

public class PostService {
	//crear instancia dao
	public void guardar(negocio.Post post) {
		PostDaoImplHibernate postDao = new PostDaoImplHibernate();
		postDao.guardar(post);
	}
	
	public ArrayList<Post> leer(){
		PostDaoImplHibernate postDao = new PostDaoImplHibernate();
		ArrayList<Post> posts = new ArrayList<Post>();
		for (Post post : postDao.leer()) {
			posts.add(post);
		}
		
		return posts;
	}
	

}
