package ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;

import servicio.PostService;

public class VistaPrincipal extends AbsoluteLayout implements View{

	
	private static final long serialVersionUID = 1L;
	protected static final String NAME = "Main";
	private Panel panelSuperior = new Panel();
	private Button botonCerrarSesion = new Button("Cerrar Sesion");
	private Button botonPublicar = new Button("Publicar");
	private TextArea areaTexto = new TextArea("¿Qué estás pensando?");
	private AbsoluteLayout marco = new AbsoluteLayout();
	private AbsoluteLayout principalLayout = new AbsoluteLayout();
	private AreaPost areaPost = new AreaPost();
	private PostService postService = new PostService();
	
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
		configuracionPanel();
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

	private void configuracionPanel() {
		panelSuperior.setSizeFull();
		panelSuperior.setHeight("61px");
		addComponent(panelSuperior);
		addComponent(botonCerrarSesion,"right: 20px; top: 12px");
	}
	
	
	
	private void cargarListeners(){
		botonCerrarSesion.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(VistaLogin.NAME);
			}

		});
		botonPublicar.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				String texto = areaTexto.getValue();
				if(postService.textoOK(texto))
//				areaPost.agregarPost(texto);
				areaTexto.setValue("");
			}
		});
	}
	
	
	






	@Override
	public void enter(ViewChangeEvent event) {
		
	}

}
