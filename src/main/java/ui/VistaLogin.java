package ui;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;

public class VistaLogin extends GridLayout implements View{
	private Button botonRegistro = new Button("Registrarse");
	private Button botonIngreso = new Button("Ingresar");
	
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
		content.addComponent(new TextField(), "username");
		content.addComponent(new PasswordField(), "password");
		content.addComponent(botonRegistro,"registerButton");
		content.addComponent(botonIngreso, "okbutton");
		
		
		setSizeFull();
		addComponent(loginPanel,1,1);
		addStyleName("fondoImagen");
	}
	
	
	private void cargarListeners() {
		botonIngreso.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(VistaPrincipal.NAME);
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
}
