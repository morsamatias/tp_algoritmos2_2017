package tp_algoritmos2;

import XAnnotation.Form;
import XApplication.Application;
import XClass.XForm;

@Form(name="Cierra", title="Cierra")
public class Cierra extends XForm
{
	public Cierra(Application app)
	{
		super(app);
		// TODO Auto-generated constructor stub
	}

	public void draw()
	{
		System.exit(0);
	}
}
