package XObject;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextField extends XObject {
		
	@Override
	public void draw(JPanel panelCentral)
	{
		JLabel xlabel = new JLabel(nombre);
		JTextField xtext = new JTextField();
		xtext.addActionListener(this.getActionListener());
		xtext.setColumns(10);
		xtext.setVisible(true);
		panelCentral.add(xlabel);
		panelCentral.add(xtext);		
	}
  
}
