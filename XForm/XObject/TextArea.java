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
			xarea = new JTextArea();
//			xarea.addActionListener(this.getActionListener());
			xarea.setSize(50, 100);
			xarea.setVisible(true);
		}
		panelCentral.add(xlabel);
		panelCentral.add(xarea);	
		
	}

}
