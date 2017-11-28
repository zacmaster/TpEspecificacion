package ui;


import com.vaadin.navigator.View;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Panel;

public class VistaPrueba extends AbsoluteLayout implements View{
	private static final long serialVersionUID = 1L;
	protected static final String NAME = "Prueba";
	private AbsoluteLayout al = new AbsoluteLayout();
	
//	Post post = new Post();
	
	
	public VistaPrueba() {
//		al.setWidth("800px");
//		al.setHeight("100%");
		al.setSizeFull();
//		al.addComponent(new Button("nuevoBoton"),"top: 0px;");
		al.addStyleName("fondoVerde");
//		addStyleName("layoutScrollable");
		
		Panel p = new Panel();
//		p.setSizeFull();
		p.setWidth("400px");
		p.setHeight("300px");
		p.setContent(al);
		addComponent(p);
		setSizeFull();
		addStyleName("fondoRojo");
//		addStyleName("v-absolutelayout");
//		addComponent(al);
		cargarBotones();
		
//		addStyleName("fondoVerde");
//		addComponent(post);
	}
	public void cargarBotones() {
		int topPosicion = 40;
		for (int i = 0; i < 30; i++) {
			String s = ""+i;
			
			al.addComponent(new Button(s),"top: "+topPosicion+"px;");
			topPosicion+=30;
		}
	}


}
