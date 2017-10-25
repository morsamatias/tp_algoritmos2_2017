package tp_algoritmos2;

import XApplication.Application;
import XApplication.ApplicationListener;

public class Demo {

	public static void main(String[] args) {
		Application app = new Application(new EscuchaApp());
		app.registerFrom(Login.class);
		app.registerFrom(Login2.class);
		app.registerFrom(Cierra.class);
		app.showForm("Login");
	}
	
	public static class EscuchaApp implements ApplicationListener {
		
	}

}
