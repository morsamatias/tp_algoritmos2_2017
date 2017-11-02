package tp_algoritmos2;

import XAnnotation.*;
import XClass.XForm;
import XObject.*;

@NextButton(label="Inicio", next="Siguiente")
@BackButton(label="Cerrar", name="Cierra")
@Form(name="Inicio", title="Pantalla de Inicio")
public class Inicio extends XForm{

	@Action(label="Test", method="test")
	@Control(label="Usuario", type=TextField.class)
	private String user;
	
	public String getUser()
	{
		return user;
	}
	@Action(label="Alumno",method="Alumno")
	@Control(label="Alumnos", type=Table.class) 
	public String[][] turnos = {{"Especialidad","Fecha"}};

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

	@Action(label="Test2", method="test2")
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
