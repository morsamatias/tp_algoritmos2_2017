package XObject;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TextArea extends XObject {
	
	String nombre;

	@Override
	public void getObject() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(JPanel panelCentral)
	{
		JLabel xlabel = new JLabel(nombre);
		JTextArea xtext = new JTextArea();
		xtext.setSize(50, 100);
		xtext.setVisible(true);
		panelCentral.add(xlabel);
		panelCentral.add(xtext);	
		
	}

	@Override
	public void setObject(String nombre)
	{
		this.nombre = nombre;
		// TODO Auto-generated method stub
		
	}

}
