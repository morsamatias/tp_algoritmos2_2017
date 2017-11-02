package XObject;

import javax.swing.*;

public class TextField extends XObject {
	
	JLabel xlabel;
	JTextField xtext;
	
	@Override
	public void draw(JPanel panelCentral)
	{
		field.setAccessible(true);
		try
		{
			xlabel = new JLabel(nombre);
			xtext = new JTextField();
			String datos = (String) field.get(form);
			xtext.setText(datos);
			xtext.addActionListener(this.getActionListener());
			xtext.setColumns(10);
		}
		catch(IllegalArgumentException|IllegalAccessException e)
		{
			e.printStackTrace();
		}
		panelCentral.add(xlabel);
		panelCentral.add(xtext);
	}

	@Override
	public String getValue()
	{
		return xtext.getText();
		
	}

	@Override
	public int getValueSelected()
	{
		// TODO Auto-generated method stub
		return 0;
	}
  
}
