package org.syrus.animotion.fx.setters;

import java.util.Vector;

import org.eclipse.swt.widgets.Control;
import org.syrus.animotion.fx.Setter;

public class SWTSetter extends CoreSetter<Control> {
	public SWTSetter(Control control) {
		this.addSupportedClass(Control.class);
	}
	public Object get(Control control, Object key) {
		return null;
	}
	public void set(Control control, Object key, Object value) {		
	}
}
