package org.syrus.animotion.fx.interpolators;

public class IntegerInterpolator extends CoreInterpolator<Integer> {
	public IntegerInterpolator() {
		this.addSupportedClass(Integer.class);
	}
	@Override
	public Integer doStep(Integer start, Integer end, double state) {
		// TODO Auto-generated method stub
		return (int) (start+(end-start)*state);
	}

}
