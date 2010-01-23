package org.syrus.animotion.easing;

import org.syrus.animotion.Easing;

public class EaseInElastic implements Easing {
	double p = 0;
	@Override
	public double getValue (double t, double b, double c, double d) {
		float s=1.70158f;
		if (p == 0) p = d*.3;
		double a = c;
		if (t==0) return b;  if ((t/=d)==1) return b+c; 
		if (a < Math.abs(c)) { a=c; s=(float) (p/4); }
		else s = (float) (p/(2*Math.PI) * Math.asin (c/a));
		return (double)-(a*Math.pow(2,10*(t-=1)) * Math.sin( (t*d-s)*(2*Math.PI)/p )) + b;
	}

}
