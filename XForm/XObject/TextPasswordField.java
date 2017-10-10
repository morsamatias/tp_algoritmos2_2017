package XObject;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class TextPasswordField extends XObject {
	
	JLabel xlabel;
	JPasswordField xpass;
	
	@Override
	public void draw(JPanel panelCentral)
	{
		if (xpass == null) {
			xlabel = new JLabel(nombre);
			xpass = new JPasswordField(10);
			xpass.addActionListener(this.getActionListener());
			xpass.setColumns(10);
			xpass.setVisible(true);
		}
		panelCentral.add(xlabel);
		panelCentral.add(xpass);
	}

}
