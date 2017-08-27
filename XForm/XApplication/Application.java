package XApplication;

import java.util.Hashtable;

import XClass.XForm;
import tp_algoritmos2.Demo.EscuchaApp;

public class Application {
	private int width = 100;
	private int height = 100;
	private boolean visible = false;
	

	// Variable para guardar todos los formularios que va a tener la aplicacion
	Hashtable<String, Class<? extends XForm>> forms = new Hashtable<>();
	
	public Application(EscuchaApp escuchaApp) {
		// TODO Auto-generated constructor stub
	}

	public void showForm(String nombre_formulario) {
		// TODO
	}
	
	// Agrega el formulario a nuestra tabla que los almacena
	public void registerFrom(Class<? extends XForm> formClass) {
		forms.put(formClass.getName(), formClass);
	}
	
	// Setea el tamanio del formulario
	public void setSize(int width_value, int height_value) {
		setWidth(width_value);
		setHeight(height_value);
	}
	
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
