package tp_algoritmos2;

import XAnnotation.Action;
import XAnnotation.BackButton;
import XAnnotation.Control;
import XAnnotation.Form;
import XClass.XForm;
import XObject.TextField;

@BackButton(label="Anterior", name="Pantalla1")
@Form(name="Pantalla2", title="Pantalla 2")
public class Pantalla2 extends XForm
{
	String aux = null; 
	
	@Action(label="verificaid", method="verificaid")
	@Control(label="id", type=TextField.class)
	String id;
	
	@Control(label="nombre", type=TextField.class)
	String nombre;
	
	@Control(label="nota", type=TextField.class)
	String nota;
	
	private int getAlumnoId()
	{
		return Integer.valueOf((String)((String[]) getFrame().getAnObject())[0]);
	}
	
	public void verificaid()
	{
		saveFields();
		id = String.valueOf(getAlumnoId());
		redraw();
	}
	
	@Override
	public void onLoad()
	{
		Alumno alumno = AlumnosDB.buscarAlumno(getAlumnoId());
		id = String.valueOf(alumno.getLegajo());
		nombre = alumno.getNombre();
		nota = String.valueOf(alumno.getNota());
	}
	
	@Override
	public boolean onBack()
	{
		saveFields();
		Alumno alumno = AlumnosDB.buscarAlumno(getAlumnoId());
		AlumnosDB.modificarAlumno(alumno.getLegajo(), nombre, Integer.parseInt(nota));
		System.out.println("Se guardaron los datos");
		return super.onBack();
	}
}
