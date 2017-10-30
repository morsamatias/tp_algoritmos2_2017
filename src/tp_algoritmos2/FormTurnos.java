package tp_algoritmos2;

import XAnnotation.*;
import XApplication.Application;
import XClass.XForm;
import XObject.*;

@BackButton(label="Cancelar", name="Cierra")
@NextButton(label="Login", next="Login")
@Form(name="Turnos", title="Pantalla de inicio")
public class FormTurnos extends XForm{
	
	public FormTurnos(Application app)
	{
		super(app);
		// TODO Auto-generated constructor stub
	}

	@Control(label="Nombre", type=TextField.class)
	private String nombre;
	
	@Control(label="Apellido", type=TextField.class)
	private String apellido;
	
	@Control(label="Nro.de afiliado", type=TextField.class)
	private String nroAfiliado;
	
	@Control(label="Tipo de documento", type=ComboBox.class)
	private String[] tipoDocumento = {"Dni", "Pasaporte", "Otros"};
	
	@Control(label="Nro.de documento", type=TextField.class)
	private String nroDoc;

	@Control(label="sexo", type=RadioBox.class)
	private String[] sex = {"Masculino", "Femenino"};
	
	@Control(label="Esposa", type=CheckBox.class)
	private Boolean esposa;

	@Control(label="1 hijo", type=CheckBox.class)
	private Boolean hijo1 ;
	
	@Control(label="2 o mas hijos", type=CheckBox.class)
	private Boolean hijo2 ;
	
	@Action(label="Test3", method="test3")
	@Control(label="Especialidad", type=ComboBox.class)
	private String[] especialidad = {"Seleccionar especialidad","Especialista1","Especialista2"};
	
	@Control(label="Turnos disponibles", type=Table.class) 
	public String[][] turnos = {{"Especialidad","Fecha"}};

	@Control(label="Consideraciones", type=TextArea.class)
	public String consideraciones;
	
	public void test3()
	{
		System.out.println("Metodo de prueba 3");
		turnos = new String[][]{{"Especialidad1", "Fecha1"}, {"Especialidad2", "Fecha2"}};
		redraw();
	}

}
