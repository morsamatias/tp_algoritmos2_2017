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
		field.setAccessible(true);
		try
		{
			xlabel = new JLabel(nombre);
			xpass = new JPasswordField(10);
			String datos = (String) field.get(form);
			xpass.setText(datos);
			xpass.addActionListener(this.getActionListener());
		}
		catch(IllegalArgumentException|IllegalAccessException e)
		{
			e.printStackTrace();
		}
		panelCentral.add(xlabel);
		panelCentral.add(xpass);
	}

	@Override
	public String getValue()
	{
		return new String(xpass.getPassword());
	}

	@Override
	public int getValueSelected()
	{
		// TODO Auto-generated method stub
		return 0;
	}

}
