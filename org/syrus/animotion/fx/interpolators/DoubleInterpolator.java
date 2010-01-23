package org.syrus.animotion.fx.interpolators;

public class DoubleInterpolator extends CoreInterpolator<Double> {
	public DoubleInterpolator() {
		this.addSupportedClass(Double.class);
	}
	@Override
	public Double doStep(Double start, Double end, double state) {
		// TODO Auto-generated method stub
		return start+(end-start)*state;
	}

}
