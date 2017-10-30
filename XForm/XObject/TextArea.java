package XObject;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TextArea extends XObject {
	
	JLabel xlabel;
	JTextArea xarea;
	
	@Override
	public void draw(JPanel panelCentral)
	{
		if (xarea == null) {
			xlabel = new JLabel(nombre);
			xarea = new JTextArea(10,30);
//			xarea.addActionListener(this.getActionListener());
		}
		panelCentral.add(xlabel);
		panelCentral.add(xarea);	
	}

	@Override
	public String getValue()
	{
		return xarea.getText();
	}

}
