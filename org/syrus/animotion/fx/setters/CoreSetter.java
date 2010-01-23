package org.syrus.animotion.fx.setters;

import java.util.Vector;

import org.syrus.animotion.AnimotionManagerClass;
import org.syrus.animotion.fx.Setter;

abstract public class CoreSetter<T> implements Setter<T>, AnimotionManagerClass {
	protected T element;
	private Vector<Class> supported = new Vector<Class>();

	final public void addSupportedClass (Class theClass) {
		this.supported.add(theClass);
	}
	final public void removeSupportedClass (Class theClass) {
		this.supported.remove(theClass);
	}
	final public Vector<Class> supportedClasses() {
		return this.supported;
	}
}
