package org.syrus.animotion;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;

import org.syrus.animotion.AnimateThread;
import org.syrus.animotion.fx.Setter;

public class AnimateElement implements FxListener {
	protected HashMap<Object, Object> propertiesPrevAnimation;
	protected HashMap<Object, Object> properties;
	protected AnimateThread animation;
	private Setter setter;
	private Object element;
	public AnimateElement (Object element) {
		this.setter = Animotion.getSetter(element);
		this.element = element;
	}
	public AnimateElement animate (HashMap<Object, Object> to, int duration) {
		return this.animate(to, duration, Animotion.Easing.Default);
	}
	public AnimateElement animate (HashMap<Object, Object> to, int duration, Easing ease) {
		if (animation != null) animation.stop();
		animation = new AnimateThread();
		this.propertiesPrevAnimation = new HashMap<Object, Object>();
		Iterator elements = to.keySet().iterator();
		Fx fx;
		while (elements.hasNext()) {
			Object key = elements.next();
			Object value = to.get(key);
			Object init = this.setter.get(this.element, key);
			this.propertiesPrevAnimation.put(key, init);
			//System.out.println(key);
			fx = new Fx<Object>(Animotion.getInterpolator(value));
			fx.key = key;
			fx.addFxListener(this);
			fx.custom(init, value, duration, ease);
			animation.addFx(fx);
		}
		animation.start();
		return this;
	}
	public AnimateElement animateReverse (int duration, Easing ease) {
		return this.animate(this.propertiesPrevAnimation, duration,ease);
	}
	@Override
	public void fxChange(FxEvent e) {
		this.setter.set(this.element,((Fx)e.getSource()).key,((Fx)e.getSource()).now);
	}
	@Override
	public void fxComplete(FxEvent e) {
	}
}
