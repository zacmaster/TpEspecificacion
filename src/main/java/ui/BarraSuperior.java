package ui;

import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

import servicio.UsuarioService;

public class BarraSuperior extends AbsoluteLayout{
	private static final long serialVersionUID = 1L;
	
	private Button botonCerrarSesion = new Button("Cerrar Sesion");
	private Label nickUsuarioActual = new Label();
	private Label nombreUsuarioActual = new Label();
	private HorizontalLayout usuarioLayout = new HorizontalLayout();
	
	public BarraSuperior() {
		configuracion();
	}
	
	private void configuracion() {
		setHeight("55px");
		setWidth("100%");
		addStyleName("estiloBarra");
		addComponent(botonCerrarSesion,"top: 10px; right: 10px");
		addComponent(usuarioLayout,"top: 10px; left: 20px");
		nickUsuarioActual.addStyleName("estiloNick");
		nombreUsuarioActual.addStyleName("estiloNombre");
		usuarioLayout.addComponent(nickUsuarioActual);
		usuarioLayout.addComponent(nombreUsuarioActual);
		setearNick();
		botonCerrarSesion.addClickListener(clickEvent -> clickbotonCerrarSesion());
		
	}
	public void setearNick() {
		nickUsuarioActual.setValue("@"+UsuarioService.usuarioActual.getNick());
		nombreUsuarioActual.setValue("("+UsuarioService.usuarioActual.getNombre()+" "+UsuarioService.usuarioActual.getApellido()+")");
	}
	
	private void clickbotonCerrarSesion() {
		UsuarioService.usuarioActual = null;
		getUI().getNavigator().removeView(VistaPrincipal.NAME);
		getUI().getNavigator().navigateTo(VistaLogin.NAME);
	}
}
