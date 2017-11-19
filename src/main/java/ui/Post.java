package ui;

import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;

public class Post extends AbsoluteLayout{
	private static final long serialVersionUID = 1L;
	private Button meGusta = new Button(":)");
	private Button noMeGusta = new Button(":(");
	private Label fecha = new Label("14/12/2018");
	private Label usuario = new Label("Usuario");
	private Label texto = new Label("textooooo");
	private Label textoPuntaje = new Label("Puntuación: ");
	private Label puntaje = new Label("0");
	private AbsoluteLayout marco = new AbsoluteLayout();
	
	public Post() {
		setWidth("100%");
		setHeight("150px");
		addStyleName("fondoRojo");
		addComponent(fecha,"left: 10px; top: 10px;");
		addComponent(usuario,"right: 20px;top: 10px;");
		addComponent(meGusta,"right: 20px; bottom: 10px;");
		addComponent(noMeGusta,"right: 90px; bottom: 10px;");
		texto.addStyleName("post");
		marco.addComponent(texto,"top: 5px; left: 20px;");
		marco.setHeight("40px");
		marco.setWidth("100%");
		addComponent(textoPuntaje,"left: 10px; bottom: 10px;");
		addComponent(puntaje,"left: 100px; bottom: 10px;");
		addComponent(marco,"top: 50px;");
		marco.addStyleName("fondoBlanco");
	}
	
}
