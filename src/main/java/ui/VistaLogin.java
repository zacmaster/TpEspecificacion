package ui;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import servicio.UsuarioService;

import com.vaadin.ui.Button.ClickEvent;

public class VistaLogin extends GridLayout implements View{
	private Button botonRegistro = new Button("Registrarse");
	private Button botonIngreso = new Button("Ingresar");
	private UsuarioService usuarioService = new UsuarioService();
	private TextField userName = new TextField("Usuario");
	private PasswordField password = new PasswordField("Password");
	private PopupView popup = new PopupView("Pop it up", new VerticalLayout());
	
	private static final long serialVersionUID = 1L;
	public static final String NAME = "prueba";

	public VistaLogin() {
		super(3,3);
		cargarListeners();
		cargarComponentes();
	}
	
	private void  cargarComponentes() {
		Panel loginPanel = new Panel("Bienvenido a DataMining!");
		CustomLayout content = new CustomLayout("myLayout");
		loginPanel.setContent(content);
		loginPanel.setWidth("80%");
		loginPanel.setHeight("400px");
		loginPanel.setContent(content);

		
		content.addComponent(new Label("Inicia sesión o registrate para ingresar! "), "mensajeBienvenida");
		content.addComponent(userName);
		content.addComponent(password);
		content.addComponent(botonRegistro,"registerButton");
		content.addComponent(botonIngreso, "okbutton");
		
		
		setSizeFull();
		addComponent(loginPanel,1,1);
		addComponent(popup);
		addStyleName("fondoImagen");
	}
	
	
	private void cargarListeners() {
		botonIngreso.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void buttonClick(ClickEvent event) {
				if(usuarioService.seAceptaLogin(userName.getValue(), password.getValue())) {
					getUI().getNavigator().navigateTo(VistaPrincipal.NAME);
				}					
				else {
					popup.setPopupVisible(true);
//					VerticalLayout popupContent = new VerticalLayout();
//					popupContent.addComponent(new TextField("te logeaste para elc ulo"));
//					popupContent.addComponent(new Button("cerrar"));
//
//					// The component itself
//					PopupView popup = new PopupView("Pop it up", popupContent);
//					addComponent(popup);
				}
					
			}
		});

		botonRegistro.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(VistaRegistro.NAME);
			}
		});

	}
	
	private void cargarPopUp() {
		// Content for the PopupView

		// The component itself
		
		addComponent(popup);
	}
}
