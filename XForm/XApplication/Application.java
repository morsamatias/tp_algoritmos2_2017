package XApplication;

import java.awt.BorderLayout;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import XClass.XForm;
import tp_algoritmos2.Demo.EscuchaApp;

public class Application {
	private int width = 400;
	private int height = 400;
	private boolean visible = false;
	private JFrame frame;
	// Variable para guardar todos los formularios que va a tener la aplicacion
	Hashtable<String, Class<? extends XForm>> forms = new Hashtable<>();
	
	public Application(EscuchaApp escuchaApp) {
		frame = new JFrame("Contenedor");
		
		JPanel panelCentral = new JPanel();
		JPanel panelSur = new JPanel();
		
		// TODO Eliminar estos de prueba
		JLabel labelTest = new JLabel("Label de Prueba");
		JButton buttonBack = new JButton("Anterior");
		JButton buttonNext = new JButton("Siguiente");
		
		panelCentral.add(labelTest);
		panelSur.add(buttonBack);
		panelSur.add(buttonNext);
		
		frame.add(panelCentral, BorderLayout.CENTER);
		frame.add(panelSur, BorderLayout.SOUTH);
	}

	public void showForm(/*String nombreForm*/) {
//		Class<? extends XForm> formulario = getForm(nombreForm);
//		formulario.draw();
		frame.setSize(getWidth(), getWidth());
		frame.setVisible(true);
	}
	
	// Agrega el formulario a nuestra tabla que los almacena
	public void registerFrom(Class<? extends XForm> formClass) {
		forms.put(formClass.getName(), formClass);
	}
	
	// Devuelve el formulario que se va a usar
	public Class<? extends XForm> getForm(String nombreForm) {
		return forms.get(nombreForm);
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
