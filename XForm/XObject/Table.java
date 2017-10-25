package XObject;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class Table extends XObject implements TableModelListener {
	
	
	JTable xtabla;
	String[][] datos;

	@Override
	public void draw(JPanel panelCentral)
	{
		if (xtabla == null) {
			field.setAccessible(true);
			try
			{
				datos = (String[][]) field.get(form);
				String[] primerElemento = datos[0];
				List<String> columnas = new ArrayList<>();
				for(int i=0; i<primerElemento.length; i++)
				{
					columnas.add("Columna" + i);					
				}
				xtabla = new JTable(datos, columnas.toArray());
				xtabla.getModel().addTableModelListener(this);
				xtabla.setVisible(true);
			}
			catch(IllegalArgumentException|IllegalAccessException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		panelCentral.add(xtabla);
	}

	@Override
	public void tableChanged(TableModelEvent e)
	{
		try
		{
			if (metodo != null && form != null) {
				metodo.invoke(form);
			}
		}
		catch(IllegalAccessException|IllegalArgumentException|InvocationTargetException e1)
		{
			e1.printStackTrace();
		}				
		
	}

}
