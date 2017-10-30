package XObject;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class ComboBox extends XObject {

	@SuppressWarnings("rawtypes")
	JComboBox xcheck = null;
	String[] lista ;

	@SuppressWarnings({"unchecked", "rawtypes"})
	@Override
	public void draw(JPanel panelCentral)
	{
		try
		{
			field.setAccessible(true);
			lista = (String[]) field.get(form);
			xcheck = new JComboBox(lista);
			xcheck.addActionListener(this.getActionListener());
		}
		catch(IllegalArgumentException|IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panelCentral.add(xcheck);
	}

	@Override
	public String[] getValue()
	{
		return lista;
	}

}
