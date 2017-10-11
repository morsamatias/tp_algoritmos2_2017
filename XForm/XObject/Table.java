package XObject;

import javax.swing.JPanel;
import javax.swing.JTable;

public class Table extends XObject {
	
	
	JTable xtabla;

	@Override
	public void draw(JPanel panelCentral)
	{
		if (xtabla == null) {
//			xarea.addActionListener(this.getActionListener());
			xtabla.setSize(50, 100);
			xtabla.setVisible(true);
		}
		panelCentral.add(xtabla);
	}

}
