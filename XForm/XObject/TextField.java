package XObject;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextField extends XObject {
	
	JLabel xlabel;
	JTextField xtext;
	
	@Override
	public void draw(JPanel panelCentral)
	{
		if (xtext == null) {
			xlabel = new JLabel(nombre);
			xtext = new JTextField();
			xtext.addActionListener(this.getActionListener());
			xtext.setColumns(10);
		}
		panelCentral.add(xlabel);
		panelCentral.add(xtext);
	}

	@Override
	public String getValue()
	{
		return xtext.getText();
		
	}
  
}
