package XObject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import XClass.XForm;

public abstract class XObject implements XInterface {
	Method metodo;
	XForm form;
	public void setMethodAndXForm(Method metodo, XForm form)
	{
		this.metodo = metodo;
		this.form = form;
	}
	public ActionListener getActionListener()
	{
		return new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					metodo.invoke(form);
				}
				catch(IllegalAccessException|IllegalArgumentException|InvocationTargetException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
			}
		};
	}
}
