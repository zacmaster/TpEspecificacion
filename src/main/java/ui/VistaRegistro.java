package ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;

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
	private TextField usuario = new TextField("Usuario:");
	private TextField pass = new TextField("Contrase�a:");
	private TextField confPass = new TextField("Confirmar contrase�a:");
	private TextField mail = new TextField("Mail:");
	private TextField confMail = new TextField("Confirmar mail:");
	
	
	
	public VistaRegistro() {
		agregraComponentes();
		agregarCampos();
		cargarListeners();
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
		form.addComponent(usuario);
		form.addComponent(pass);
		form.addComponent(confPass);
		form.addComponent(mail);
		form.addComponent(confMail);
	}
	
	
	
	private void cargarListeners(){
		botonCancelar.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;
			
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(VistaLogin.NAME);
			}

		});
		botonRegistrar.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;
			
			@Override
			public void buttonClick(ClickEvent event) {
			}
		});
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	
}
