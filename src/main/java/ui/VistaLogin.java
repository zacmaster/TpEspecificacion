package ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;

public class VistaLogin extends AbsoluteLayout implements View{
	private static final long serialVersionUID = 1L;
	protected static final String NAME = "login";
	
	
	AbsoluteLayout marco = new AbsoluteLayout();
	HorizontalLayout header = new HorizontalLayout();
	TextField usuario = new TextField("Usuario:");
	PasswordField password = new PasswordField("Contraseña:");
	Button botonEntrar = new Button("Entrar");
	Button botonregistro = new Button("Registrarse");
	FormLayout form = new FormLayout();
	HorizontalLayout horizontalLayout = new HorizontalLayout();
	Label textoHeader = new Label("Bienvenido a Data Mining!");
	Label textoInicioSesion = new Label("Inicia sesión o registrate para ingresar! :)");
	
	
	
	public VistaLogin(){
		agregarComponentes();
		
		addStyleName("fondoImagen");
	}
	
	private void agregarComponentes(){
		
		setSizeFull();
		horizontalLayout.setDefaultComponentAlignment(Alignment.TOP_CENTER);
		horizontalLayout.setSpacing(true);
		
		
		marco.addComponent(header);
		form.addComponent(usuario);
		form.addComponent(password);
		marco.addComponent(form,"top: 30%; left: 9%");
		marco.addComponent(horizontalLayout,"left: 25%; top: 80%");
		marco.addStyleName("backcolor");
		marco.setWidth("400px");
		marco.setHeight("400px");
		marco.addComponent(textoHeader,"left: 20%; top: 10%");
		marco.addComponent(textoInicioSesion,"top: 25%; left: 15%");
		addComponent(marco,"top: 20%; left: 32%");
		
		
		
		horizontalLayout.addComponent(botonregistro);
		horizontalLayout.addComponent(botonEntrar);
		
				
		cargarListeners();
		textoHeader.addStyleName(ValoTheme.LABEL_LARGE);
		textoHeader.addStyleName(ValoTheme.LABEL_BOLD);
		
	}
	

	private void cargarListeners() {
		botonEntrar.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(VistaPrincipal.NAME);
			}
		});

		botonregistro.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(VistaRegistro.NAME);
			}
		});

	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
