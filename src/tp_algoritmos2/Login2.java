package tp_algoritmos2;

import XAnnotation.*;
import XClass.XForm;
import XObject.*;

@BackButton(label="Cancelar", name="Cierra")
@NextButton(label="Login", next="Login")
@Form(name="Login2", title="Pantalla de inicio")
public class Login2 extends XForm{
	
	@Control(label="Usuario", type=TextField.class)
	private String user;
	
	@Action(label="Test3", method="test3")
	@Control(label="Hombre?", type=CheckBox.class)
	private String hombre;
	
	@Control(label="Color", type=RadioBox.class)
	private String[] color = {"Rojo", "Amarillo"};

	@Control(label="Dificultad", type=ComboBox.class)
	private String[] dificultad = {"Facil", "Medio", "Dificil"};
	
	@Action(label="Test3", method="test3")
	@Control(label="Tabla", type=Table.class)
	private String[][] tabla = {{"Fila 11", "Fila 12", "Fila 13"}, {"Fila 21", "Fila 22", "Fila 23"}, {"Fila 31", "Fila 32", "Fila 33"}};
	
	public void test3()
	{
		System.out.println("Metodo de prueba 3");
	}

}
