package ui;

import java.util.ArrayList;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextArea;

import servicio.PostService;
//import servicio.PostService;
import servicio.UsuarioService;

public class VistaPrincipal extends AbsoluteLayout implements View{

	
	private static final long serialVersionUID = 1L;
	protected static final String NAME = "Main";
	
	private BarraSuperior barraSuperior = new BarraSuperior();
	private Button botonPublicar = new Button("Publicar");
	private TextArea areaTexto = new TextArea("¿Qué estás pensando?");
	private AbsoluteLayout marco = new AbsoluteLayout();
	private AbsoluteLayout principalLayout = new AbsoluteLayout();
	private AreaPost areaPost = new AreaPost();
	private PostService postService = new PostService();
	private ArrayList<negocio.Post> postsNegocio = new ArrayList<>();
	private ArrayList<Post> postsUI = new ArrayList<>();
	public VistaPrincipal() {
		cargarComponentes();
		cargarListeners();
		addStyleName("fondoImagen");
	}
	
	private void cargarComponentes() {
		configuracionAreaTexto();
		configuracionMarco();
		configuracionAreaPost();
		configuracionPrincipalLayout();
		cargarPosts();
		cargarListeners();
		addComponent(barraSuperior);
	}

	private void cargarPosts() {
//		areaPost.addComponent(new Post());
	}

	private void configuracionPrincipalLayout(){
		principalLayout.setWidth("70%");
		principalLayout.setHeight("100%");
		addComponent(principalLayout,"top: 61px; left: 20%");
	}

	private void configuracionAreaPost(){
		
//		areaPost.setWidth("100%");
//		areaPost.setHeight("100%");
		principalLayout.addComponent(areaPost,"top: 150px");
		areaPost.addStyleName("fondoVerde");
	}
	private void configuracionAreaTexto() {
		areaTexto.setMaxLength(300);
		areaTexto.setWidth("100%");
		areaTexto.setHeight("50px");
		principalLayout.addComponent(marco,"top: 0px");
//		principalLayout.addStyleName("fondoRojo");
//		areaPost.leerPosts(postService.leer());
	}

	private void configuracionMarco(){
		marco.setWidth("100%");
		marco.setHeight("150px");
		marco.addComponent(areaTexto,"top: 35px");
		marco.addComponent(botonPublicar,"top: 98px; right: 10px");
//		marco.addStyleName("fondoAmarillo");
		marco.addStyleName("mymargins");
		
	}

	
	private void cargarListeners(){
		botonPublicar.addClickListener(clickEvent -> clickbotonPublicar());
	}
	



	private void clickbotonPublicar() {
		String texto = areaTexto.getValue();
		if(!texto.isEmpty()) {
			
			
			agregarNuevoPostUI(agregarPostNegocio(texto));
//			System.out.println(post);
//			areaPost.addComponent(post);
			
		}
//		areaPost.agregarPost(texto);
		areaTexto.clear();
	}





	private void agregarNuevoPostUI(negocio.Post postNegocio) {
		Post post = new Post(postNegocio);
		reacomodarPost(post);
		
	}

	private void reacomodarPost(ui.Post post) {
		postsUI.add(post);
	}

	private negocio.Post agregarPostNegocio(String texto) {
		negocio.Post postNegocio = new negocio.Post();
		postNegocio.setNickUsuario(UsuarioService.usuarioActual.getNick());
		postNegocio.setTexto(texto);
		postService.guardar(postNegocio);
		return postNegocio;
	}


	private void cargarPost() {
		postsNegocio = postService.leer();
		int distanciaTop = 0;
		for (int i = postsNegocio.size()-1; i >= 0; i--) {
			areaPost.addComponent(new Post(postsNegocio.get(i)),"top:"+distanciaTop+"px;");
			distanciaTop += 155;
		}
	}

	@Override
	public void enter(ViewChangeEvent event) {
		cargarPost();	
	}
}
