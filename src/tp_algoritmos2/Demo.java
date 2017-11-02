package tp_algoritmos2;

import XApplication.Application;
import XApplication.ApplicationListener;

public class Demo {

	public static void main(String[] args) {
		Application app = new Application(new EscuchaApp());
//		app.registerFrom(Login.class);
//		app.registerFrom(Turnos.class);
//		app.registerFrom(Cierra.class);
//		app.showForm("Login");
		app.registerFrom(Pantalla1.class);
		app.registerFrom(Pantalla2.class);
		app.showForm("Pantalla1");
	}
	
	public static class EscuchaApp implements ApplicationListener {
		
	}

}
