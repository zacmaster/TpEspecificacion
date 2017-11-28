package ui;

import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;


public class Post extends AbsoluteLayout{
	private static final long serialVersionUID = 1L;
	private Button meGusta = new Button(":)");
	private Button noMeGusta = new Button(":(");
	private Label fecha = new Label("");
	private Label usuario = new Label("");
	private Label texto = new Label();
	private Label textoPuntaje = new Label("Puntuación: ");
	private Label puntaje = new Label("");
	private AbsoluteLayout marco = new AbsoluteLayout();
	
	public Post(negocio.Post postNegocio) {
		sincronizarDatos(postNegocio);
		setWidth("100%");
		setHeight("150px");
		addStyleName("fondoPost");
		addComponent(fecha,"left: 10px; top: 0px;");
		addComponent(usuario,"right: 20px;top: 0px;");
		addComponent(meGusta,"right: 20px; bottom: 3px;");
		addComponent(noMeGusta,"right: 90px; bottom: 3px;");
		addComponent(textoPuntaje,"left: 10px; bottom: 10px;");
		texto.setWidth("100%");
		marco.addComponent(texto,"top: 5px; left: 20px;");
		marco.setHeight("80px");
		marco.setWidth("100%");
		addComponent(puntaje,"left: 130px; bottom: 10px;");
		addComponent(marco,"top: 25px;");
		meGusta.addStyleName("estiloBoton");
		noMeGusta.addStyleName("estiloBoton");
		usuario.addStyleName("estiloTitulosPost");
		fecha.addStyleName("estiloTitulosPost");
		puntaje.addStyleName("estiloTitulosPost");
		textoPuntaje.addStyleName("estiloTitulosPost");
	}

	private void sincronizarDatos(negocio.Post postNegocio) {
		fecha.setValue(postNegocio.getFecha());
		texto.setValue(postNegocio.getTexto());
		usuario.setValue("@"+postNegocio.getNickUsuario());
		puntaje.setValue(postNegocio.getPuntuacion().toString());
	}
	
}
