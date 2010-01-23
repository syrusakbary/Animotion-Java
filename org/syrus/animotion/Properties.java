package org.syrus.animotion;

import java.util.HashMap;

public class Properties<K> extends HashMap<K,Object> {
	/*public Object get (K key) {
		return super.get(key);
	}*/
	public void set (K key, Object value) {
		this.put(key, value);
	}
}
