package tp_algoritmos2;

import XAnnotation.*;
import XClass.XForm;
import XObject.*;

@BackButton(label="Cancelar", name="Cierra")
@NextButton(label="Login", next="Login")
@Form(name="Login2", title="Pantalla de inicio")
public class Login2 extends XForm{
	
	@Control(label="Nombre", type=TextField.class)
	private String nombre;
	
	@Control(label="Apellido", type=TextField.class)
	private String apellido;
	
	@Control(label="Nro.de afiliado", type=TextField.class)
	private String nroAfiliado;
	
	@Control(label="Tipo de documento", type=ComboBox.class)
	private String[] tipoDocumento = {"Dni", "Otros"};
	
	@Control(label="Nro.de documento", type=TextField.class)
	private String nroDoc;

	@Control(label="sexo", type=RadioBox.class)
	private String[] sex = {"Masculino", "Femenino"};
	
	@Control(label="Esposa", type=CheckBox.class)
	private String esposa;

	@Control(label="1 hijo", type=CheckBox.class)
	private String hijo1 ;
	
	@Control(label="2 o mas hijos", type=CheckBox.class)
	private String[] hijo2 ;
	
	@Action(label="Test3", method="test3")
	@Control(label="Especialidad", type=ComboBox.class)
	private String[] tabla = {"Seleccionar especialidad","Especialista1","Especialista2"};
	
	@Control(label="Turnos disponibles", type=Table.class) 
	public String[][] tabla2 = {{"Turno1","Fecha1","Consideracion1"},{"Turno2","Fecha2","Consideracion2"}};

	public void test3()
	{
		System.out.println("Metodo de prueba 3");
		//No anda esta annotation
	}

}
