package tp_algoritmos2;

import XAnnotation.Action;
import XAnnotation.Control;
import XAnnotation.Form;
import XAnnotation.NextButton;
import XClass.XForm;
import XObject.TextField;
import XObject.TextPasswordField;

@NextButton(name="Login2")
@Form(name="Login", title="Pantalla de inicio")
public class Login extends XForm{

	@Action(label="Test", method="test")
	@Control(label="Usuario", type=TextField.class)
	private String user;
	@Action(label="Test2", method="test2")
	@Control(label="Clave", type=TextPasswordField.class)
	private String password;
	
	public void test()
	{
		System.out.println("Metodo de prueba 1");
	}
	
	public void test2()
	{
		System.out.println("Metodo de prueba 2");
	}
}
