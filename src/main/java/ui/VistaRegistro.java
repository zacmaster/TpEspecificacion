package ui;

import javax.swing.text.html.HTMLDocument.HTMLReader.FormAction;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
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
		if(camposCompletos()) {
			if(usuarioValido()) {
				if(coincidenPass()) {
					if(coincidenMails()) {
						if(Validadores.formatoPassValido(pass.getValue())) {
							if(Validadores.formatoEmailValido(mail.getValue())) {
								Usuario u = new Usuario();
								u.setNombre(nombre.getValue());
								u.setApellido(apellido.getValue());
								u.setPassword(pass.getValue());
								u.setNick(nick.getValue());
								u.setMail(mail.getValue());
								
								UsuarioService us = new UsuarioService();
								us.guardarUsuario(u);
								
								Notification.show("Se ha registrado exitosamente.", Notification.Type.TRAY_NOTIFICATION);
							}
							else {
								Notification.show("Formato de email invalido.", Notification.Type.ERROR_MESSAGE);				
							}
						}
						else {
							Notification.show("Formato invalido de contraseña."
									+ "\nDebe tener entre 8 y 16 caracteres."
									+ "\nDebe tener al menos una letra mayuscula."
									+ "\nDebe tener al menos un número."
									+ "\nDebe tener al menos un caracter especial (@#$%^&+=).", Notification.Type.ERROR_MESSAGE);				
						}
					}
					else {
						Notification.show("Error al confirmar email.", Notification.Type.ERROR_MESSAGE);				
					}
				}
				else {
					Notification.show("Error al confirmar contraseña.", Notification.Type.ERROR_MESSAGE);				
				}
			}
			else {
				Notification.show("El nick ya esta en uso.", Notification.Type.ERROR_MESSAGE);
			}
		}
		else {
			Notification.show("Complete todos los campos.", Notification.Type.ERROR_MESSAGE);
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

	private void clickbotonCancelar() {
		getUI().getNavigator().removeView(VistaRegistro.NAME);
		getUI().getNavigator().navigateTo(VistaLogin.NAME);
	}


	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	
}
