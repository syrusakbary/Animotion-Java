package org.syrus.animotion.easing;

import org.syrus.animotion.Easing;

public class EaseOutQuad implements Easing {

	@Override
	public double getValue (double t, double b, double c, double d) {
		if ((t/=d/2) < 1) return c/2*t*t + b;
		return -c/2 * ((--t)*(t-2) - 1) + b;
	}

}
