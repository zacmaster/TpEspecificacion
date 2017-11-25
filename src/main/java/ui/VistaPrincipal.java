package ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import servicio.PostService;
import servicio.UsuarioService;

public class VistaPrincipal extends AbsoluteLayout implements View{

	
	private static final long serialVersionUID = 1L;
	protected static final String NAME = "Main";
	
	private AbsoluteLayout barraSuperior = new AbsoluteLayout();
	private Button botonCerrarSesion = new Button("Cerrar Sesion");
	private Button botonPublicar = new Button("Publicar");
	private TextArea areaTexto = new TextArea("¿Qué estás pensando?");
	private AbsoluteLayout marco = new AbsoluteLayout();
	private AbsoluteLayout principalLayout = new AbsoluteLayout();
	private AreaPost areaPost = new AreaPost();
	private PostService postService = new PostService();
	private HorizontalLayout usuarioLayout = new HorizontalLayout();
	private Label nickUsuarioActual = new Label();
	private Label nombreUsuarioActual = new Label();
	
	public VistaPrincipal(PostService post) {
		cargarComponentes();
		cargarListeners();
		addStyleName("fondoImagen");
	}
	
	private void cargarComponentes() {
		configuracionAreaTexto();
		configuracionMarco();
		configuracionAreaPost();
		configuracionPrincipalLayout();
		configuracionBarra();
		cargarPosts();
		cargarListeners();
	}

	private void cargarPosts() {
		areaPost.addComponent(new Post());
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
//		areaPost.addStyleName("fondoVerde");
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

	private void configuracionBarra() {
		barraSuperior.setHeight("55px");
		barraSuperior.setWidth("100%");
		
		nickUsuarioActual.addStyleName("estiloNick");
		nombreUsuarioActual.addStyleName("estiloNombre");
		barraSuperior.addStyleName("estiloBarra");
		barraSuperior.addComponent(botonCerrarSesion,"top: 10px; right: 10px");
		barraSuperior.addComponent(usuarioLayout,"top: 10px; left: 20px");
		usuarioLayout.addComponent(nickUsuarioActual);
		usuarioLayout.addComponent(nombreUsuarioActual);
		
		configuracionUsuarioActual();
		addComponent(barraSuperior);
//		addComponent(botonCerrarSesion,"right: 20px; top: 12px");
	}
	
	private void cargarListeners(){
		botonCerrarSesion.addClickListener(clickEvent -> clickbotonCerrarSesion());
		botonPublicar.addClickListener(clickEvent -> clickbotonPublicar());
	}
	
	private void configuracionUsuarioActual() {	
	}
	






	private void clickbotonPublicar() {
		String texto = areaTexto.getValue();
		if(postService.textoOK(texto))
//		areaPost.agregarPost(texto);
		areaTexto.setValue("");
	}






	private void clickbotonCerrarSesion() {
		getUI().getNavigator().navigateTo(VistaLogin.NAME);
	}






	@Override
	public void enter(ViewChangeEvent event) {
		nickUsuarioActual.setValue("@"+UsuarioService.usuarioActual.getNick());
		nombreUsuarioActual.setValue("("+UsuarioService.usuarioActual.getNombre()+" "+UsuarioService.usuarioActual.getApellido()+")");
	}

}
