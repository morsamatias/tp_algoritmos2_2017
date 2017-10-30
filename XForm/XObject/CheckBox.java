package XObject;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class CheckBox extends XObject {

	JCheckBox xcheck = null;
	
	@Override
	public void draw(JPanel panelCentral)
	{
		if(xcheck == null){
			xcheck = new JCheckBox(nombre);
			xcheck.addActionListener(this.getActionListener());
		}
		panelCentral.add(xcheck);
	}

	@Override
	public Boolean getValue()
	{
		return xcheck.isSelected();
	}

}
