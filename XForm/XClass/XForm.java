package XClass;

import java.util.Hashtable;

import org.omg.CORBA.Request;

import XApplication.Application;
import XObject.XObject;

public abstract class XForm {
	Hashtable<String, XObject> components = new Hashtable<>();
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
	public void draw() {
		// TODO foreach componentes, panel.add componente
	}
}
