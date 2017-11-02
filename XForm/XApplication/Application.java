package XApplication;

import java.awt.BorderLayout;
import java.util.Hashtable;

import javax.swing.*;
import XClass.XForm;
import XObject.XObject;
import tp_algoritmos2.Demo.EscuchaApp;

public class Application {
	
	private int width = 400;
	private int height = 400;
	private boolean visible = false;
	private JFrame frame;
	private JPanel panelCentral;
	private JPanel panelSur;
	private Object object = null;
	// Variable para guardar todos los formularios que va a tener la aplicacion
	Hashtable<String,XForm> forms = new Hashtable<>();
	
	public Application(EscuchaApp escuchaApp) {
		
		frame = new JFrame("contenedor");

		panelCentral = new JPanel();
		panelSur = new JPanel();

		frame.add(panelCentral, BorderLayout.CENTER);
		frame.add(panelSur, BorderLayout.SOUTH);
	}
	
	public void showForm(String nombreForm) {
		XForm form = forms.get(nombreForm);
		form.onLoad();
		form.draw();
		frame.setSize(getWidth(), getWidth());
		frame.setVisible(true);
	}

	// Agrega el formulario a nuestra tabla que los almacena
	public void registerFrom(Class<? extends XForm> formClass) {
		try {
			XForm form = formClass.newInstance();
			form.setFrame(this);
			forms.put(form.getNombre(), form);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | SecurityException e) {
			e.printStackTrace();
		}
	}
	
	public XForm getForm(String nombreForm)
	{
		return forms.get(nombreForm);
	}
		
	public void addComponent(XObject component)
	{
		component.draw(panelCentral);
		
	}
	
	public void setAnObject(Object object)
	{
		this.object = object;		
	}
	
	public Object getAnObject(){
		return this.object;
	}
	
	public JPanel getPanelCentral()
	{
		return panelCentral;
	}
	
	public JPanel getPanelSur()
	{
		return panelSur;
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
	
	public void setTitulo(String titulo)
	{
		this.frame.setTitle(titulo) ;
	}

	public void limpiaForm() {
		panelCentral.removeAll();
		panelCentral.revalidate();
		panelCentral.repaint();
		panelSur.removeAll();
		panelSur.revalidate();
		panelSur.repaint();
	}
}
