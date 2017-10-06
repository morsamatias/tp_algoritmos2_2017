package XObject;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class TextPasswordField extends XObject {
	
	String nombre;

	@Override
	public void getObject() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(JPanel panelCentral)
	{
		JLabel xlabel = new JLabel(nombre);
		JPasswordField xtext = new JPasswordField(10);
		xtext.addActionListener(this.getActionListener());
		xtext.setColumns(10);
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
