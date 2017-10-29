package XAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import XObject.XObject;

@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.FIELD)
public @interface Control {
	String label();
	Class<? extends XObject> type();
}
