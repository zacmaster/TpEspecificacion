package servicio;

import java.util.ArrayList;

import daoImplementacion.PostDaoImplHibernate;
import negocio.Post;

public class PostService {
	//crear instancia dao
	public void guardar(String texto) {
		PostDaoImplHibernate postDao = new PostDaoImplHibernate();
		postDao.guardar(new Post(texto));
	}
	
	public ArrayList<String> leer(){
		PostDaoImplHibernate postDao = new PostDaoImplHibernate();
		ArrayList<String> posts = new ArrayList<String>();
		for (Post post : postDao.leer()) {
			posts.add(post.getTexto());
		}
		
		return posts;
	}
	
//	public static void main(String[] args) {
//		System.out.println("estoy aca");
//		PostService ps = new PostService();
//		ps.textoOK("asdasdsad");
//		
//	}
	

}
