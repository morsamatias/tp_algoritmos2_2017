package XAnnotation;

import XObject.XObject;

public @interface Control {
	String label();
	Class<? extends XObject> type();
}
