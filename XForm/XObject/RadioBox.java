package XObject;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioBox extends XObject {
	
	String[] lista ;
	
	JRadioButton xcheck = null;
	
	@Override
	public void draw(JPanel panelCentral)
	{
		if (xcheck == null) {
			ButtonGroup grupo = new ButtonGroup();
			try
			{
				field.setAccessible(true);
				lista = (String[]) field.get(form);
				JLabel xlabel = new JLabel(nombre);
				panelCentral.add(xlabel);
				for(String string:lista)
				{
					xcheck = new JRadioButton(string);
					xcheck.addActionListener(this.getActionListener());
					xcheck.setVisible(true);
					grupo.add(xcheck);
					panelCentral.add(xcheck);
				}
			}
			catch(IllegalArgumentException|IllegalAccessException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
