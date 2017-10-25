package tp_algoritmos2;

import XAnnotation.Form;
import XApplication.Application;
import XClass.XForm;

@Form(name="Cierra", title="Cierra")
public class Cierra extends XForm
{
	public void draw(Application app)
	{
		System.exit(0);
	}
}
