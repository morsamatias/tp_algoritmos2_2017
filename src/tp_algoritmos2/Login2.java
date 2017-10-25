package tp_algoritmos2;

import XAnnotation.Action;
import XAnnotation.BackButton;
import XAnnotation.Control;
import XAnnotation.Form;
import XAnnotation.NextButton;
import XClass.XForm;
import XObject.CheckBox;
import XObject.RadioBox;
import XObject.Table;
import XObject.TextField;

@BackButton(name="Login")
@NextButton(name="Login")
@Form(name="Login2", title="Pantalla de inicio")
public class Login2 extends XForm{
	
	@Control(label="Usuario", type=TextField.class)
	private String user;
	
	@Action(label="Test3", method="test3")
	@Control(label="Hombre?", type=CheckBox.class)
	private String hombre;
	
	@Control(label="Color", type=RadioBox.class)
	private String[] color = {"Rojo", "Amarillo"};

	@Action(label="Test3", method="test3")
	@Control(label="Tabla", type=Table.class)
	private String[][] tabla = {{"Fila 11", "Fila 12", "Fila 13"}, {"Fila 21", "Fila 22", "Fila 23"}, {"Fila 31", "Fila 32", "Fila 33"}};
	
	public void test3()
	{
		System.out.println("Metodo de prueba 3");
	}

}
