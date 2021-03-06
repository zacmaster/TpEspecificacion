package ui;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;


@Theme("mytheme")
public class TpUI extends UI {
	private static final long serialVersionUID = 1L;
	private Navigator navigator;
	
	
	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = TpUI.class, productionMode = false)
	public static class TpUIServlet extends VaadinServlet {
		private static final long serialVersionUID = 1L;
	}
	
	
	@Override
	protected void init(VaadinRequest request) {
		
		navigator = new Navigator(this,this);
		navigator.addView(VistaLogin.NAME, new VistaLogin());
//		navigator.addView(VistaPrueba.NAME, new VistaPrueba());
//		navigator.navigateTo(VistaPrueba.NAME);
		navigator.navigateTo(VistaLogin.NAME);
		
	}

}