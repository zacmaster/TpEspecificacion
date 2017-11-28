package ui;

import java.util.ArrayList;

import com.vaadin.ui.AbsoluteLayout;

import servicio.PostService;
import servicio.UsuarioService;

public class AreaPost extends AbsoluteLayout{
	private static final long serialVersionUID = 1L;
	private ArrayList<negocio.Post> postsNegocio = new ArrayList<>();
	private ArrayList<Post> postsUI = new ArrayList<>();
	private PostService postService = new PostService();
	
	public AreaPost() {
		configuracion();
	}
	
	private void configuracion(){
		setWidth("100%");
		setHeight("700px");
	}

	public void agregarNuevoPostUI(String texto) {
		Post postUI = new Post(agregarPostNegocio(texto));
		postsUI.add(postUI);
		reordenarPost();
	}
	
	
	private void reordenarPost() {
		removeAllComponents();
		int distanciaTop = 0;
		for (int i = postsUI.size()-1; i >= 0; i--) {
			addComponent(postsUI.get(i),"top:"+distanciaTop+"px;");
			distanciaTop += 125;
		}
		
	}

	public void cargarPost() {
		postsNegocio = postService.leer();
		
		int distanciaTop = 0;
		for (int i = postsNegocio.size()-1; i >= 0; i--) {
			Post postUI = new Post(postsNegocio.get(i));
			postsUI.add(postUI);
			addComponent(postUI,"top:"+distanciaTop+"px;");
			distanciaTop += 125;
//			distanciaTop += 155; //distancia para 300 caracateres
		}
	}
	
	private negocio.Post agregarPostNegocio(String texto) {
		negocio.Post postNegocio = new negocio.Post();
		postNegocio.setNickUsuario(UsuarioService.usuarioActual.getNick());
		postNegocio.setTexto(texto);
		postService.guardar(postNegocio);
		return postNegocio;
	}
	
	
	
	
//	public void agregarPost(String texto){
//		Label etiqueta = new Label(texto);
//		etiqueta.setWidth("100%");
//		etiqueta.addStyleName("wrapLine");
//		
//		reAcomodarEtiquetas();
//		etiqueta.addStyleName("post");
//		addComponent(etiqueta,"top: 0px");
//		
//	}
//
//	private void reAcomodarEtiquetas() {
//		if(posts.size() != 0){
//			removeAllComponents();
//			int posicionY = 0;
//			for (int i = posts.size()-1; i >= 0 ; i--) {
//				posts.get(i).addStyleName("post");
//				addComponent(posts.get(i),"top: "+posicionY+"px");
//				posicionY += 36;
//			}
//		}
//	}
//	
//	public void leerPosts(ArrayList<String> posts){
//		removeAllComponents();
//		for (int i = 0; i < posts.size(); i++) {
//			Label label = new Label(posts.get(i));
//			label.addStyleName("wrapLine");
//			this.posts.add(label);
//			
//		}
//		reAcomodarEtiquetas();
//	}
}

