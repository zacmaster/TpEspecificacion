package ui;

import com.vaadin.navigator.View;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class VistaPrueba extends VerticalLayout implements View{
	private static final long serialVersionUID = 1L;
	protected static final String NAME = "Prueba";
	private AbsoluteLayout al = new AbsoluteLayout();
	private Panel p = new Panel();
	
//	Post post = new Post();
	
	
	public VistaPrueba() {
		al.setWidth("30px");
		al.addComponent(new Button("nuevoBoton"));
		al.addStyleName("fondoVerde");
		p.setContent(al);
		p.setWidth("100%");
		p.addStyleName("fondoRojo");
		addComponent(p);
		
		
//		addStyleName("fondoVerde");
//		addComponent(post);
	}


}
