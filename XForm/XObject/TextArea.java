package XObject;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.GroupLayout.Alignment;

public class TextArea extends XObject {
	
	JLabel xlabel;
	JTextArea xarea;
	
	@Override
	public void draw(JPanel panelCentral)
	{
		xlabel = new JLabel(nombre);
		xarea = new JTextArea(10,30);
		try
		{
			String datos = (String) field.get(form);
			xarea.setText(datos);
//			xarea.addActionListener(this.getActionListener());
		}
		catch(IllegalArgumentException|IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panelCentral.add(xlabel);
		panelCentral.add(xarea);
	}

	@Override
	public String getValue()
	{
		return xarea.getText();
	}

	@Override
	public int getValueSelected()
	{
		// TODO Auto-generated method stub
		return 0;
	}

}
