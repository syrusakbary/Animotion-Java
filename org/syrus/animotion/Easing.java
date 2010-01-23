package org.syrus.animotion;

public interface Easing {
	// t: current time, b: beginning value, c: Total change in value, d: duration
	public double getValue(double t, double b, double c, double d);
}