package tp_algoritmos2;

import XAnnotation.Action;
import XAnnotation.BackButton;
import XAnnotation.Control;
import XAnnotation.Form;
import XAnnotation.NextButton;
import XClass.XForm;
import XObject.TextField;

@BackButton(name="Login")
@NextButton(name="Login")
@Form(name="Login2", title="Pantalla de inicio")
public class Login2 extends XForm{
	
	@Control(label="Usuario", type=TextField.class)
	private String user;
	
}








