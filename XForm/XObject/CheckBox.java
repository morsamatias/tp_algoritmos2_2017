package XObject;

import java.awt.BorderLayout;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class CheckBox extends XObject {

	JCheckBox xcheck;
	
	@Override
	public void draw(JPanel panelCentral)
	{
		field.setAccessible(true);
		try
		{
			xcheck = new JCheckBox(nombre);
			boolean datos = (Boolean) field.get(form);
			xcheck.setSelected(datos);
			xcheck.addActionListener(this.getActionListener());
		}
		catch(IllegalArgumentException|IllegalAccessException e)
		{
			e.printStackTrace();
		}
		panelCentral.add(xcheck);
	}

	@Override
	public Boolean getValue()
	{
		return xcheck.isSelected();
	}

	@Override
	public int getValueSelected()
	{
		// TODO Auto-generated method stub
		return 0;
	}

}
