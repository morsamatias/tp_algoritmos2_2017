package XObject;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;

public interface XInterface {
	
	public void draw(JPanel panelCentral);
	public Object getValue();
	public int getValueSelected();
}
