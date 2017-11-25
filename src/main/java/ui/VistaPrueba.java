package ui;

import com.vaadin.navigator.View;
import com.vaadin.ui.VerticalLayout;

public class VistaPrueba extends VerticalLayout implements View{
	private static final long serialVersionUID = 1L;
	protected static final String NAME = "Prueba";

	
	Post post = new Post();
	
	
	public VistaPrueba() {
		addStyleName("fondoVerde");
		addComponent(post);
	}


}
