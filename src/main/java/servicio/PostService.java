package servicio;

import java.util.ArrayList;

import dao.PostDao;
import negocio.Post;

public class PostService {
	//crear instancia dao
	public boolean textoOK(String texto) {
		if(texto != ""){
			PostDao postDao = new PostDao(new Post(texto));
			return true;
		}
		return false;
	}
	
	public ArrayList<String> leer(){
		PostDao postDao = new PostDao();
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
