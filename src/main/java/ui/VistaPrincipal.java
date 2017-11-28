package ui;


import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextArea;


public class VistaPrincipal extends AbsoluteLayout implements View{

	
	private static final long serialVersionUID = 1L;
	protected static final String NAME = "Main";
	
	private BarraSuperior barraSuperior = new BarraSuperior();
	private Button botonPublicar = new Button("Publicar");
	private TextArea areaTexto = new TextArea("¿Qué estás pensando?");
	private AbsoluteLayout marco = new AbsoluteLayout();
	private AbsoluteLayout principalLayout = new AbsoluteLayout();
	private AreaPost areaPost = new AreaPost();
	
	
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
		cargarListeners();
		addComponent(barraSuperior);
	}


	private void configuracionPrincipalLayout(){
		principalLayout.setWidth("70%");
		principalLayout.setHeight("100%");
		addComponent(principalLayout,"top: 61px; left: 20%");
	}

	private void configuracionAreaPost(){
		principalLayout.addComponent(areaPost,"top: 150px");
	}
	private void configuracionAreaTexto() {
		areaTexto.setMaxLength(300);
		areaTexto.setWidth("100%");
		areaTexto.setHeight("50px");
		principalLayout.addComponent(marco,"top: 0px");
	}

	private void configuracionMarco(){
		marco.setWidth("100%");
		marco.setHeight("150px");
		marco.addComponent(areaTexto,"top: 35px");
		marco.addComponent(botonPublicar,"top: 98px; right: 10px");
		marco.addStyleName("mymargins");
		
	}

	
	private void cargarListeners(){
		botonPublicar.addClickListener(clickEvent -> clickbotonPublicar());
	}
	



	private void clickbotonPublicar() {
		String texto = areaTexto.getValue();
		if(!texto.isEmpty()) {
			
			
			areaPost.agregarNuevoPostUI(areaPost.agregarPostNegocio(texto));
			
		}
		areaTexto.clear();
	}

	

	@Override
	public void enter(ViewChangeEvent event) {
		areaPost.cargarPost();	
	}
}
