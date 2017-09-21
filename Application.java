package XApplication;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.peer.ButtonPeer;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import XAnnotation.BackButton;
import XAnnotation.NextButton;
import XClass.XForm;
import XObject.XObject;
import tp_algoritmos2.Demo.EscuchaApp;

public class Application  {
	
	
	private int width = 400;
	private int height = 400;
	private boolean visible = false;
	private JFrame frame;
	private JPanel panelCentral;
	private NextButton siguiente;
	private BackButton anterior;
	// Variable para guardar todos los formularios que va a tener la aplicacion
	ArrayList<XForm> forms = new ArrayList<>();
	
	public Application(EscuchaApp escuchaApp) {
		
	
	frame = new JFrame("Contenedor");
			
		panelCentral = new JPanel();
		JPanel panelSur = new JPanel();
				
		JButton buttonBack = new JButton("Anterior");
		JButton buttonNext = new JButton("Siguiente");
		
		// panelCentral.add(labelTest);
		panelSur.add(buttonBack);
		panelSur.add(buttonNext);
		
		frame.add(panelCentral, BorderLayout.CENTER);
		frame.add(panelSur, BorderLayout.SOUTH);
	}
	
	public void showForm() {
		XForm formulario = getForm();
		formulario.draw(this);
		frame.setSize(getWidth(), getWidth());
		frame.setVisible(true);
	}
	
	// Agrega el formulario a nuestra tabla que los almacena
	public void registerFrom(XForm formClass) {
		forms.add(formClass);
	}
	
	// Devuelve el formulario que se va a usar
	public XForm getForm() {
		return forms.get(0);
	}
	
	public void addComponent(XObject component)
	{
		component.draw(panelCentral);
	}
	
	public JPanel getPanelCentral()
	{
		return panelCentral;
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
	
	public void setSiguiente(NextButton siguiente){
		this.siguiente = siguiente;
	}
	public void setAnterior(BackButton anterior){
		this.anterior = anterior; 
	}
	
}
