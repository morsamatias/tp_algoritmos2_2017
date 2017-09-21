package XClass;

import java.lang.reflect.Field;
import java.util.ArrayList;
import org.omg.CORBA.Request;

import XAnnotation.Action;
import XAnnotation.BackButton;
import XAnnotation.Control;
import XAnnotation.Form;
import XAnnotation.NextButton;
import XAnnotation.SubmitButton;
import XApplication.Application;
import XObject.TextField;
import XObject.XObject;

public abstract class XForm {
	ArrayList<XObject> components = new ArrayList<>();
	
	ArrayList<XObject> listaAction = new ArrayList<>();
	ArrayList<XObject> listaControl = new ArrayList<>();
	ArrayList<XObject> listaForm = new ArrayList<>();
	ArrayList<XObject> listaSubmitButton = new ArrayList<>();
	
	BackButton backButton;
	NextButton nextButton ;
	
	
	Application frame = null;
	Request request;
	
	public void onLoad(Request request) {}
	public boolean onSubmit(Request request) { return true; }
	public void onBack() {}
	
	public Application getFrame() {
		return frame;
	}
	public void setFrame(Application frame) {
		this.frame = frame;
	}
	public Request getRequest() {
		return request;
	}
	public void setRequest(Request request) {
		this.request = request;
	}
	
	// Dado el frame, agrega todos los componentes y los dibuja
	public void draw(Application app) {
		Class<? extends XForm> clase = this.getClass();
		Field[] variables = clase.getDeclaredFields();
		for(Field variable:variables)
		{
			
			Control anotations = variable.getAnnotation(Control.class);
			
			if(anotations != null && anotations instanceof Control)
			{
				Class<? extends XObject> xobj = anotations.type();
				try {
					XObject obj = xobj.newInstance();
					obj.setObject(anotations.label());
					listaControl.add(obj);

				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			
			BackButton anotationsBackButtons = variable.getAnnotation(BackButton.class);
			
			if(anotations != null && anotations instanceof BackButton)
			{
				//Class<? extends XObject> xAnot =  anotations.type();
				//Class<? extends XObject> xobj =  new anotations.type();
				TextField text = new TextField();
				text.setObject(anotationsBackButtons.label());
				this.backButton= anotationsBackButtons; 
			}
			
			Action anotationsAction = variable.getAnnotation(Action.class);
			
			if(anotations != null && anotations instanceof Action)
			{
				//Class<? extends XObject> xAnot =  anotations.type();
				//Class<? extends XObject> xobj =  new anotations.type();
				TextField text = new TextField();
				text.setObject(anotationsAction.label());
				listaAction.add(text);
			}
			
			Form anotationsForm = variable.getAnnotation(Form.class);
			
			if(anotations != null && anotations instanceof Form)
			{
				//Class<? extends XObject> xAnot =  anotations.type();
				//Class<? extends XObject> xobj =  new anotations.type();
				TextField text = new TextField();
				text.setObject(anotationsForm.name());
				listaForm.add(text);
			}
			
			NextButton anotationsNextButton = variable.getAnnotation(NextButton.class);
			
			if(anotations != null && anotations instanceof NextButton)
			{
				//Class<? extends XObject> xAnot =  anotations.type();
				//Class<? extends XObject> xobj =  new anotations.type();
				TextField text = new TextField();
				text.setObject(anotationsNextButton.name());
				this.nextButton = anotationsNextButton;
			}
			
			SubmitButton anotationsSubmitButton = variable.getAnnotation(SubmitButton.class);
			
			if(anotations != null && anotations instanceof SubmitButton)
			{
				//Class<? extends XObject> xAnot =  anotations.type();
				//Class<? extends XObject> xobj =  new anotations.type();
				TextField text = new TextField();
				text.setObject(anotationsSubmitButton.label());
				listaSubmitButton.add(text);
			}	
		}
		
		
		
		for(XObject xobject:listaControl)
		{
			xobject.draw(app.getPanelCentral());
		}
		
		
		//Le envio el siguiente y el anterior a la app
//		app.setSiguiente(nextButton);
//		app.setAnterior(backButton);
		
	}
}
