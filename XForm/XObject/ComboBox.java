package XObject;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class ComboBox extends XObject {

	JCheckBox xcheck = null;
	
	@Override
	public void draw(JPanel panelCentral)
	{
		if(xcheck == null){
			xcheck = new JCheckBox(nombre);
			xcheck.addActionListener(this.getActionListener());
			xcheck.setVisible(true);
		}
		panelCentral.add(xcheck);
	}

}
