package ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
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
	
	private UsuarioService usuarioService = new UsuarioService();
	
	private Button botonRegistrar = new Button("Registrar");
	private Button botonCancelar = new Button("Volver");
	
	private Label mensaje = new Label("Registrese completando todos los campos:");
	private TextField nombre = new TextField("Nombre ");
	private TextField apellido = new TextField("Apellido ");
	private TextField nick = new TextField("Nick ");
	private PasswordField pass = new PasswordField("Contraseña ");
	private PasswordField confPass = new PasswordField("Confirmar contraseña ");
	private TextField mail = new TextField("Mail ");
	private TextField confMail = new TextField("Confirmar mail ");
	
	
	
	
	
	public VistaRegistro() {
		agregraComponentes();
		configurarCampos();
		agregarCampos();
		cargarListeners();
		addStyleName("fondoImagen");
	}
	
	
	private void agregraComponentes() {
		marco.addComponent(mensaje,"top:30px;left:20px");
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
	
	private void configurarCampos() {
		nombre.setRequiredIndicatorVisible(true);
		apellido.setRequiredIndicatorVisible(true);
		nick.setRequiredIndicatorVisible(true);
		pass.setRequiredIndicatorVisible(true);
		confPass.setRequiredIndicatorVisible(true);
		mail.setRequiredIndicatorVisible(true);
		confMail.setRequiredIndicatorVisible(true);
	}
	
	private void cargarListeners(){
		botonCancelar.addClickListener(clickEvent -> clickbotonCancelar());
		botonRegistrar.addClickListener(clickEvent -> clickbotonRegistrar());
	}
	
	
	private void clickbotonRegistrar() {
		int error = 0;
		if(camposCompletos() && coincidenPass() && coincidenMails()) {
			error++;
			if(usuarioValido()) {
				error++;
				if(negocio.Validadores.formatoPassValido(pass.getValue())) {
						error= -1;
						Usuario u = new Usuario();
						u.setNombre(nombre.getValue());
						u.setApellido(apellido.getValue());
						u.setPassword(pass.getValue());
						u.setNick(nick.getValue());
						u.setMail(mail.getValue());
						
						UsuarioService us = new UsuarioService();
						us.guardarUsuario(u);
							
						Notification.show("Se ha registrado exitosamente.", Notification.Type.TRAY_NOTIFICATION);
		}	}	}	
		
		if(error != -1) {					
			Notification.show(mensajeError(error), Notification.Type.ERROR_MESSAGE);
		}
	}
	
	private boolean camposCompletos() {
		return (!nombre.isEmpty() && !apellido.isEmpty() && !pass.isEmpty() && !nick.isEmpty() && !mail.isEmpty());
	}
	
	private boolean usuarioValido()	{
		if(usuarioService.seAceptaUsuario(nick.getValue())) {
			return true;
		}
		return false;
	}
	
	private boolean coincidenPass() {
		return pass.getValue().equals(confPass.getValue());
	}
	
	private boolean coincidenMails() {
		return mail.getValue().equals(confMail.getValue());
	}
	
	private String mensajeError(int e) {
		switch (e) {
		case 0:
			return "Verifique que se haya ingresado correctamente todos los campos.";
		case 1:
			return "El nick ya se encuentra en uso.";
		default:
			return "Formato invalido de contraseña.\nDebe tener entre 4 y 8 caracteres.\nDebe tener al menos un número.";
		}
	}
	private void clickbotonCancelar() {
		getUI().getNavigator().removeView(VistaRegistro.NAME);
		getUI().getNavigator().navigateTo(VistaLogin.NAME);
	}


	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	
}
