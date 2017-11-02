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
		field.setAccessible(true);
		try
		{
			lista = (String[]) field.get(form);
			xcheck = new JComboBox(lista);
			xcheck.addActionListener(this.getActionListener());
		}
		catch(IllegalArgumentException|IllegalAccessException e)
		{
			e.printStackTrace();
		}
		panelCentral.add(xcheck);
	}

	@Override
	public String[] getValue()
	{
		return lista;
	}

	@Override
	public int getValueSelected()
	{
		// TODO Auto-generated method stub
		return 0;
	}

}
