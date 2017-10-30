package XClass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Optional;

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
	
	ArrayList<XObject> listaAction = new ArrayList<>();
	ArrayList<String> listaFormNombre = new ArrayList<>();
	ArrayList<XObject> listaSubmitButton = new ArrayList<>();
	ArrayList<XObject> listaControl = new ArrayList<>();

	String backForm;
	String nextForm ;
	String formNombre;
	String nombre;
	
	JButton buttonBack = null;
	JButton buttonNext = null;
	
	Application frame = null;
	Request request;
	
	public void onLoad(Request request) {}
	public boolean onSubmit() { return true; }
	public void onBack() {}
	
	public XForm(Application app)
	{
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
		
		NextButton[] anotations3 = clase.getAnnotationsByType(NextButton.class);
		
		for(NextButton anotation:anotations3){
			if((anotation != null) && anotation instanceof NextButton)
			{
				buttonNext = new JButton(anotation.label());
				buttonNext.setActionCommand("siguiente");
				buttonNext.setMnemonic(KeyEvent.VK_D);
				buttonNext.addActionListener(this);
				nextForm = anotation.next();
			}
		}
		
		BackButton[] anotations4 = clase.getAnnotationsByType(BackButton.class);
		
		for(BackButton anotation:anotations4){
			if(anotation != null && anotation instanceof BackButton)
			{
				buttonBack = new JButton(anotation.label());
				buttonBack.setActionCommand("anterior");
				buttonBack.setMnemonic(KeyEvent.VK_L);
				buttonBack.addActionListener(this);
				backForm = anotation.name();
			}
		}

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
					obj.setForm(this);
					listaControl.add(obj);

					Action anotationsAction = variable.getAnnotation(Action.class);
					if(anotationsAction != null && anotationsAction instanceof Action) {
						Method metodo = clase.getMethod(anotationsAction.method());
						obj.setMethodAndXForm(metodo, this);
					}
				}
				catch(InstantiationException|IllegalAccessException|NoSuchMethodException|SecurityException e1)
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
	
	public void redraw()
	{
		getFrame().limpiaForm();
		draw();
	}
	
	public void draw() {

		getFrame().setTitulo(formNombre);
		//Le pido que se dibuje
		for(XObject xobject:listaControl)
		{
			xobject.draw(getFrame().getPanelCentral());
		}
		if(buttonNext != null)
		{
			getFrame().getPanelSur().add(buttonNext);
		}
		if(buttonBack != null)
		{
			getFrame().getPanelSur().add(buttonBack);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		saveFields();
		if ("siguiente".equals(e.getActionCommand())) {
			if(onSubmit())
			{
				getFrame().limpiaForm();
				getFrame().showForm(nextForm);
			}
		}else{
			if("anterior".equals(e.getActionCommand())){
				getFrame().limpiaForm();
				getFrame().showForm(backForm);
			}
		}
	}
		
	private Optional<XObject> getXObject(String nombre)
	{
		return listaControl.stream().filter(o -> o.getNombre() == nombre).findFirst();
	}
	
	private void saveFields()
	{
		Class<? extends XForm> clase = this.getClass();
		Field[] variables = clase.getDeclaredFields();
		for(Field variable:variables)
		{
			Control anotations = variable.getAnnotation(Control.class);
			if(anotations != null && anotations instanceof Control)
			{
				try
				{
					Optional<XObject> xobj = getXObject(anotations.label());
					variable.setAccessible(true);
					variable.set(this, xobj.get().getValue());
				}
				catch(IllegalArgumentException|IllegalAccessException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		// TODO Auto-generated method stub

	}
}
