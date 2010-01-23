package org.syrus.animotion;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;

import org.syrus.animotion.fx.Interpolator;

public class Fx<T> {
	public T start;
	public T end;
	private float state;
	private Interpolator interpolator;
	private long startTime;
	public T now;
	public T previous;
	private float pos;
	public int duration;
	private Easing ease;
	public Object key;
	private ArrayList<FxListener> fxListeners = new ArrayList<FxListener>();
	public Fx (Interpolator interpolator) {
		this.interpolator = interpolator;
	}
	public long now () {
		return System.currentTimeMillis();
	}
	public void custom (T from, T to, int duration, Easing ease) {
		this.startTime = this.now();
		this.start= from;
		this.now = from;
		this.end = to;
		this.duration = duration;
		this.ease = ease;
	}
	public void addFxListener (FxListener f) {
		this.fxListeners.add(f);
	}
	public void removeFxListener (FxListener f) {
		this.fxListeners.remove(f);
	}
	public void update () {
		if (!this.now.equals(this.previous)) this.fireFxChangeEvent(new FxEvent(this));
	}
	private void fireFxChangeEvent (FxEvent e) {
		for (FxListener f: this.fxListeners) {
			f.fxChange(e);
		}
	}
	private void fireFxCompleteEvent (FxEvent e) {
		for (FxListener f: this.fxListeners) {
			f.fxComplete(e);
		}
	}
	public void step () {
		this.step(false);
	}
	public void step (boolean goToEnd) {
		this.previous = this.now;
		long t = this.now();
		if (goToEnd || t >= this.duration+this.startTime) {
			this.now = this.end;
			this.state = 1;
			this.update();
			this.fireFxCompleteEvent(new FxEvent(this));
		}
		else {
			int n = (int) (t - this.startTime);
			this.state = n/this.duration;
			this.pos = (float) this.ease.getValue(n, 0, 1, this.duration);
			this.now = (T) this.interpolator.doStep(this.start, this.end, this.pos);;
			this.update();
		}
	}
}
