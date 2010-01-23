package org.syrus.animotion.fx.setters;

import org.syrus.animotion.Elemotion;


public class ElemotionSetter extends CoreSetter<Elemotion> {
	public ElemotionSetter() {
		this.addSupportedClass(Elemotion.class);
	}
	public Object get(Elemotion element, Object key) {
		return element.property((Integer)key);
	}
	public void set(Elemotion element, Object key, Object value) {
		element.property((Integer) key, value);
	}
}
