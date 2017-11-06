package ui;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

import servicio.PostService;

@SuppressWarnings("serial")
@Theme("tp")
public class TpUI extends UI {

	private Navigator navigator;
	private PostService postService = new PostService();
	
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = TpUI.class)
	public static class Servlet extends VaadinServlet {
	}
	
	
	@Override
	protected void init(VaadinRequest request) {
		
		navigator = new Navigator(this,this);
		navigator.addView(VistaPrincipal.NAME, new VistaPrincipal(postService));
		navigator.addView(VistaRegistro.NAME, new VistaRegistro());
		navigator.addView(VistaLogin.NAME, new VistaLogin());
		navigator.navigateTo(VistaLogin.NAME);
		
	}

}