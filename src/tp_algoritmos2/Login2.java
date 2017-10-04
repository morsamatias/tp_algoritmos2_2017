package tp_algoritmos2;

import XAnnotation.BackButton;
import XAnnotation.Control;
import XAnnotation.Form;
import XClass.XForm;
import XObject.TextField;

@BackButton(name="Login")
@Form(name="Login2", title="Pantalla de inicio")
public class Login2 extends XForm{

	@Control(label="Usuario", type=TextField.class)
	private String user;
	
}
