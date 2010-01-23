package org.syrus.animotion.fx;


public interface Setter<T> {
	public void set (T element, Object key, Object value);
	public Object get (T element, Object key);
}
