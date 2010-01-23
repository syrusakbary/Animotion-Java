package org.syrus.animotion;

import java.util.HashMap;
import java.util.Vector;

import org.syrus.animotion.fx.Setter;

public class Elemotion {
	protected AnimateElement animation = new AnimateElement(this);

	protected Properties properties = new Properties();
	public Elemotion property (int key, Object value) {
		//System.out.println("key: "+key+", value: "+value);
		this.properties.set(key,value);
		return this;
	}
	public Object property (int key) {
		return this.properties.get(key);
	}
	public Elemotion animate (Properties to, int duration, Easing ease) {
		//this.animation.animate(to,duration,ease);
		this.animation.animate(to, duration, ease);
		return this;
	}
}
