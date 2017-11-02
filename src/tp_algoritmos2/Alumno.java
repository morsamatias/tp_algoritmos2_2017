package tp_algoritmos2;

public class Alumno
{
	private int legajo;
	private String nombre;
	private int nota;
	
	public Alumno(int le,String no, int not)
	{
		legajo=le;
		nombre=no;
		nota=not;
	}
	
	public int getLegajo()
	{
		return legajo;
	}
	public void setLegajo(int legajo)
	{
		this.legajo=legajo;
	}
	public String getNombre()
	{
		return nombre;
	}
	public void setNombre(String nombre)
	{
		this.nombre=nombre;
	}
	public int getNota()
	{
		return nota;
	}
	public void setNota(int nota)
	{
		this.nota=nota;
	}
}
