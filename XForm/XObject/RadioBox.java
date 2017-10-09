package XObject;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioBox extends XObject {

	@Override
	public void draw(JPanel panelCentral)
	{
		JRadioButton xcheck = new JRadioButton(nombre);
		xcheck.addActionListener(this.getActionListener());
		xcheck.setVisible(true);
		panelCentral.add(xcheck);
	}

}
