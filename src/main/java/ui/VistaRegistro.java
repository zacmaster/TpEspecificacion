package ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;

import negocio.Usuario;
import servicio.UsuarioService;

public class VistaRegistro extends AbsoluteLayout implements View{

	protected static final String NAME = "registro";
	private static final long serialVersionUID = 1L;
	private FormLayout form = new FormLayout();
	private HorizontalLayout horizontalLayout = new HorizontalLayout();
	private AbsoluteLayout marco = new AbsoluteLayout();
//	private Label titulo = new Label("Complete los campos ");
	
	
	private Button botonRegistrar = new Button("Registrar");
	private Button botonCancelar = new Button("Volver");
	
	private TextField nombre = new TextField("Nombre:");
	private TextField apellido = new TextField("Apellido:");
	private TextField nick = new TextField("Nick:");
	private PasswordField pass = new PasswordField("Contraseña:");
	private PasswordField confPass = new PasswordField("Confirmar contraseña:");
	private TextField mail = new TextField("Mail:");
	private TextField confMail = new TextField("Confirmar mail:");
	
	
//			usuarioInstancia.getNombre(),usuarioInstancia.setNombre());
	
	
	
	public VistaRegistro() {
		agregraComponentes();
		agregarCampos();
		cargarListeners();
		addStyleName("fondoImagen");
	}
	
	
	private void agregraComponentes() {
		marco.addComponent(form,"top: 30px; left: 20px");
		horizontalLayout.addComponent(botonCancelar);
		horizontalLayout.addComponent(botonRegistrar);
		horizontalLayout.setWidth("315px");
		horizontalLayout.setSpacing(true);
		marco.addComponent(horizontalLayout,"top: 460px; left: 60px");
		addComponent(marco,"left: 30%; top: 5%");
		marco.addStyleName("backcolor");
		marco.setWidth("400px");
		marco.setHeight("550px");
	}

	private void agregarCampos(){
		form.addComponent(nombre);
		form.addComponent(apellido);
		form.addComponent(nick);
		form.addComponent(pass);
		form.addComponent(confPass);
		form.addComponent(mail);
		form.addComponent(confMail);
	}
	
	
	
	private void cargarListeners(){
		botonCancelar.addClickListener(clickEvent -> clickbotonCancelar());
		botonRegistrar.addClickListener(clickEvent -> clickbotonRegistrar());
	}
	
	
	private void clickbotonRegistrar() {
		Usuario u = new Usuario();
		u.setNombre(nombre.getValue());
		u.setApellido(apellido.getValue());
		u.setPassword(pass.getValue());
		u.setNick(nick.getValue());
		u.setMail(mail.getValue());
		
		UsuarioService us = new UsuarioService();
		us.guardarUsuario(u);
	}


	private void clickbotonCancelar() {
		getUI().getNavigator().navigateTo(VistaLogin.NAME);
	}


	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	
}
