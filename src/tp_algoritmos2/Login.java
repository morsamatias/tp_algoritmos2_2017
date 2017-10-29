package tp_algoritmos2;

import XAnnotation.*;
import XClass.XForm;
import XObject.*;

@NextButton(label="Login", next="Login2")
@BackButton(label="Cerrar", name="Cierra")
@Form(name="Login", title="Inicio de sesión")
public class Login extends XForm{

	
	@Action(label="Test", method="test")
	@Control(label="Usuario", type=TextField.class)
	private String user;
	
	@Action(label="Test2", method="test2")
	@Control(label="Password", type=TextPasswordField.class)
	private String password;
	
		
	public void test()
	{	
		System.out.println("Metodo de prueba 1");
	}
	
	public void test2()
	{	System.out.println("Metodo de prueba 2");
	}
}
