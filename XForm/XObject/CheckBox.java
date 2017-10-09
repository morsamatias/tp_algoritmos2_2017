package XObject;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class CheckBox extends XObject {

	@Override
	public void draw(JPanel panelCentral)
	{
		JCheckBox xcheck = new JCheckBox(nombre);
		xcheck.addActionListener(this.getActionListener());
		xcheck.setVisible(true);
		panelCentral.add(xcheck);		
		// TODO Auto-generated method stub
		
	}

}
