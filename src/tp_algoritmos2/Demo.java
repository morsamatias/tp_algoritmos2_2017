package tp_algoritmos2;

import XApplication.Application;
import XApplication.ApplicationListener;

public class Demo {

	public static void main(String[] args) {
		Application app = new Application(new EscuchaApp());
		app.registerFrom(Login.class);
		app.showForm();
	}
	
	public static class EscuchaApp implements ApplicationListener {
		
	}

}
