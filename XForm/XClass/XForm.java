package XClass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.swing.JButton;

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

public abstract class XForm implements ActionListener {
	ArrayList<XObject> components = new ArrayList<>();
	
	ArrayList<XObject> listaAction = new ArrayList<>();
	ArrayList<String> listaFormNombre = new ArrayList<>();
	ArrayList<XObject> listaSubmitButton = new ArrayList<>();
	
	String backForm;
	String nextForm ;
	String formNombre;
	String nombre;
	
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
	public String getNombre() {
		Class<? extends XForm> clase = this.getClass();
		
		String variable = null;

		Form[] anotations2 = clase.getAnnotationsByType(Form.class);
		
		for(Form anotation:anotations2){
			if(anotation != null && anotation instanceof Form)
			{	
				formNombre = anotation.title();
				variable = anotation.name();
			}
		}	
		
		return variable;
	}
	
	public Request getRequest() {
		return request;
	}
	
	public void setRequest(Request request) {
		this.request = request;
	}
	
	// Dado el frame, agrega todos los componentes y los dibuja
	public void draw(Application app) {
		setFrame(app);
		Class<? extends XForm> clase = this.getClass();
		Form[] anotations2 = clase.getAnnotationsByType(Form.class);
		Field[] variables = clase.getDeclaredFields();
		ArrayList<XObject> listaControl = new ArrayList<>();

		for(Form anotation:anotations2){
			
			if(anotation != null && anotation instanceof Form)
			{	
				formNombre = anotation.title();
				nombre = anotation.name();
			}
		
		}
		
		BackButton[] anotations4 = clase.getAnnotationsByType(BackButton.class);
		
		for(BackButton anotation:anotations4){
			if(anotation != null && anotation instanceof BackButton)
			{
				JButton buttonBack = new JButton("Anterior");
				buttonBack.setActionCommand("anterior");
				buttonBack.setMnemonic(KeyEvent.VK_L);
				buttonBack.addActionListener(this);
				app.getPanelSur().add(buttonBack);
				backForm = anotation.name();
			}
		}
		

		NextButton[] anotations3 = clase.getAnnotationsByType(NextButton.class);
		
		for(NextButton anotation:anotations3){
			if((anotation != null) && anotation instanceof NextButton)
			{
				JButton buttonNext = new JButton("Siguiente");
				buttonNext.setActionCommand("siguiente");
				buttonNext.setMnemonic(KeyEvent.VK_D);
				buttonNext.addActionListener(this);
				app.getPanelSur().add(buttonNext);
				nextForm = anotation.name();
			}
		}
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
			
			Action anotationsAction = variable.getAnnotation(Action.class);
			
			if(anotationsAction != null && anotationsAction instanceof Action)
			{
				try
				{
					Method metodo = clase.getMethod(anotationsAction.method());
					metodo.invoke(clase);
				}
				catch(NoSuchMethodException|SecurityException|IllegalAccessException|IllegalArgumentException|InvocationTargetException  e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			SubmitButton anotationsSubmitButton = variable.getAnnotation(SubmitButton.class);
			
			if(anotations != null && anotations instanceof SubmitButton)
			{
				TextField text = new TextField();
				text.setObject(anotationsSubmitButton.label());
				listaSubmitButton.add(text);
			}	
		}

		app.setTitulo(formNombre);
		
		//Le pido que se dibuje		
		for(XObject xobject:listaControl)
		{
			xobject.draw(app.getPanelCentral());
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if ("siguiente".equals(e.getActionCommand())) {
			getFrame().limpiaForm();
			getFrame().showForm(nextForm);
		}else{
			if("anterior".equals(e.getActionCommand())){
				getFrame().limpiaForm();
				getFrame().showForm(backForm);
			}
		}
	}
}
