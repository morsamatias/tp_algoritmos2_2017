package XObject;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class ComboBox extends XObject {

	JComboBox<String> xcheck = null;
	
	@Override
	public void draw(JPanel panelCentral)
	{
		if(xcheck == null){
			xcheck = new JComboBox<>();
			xcheck.addActionListener(this.getActionListener());
			xcheck.setVisible(true);
		}
		panelCentral.add(xcheck);
	}

}
