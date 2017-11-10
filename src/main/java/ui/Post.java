package ui;

import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;

public class Post extends Panel{
	private Button meGusta = new Button("Me gusta");
	private Button noMeGusta = new Button("No me gusta");
	private Label usuario = new Label("Usuario");
	private Label texto;
	
	
	public Post() {
		addStyleName("fondoVerde");
		setContent(meGusta);
	}
	
}
