package XObject;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TextArea extends XObject {
	
	@Override
	public void draw(JPanel panelCentral)
	{
		JLabel xlabel = new JLabel(nombre);
		JTextArea xtext = new JTextArea();
//		xtext.addActionListener(this.getActionListener());
		xtext.setSize(50, 100);
		xtext.setVisible(true);
		panelCentral.add(xlabel);
		panelCentral.add(xtext);	
		
	}

}
