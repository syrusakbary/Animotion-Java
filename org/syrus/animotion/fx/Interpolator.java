package org.syrus.animotion.fx;

import org.syrus.animotion.AnimotionManagerClass;

public interface Interpolator<T> extends AnimotionManagerClass {
	public T doStep (T start, T end, double state);
}
