package XClass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
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
	ArrayList<XObject> listaControl = new ArrayList<>();

	String backForm;
	String nextForm ;
	String formNombre;
	String nombre;
	
	Application frame = null;
	Request request;
	Boolean alreadyDraw = false;
	
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

		if (!alreadyDraw) {
			for(Field variable:variables)
			{
				
				Control anotations = variable.getAnnotation(Control.class);
				
				if(anotations != null && anotations instanceof Control)
				{
					Class<? extends XObject> xclass = anotations.type();
					try
					{
						XObject obj = xclass.newInstance();
						obj.setName(anotations.label());
						obj.setField(variable);
						XForm form = clase.newInstance();
						obj.setForm(form);
						listaControl.add(obj);

						Action anotationsAction = variable.getAnnotation(Action.class);
						if(anotationsAction != null && anotationsAction instanceof Action) {
							try
							{
								Method metodo = clase.getMethod(anotationsAction.method());
								obj.setMethodAndXForm(metodo,form);
							}
							catch(NoSuchMethodException|SecurityException e)
							{
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}
					}
					catch(InstantiationException|IllegalAccessException e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				SubmitButton anotationsSubmitButton = variable.getAnnotation(SubmitButton.class);
				
				if(anotations != null && anotations instanceof SubmitButton)
				{
					TextField text = new TextField();
					text.setName(anotationsSubmitButton.label());
					listaSubmitButton.add(text);
				}	
			}
		}

		app.setTitulo(formNombre);
		
		//Le pido que se dibuje		
		for(XObject xobject:listaControl)
		{
			xobject.draw(app.getPanelCentral());
		}
		alreadyDraw = true;
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
