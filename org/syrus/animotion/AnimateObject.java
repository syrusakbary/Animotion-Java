package org.syrus.animotion;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;

import org.syrus.animotion.AnimateThread;
import org.syrus.animotion.fx.Setter;

public class AnimateObject<T> implements FxListener {
	protected T objectPrevAnimation;
	protected AnimateThread animation;
	private T element;
	protected Fx fx;
	public AnimateObject (T element) {
		this.element = element;
		this.fx = new Fx<T>(Animotion.getInterpolator(element));
	}
	public AnimateObject animate (T to, int duration) {
		return this.animate(to, duration, Animotion.Easing.Default);
	}
	public AnimateObject animate (T to, int duration, Easing ease) {
		if (animation != null) animation.stop();
		animation = new AnimateThread();
		this.objectPrevAnimation = this.element;
		fx.addFxListener(this);
		fx.custom(this.element, to, duration, ease);
		animation.addFx(fx);
		animation.start();
		return this;
	}
	public AnimateObject animateReverse (int duration, Easing ease) {
		return this.animate(this.objectPrevAnimation, duration,ease);
	}
	public void addFxListener (FxListener f) {
		this.fx.addFxListener(f);
	}
	public void removeFxListener (FxListener f) {
		this.fx.removeFxListener(f);
	}
	@Override
	public void fxChange(FxEvent e) {
		this.element = (T) ((Fx)e.getSource()).now;
	}
	@Override
	public void fxComplete(FxEvent e) {
	}
}
