package tp_algoritmos2;

import java.util.Optional;

import XAnnotation.Action;
import XAnnotation.BackButton;
import XAnnotation.Control;
import XAnnotation.Form;
import XClass.XForm;
import XObject.TextField;
import XObject.XObject;

@BackButton(label="Anterior", name="Pantalla1")
@Form(name="Pantalla2", title="Pantalla 2")
public class Pantalla2 extends XForm
{
	String aux = null; 
	
	@Action(label="actualiza", method="actualiza")
	@Control(label="id", type=TextField.class)
	String id;
	
	@Action(label="actualiza2", method="actualiza2")
	@Control(label="nombre", type=TextField.class)
	String nombre;
	@Action(label="actualiza2", method="actualiza2")
	@Control(label="nota", type=TextField.class)
	String nota;
		
	public void actualiza()
	{
		saveFields();
		if (aux == null){
		Alumno alumno = AlumnosDB.buscarAlumno((int)getFrame().getAnObject());
		id = String.valueOf(alumno.getLegajo());
		aux = id;
		nombre = alumno.getNombre();
		nota = String.valueOf(alumno.getNota());
		redraw();
		}else{
			if(aux != id){
			 id = aux;
			 redraw();
			}
		}
		
	}
	
	public void actualiza2()
	{
		saveFields();
		Alumno alumno = AlumnosDB.buscarAlumno((int)getFrame().getAnObject());
		AlumnosDB.modificarAlumno(alumno.getLegajo(), nombre, Integer.parseInt(nota));
	}
		
	@Override
	public boolean onBack()
	{
		System.out.println("Se guardaron los datos");
		return super.onBack();
	}
}
