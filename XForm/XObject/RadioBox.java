package XObject;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioBox extends XObject {
	
	JRadioButton xcheck = null;
		
	@Override
	public void draw(JPanel panelCentral)
	{
		if (xcheck == null) {
			xcheck = new JRadioButton(nombre);
			xcheck.addActionListener(this.getActionListener());
			xcheck.setVisible(true);
		}
		panelCentral.add(xcheck);
	}

}
