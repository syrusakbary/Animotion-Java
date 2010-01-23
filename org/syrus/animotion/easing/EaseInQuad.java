package org.syrus.animotion.easing;

import org.syrus.animotion.Easing;

public class EaseInQuad implements Easing {

	@Override
	public double getValue (double t, double b, double c, double d) {
		return c*(t/=d)*t + b;
	}

}
