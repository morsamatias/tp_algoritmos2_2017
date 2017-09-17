package tp_algoritmos2;

import XAnnotation.Control;
import XAnnotation.Form;
import XClass.XForm;
import XObject.TextField;
import XObject.TextPasswordField;

@Form(name="Login", title="Pantalla de Login")
public class Login extends XForm{

	@Control(label="Usuario", type=TextField.class)
	private String user;
	@Control(label="Clave", type=TextPasswordField.class)
	private String password;
}
