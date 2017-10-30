package XObject;

import java.util.*;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioBox extends XObject {
	
	String[] lista ;
	List<JRadioButton> listaRadios = new ArrayList<JRadioButton>();
	
	JRadioButton xradio = null;
	JLabel xlabel;
	
	@Override
	public void draw(JPanel panelCentral)
	{
		ButtonGroup grupo = new ButtonGroup();
		try
		{
			field.setAccessible(true);
			lista = (String[]) field.get(form);
			xlabel = new JLabel(nombre);
			for(String string:lista)
			{
				xradio = new JRadioButton(string);
				xradio.addActionListener(this.getActionListener());
				grupo.add(xradio);
				listaRadios.add(xradio);
			}
		}
		catch(IllegalArgumentException|IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panelCentral.add(xlabel);
		for(JRadioButton jRadioButton:listaRadios)
		{
			panelCentral.add(jRadioButton);
		}
	}

	@Override
	public String[] getValue()
	{
		return lista;
	}

}
