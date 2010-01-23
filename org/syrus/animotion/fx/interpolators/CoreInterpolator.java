package org.syrus.animotion.fx.interpolators;

import java.util.Vector;

import org.syrus.animotion.fx.Interpolator;

abstract public class CoreInterpolator<T> implements Interpolator<T> {
	private Vector<Class> supported = new Vector<Class>();
	final public void addSupportedClass (Class theClass) {
		this.supported.add(theClass);
	}
	final public void removeSupportedClass (Class theClass) {
		this.supported.remove(theClass);
	}

	@Override
	final public Vector<Class> supportedClasses() {
		return this.supported;
	}

}
