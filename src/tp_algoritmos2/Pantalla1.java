package tp_algoritmos2;

import java.util.List;
import java.util.Optional;

import XAnnotation.BackButton;
import XAnnotation.Control;
import XAnnotation.Form;
import XAnnotation.NextButton;
import XClass.XForm;
import XObject.Table;
import XObject.XObject;

@NextButton(label="Siguiente", next="Pantalla2")
@BackButton(label="Actualiza", name="Pantalla2")
@Form(name="Pantalla1", title="Pantalla 1")
public class Pantalla1 extends XForm
{
	@Control(label="alumnos", type=Table.class) 
	public String[][] alumnos = traducirListaAlumnos(AlumnosDB.buscarTodos());

	@Override
	public boolean onSubmit()
	{
		Optional<XObject> tabla = this.getXObject("alumnos");
		if(tabla.get().getValueSelected() <= 0)
		{
			System.out.println("Debe seleccionar un item");
			return false;
		}
		getFrame().setAnObject(tabla.get().getValueSelected());
		return super.onSubmit();
	}
	
	private String[][] traducirListaAlumnos(List<Alumno> alumnos)
	{
		String[][] lista = new String [alumnos.size() + 1][];
		lista[0] = new String[]{"Id", "Nombre", "Nota"};
		int i = 1;
		for (Alumno alum : alumnos) {
		    lista[i]=(traducirAlumno(alum));
		    i+=1;
		}
		
		return lista;
	}
	
	private String[] traducirAlumno(Alumno alumno)
	{
		String[] alumn = {String.valueOf(alumno.getLegajo()), alumno.getNombre(), String.valueOf(alumno.getNota())};
		return alumn;
	}
	
	@Override
	public boolean onBack()
	{
		alumnos = traducirListaAlumnos(AlumnosDB.buscarTodos());
		redraw();
		// TODO Auto-generated method stub
		return false;
	}
}
