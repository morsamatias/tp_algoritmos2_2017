package tp_algoritmos2;

import XAnnotation.*;
import XClass.XForm;
import XObject.*;

@NextButton(label="Login", next="Turnos")
@BackButton(label="Cerrar", name="Cierra")
@Form(name="Login", title="Inicio de sesi�n")
public class Login extends XForm{

//	@Action(label="Test", method="test")
	@Control(label="Usuario", type=TextField.class)
	private String user;
	
	public String getUser()
	{
		return user;
	}

	public void setUser(String user)
	{
		this.user=user;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password=password;
	}

//	@Action(label="Test2", method="test2")
	@Control(label="Password", type=TextPasswordField.class)
	private String password;
	
	public void test()
	{
		System.out.println("Metodo de prueba 1");
	}
	
	public void test2()
	{
		System.out.println("Metodo de prueba 2");
	}
	
	@Override
	public boolean onSubmit()
	{
		if(user.equals("admin") && password.equals("123456"))
		{
			System.out.println("Login correcto");
		}
		else
		{
			System.out.println("Login incorrecto");
			return false;
		}
		return super.onSubmit();
	}
}
