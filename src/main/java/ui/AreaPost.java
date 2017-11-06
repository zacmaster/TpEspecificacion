package ui;

import java.util.ArrayList;




import antlr.collections.List;

import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Label;

public class AreaPost extends AbsoluteLayout{
	private static final long serialVersionUID = 1L;
	private ArrayList<Label>  posts = new ArrayList<Label>();
	
	public AreaPost() {
		configuracion();
	}
	
	private void configuracion(){
		setWidth("100%");
		setHeight("700px");
//		addStyleName("fondoVerde");
	}
	
	
	
	public void agregarPost(String texto){
		Label etiqueta = new Label(texto);
		etiqueta.setWidth("100%");
//		etiqueta.addStyleName("backcolor");
		etiqueta.addStyleName("wrapLine");
		posts.add(etiqueta);
		reAcomodarEtiquetas();
		etiqueta.addStyleName("post");
		addComponent(etiqueta,"top: 0px");
		
	}

	private void reAcomodarEtiquetas() {
		if(posts.size() != 0){
			removeAllComponents();
			int posicionY = 0;
			for (int i = posts.size()-1; i >= 0 ; i--) {
				posts.get(i).addStyleName("post");
				addComponent(posts.get(i),"top: "+posicionY+"px");
				posicionY += 36;
			}
		}
	}
	
	public void leerPosts(ArrayList<String> posts){
		removeAllComponents();
		for (int i = 0; i < posts.size(); i++) {
			Label label = new Label(posts.get(i));
			label.addStyleName("wrapLine");
			this.posts.add(label);
			
		}
		reAcomodarEtiquetas();
	}
}

