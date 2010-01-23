package org.syrus.animotion;

import java.util.HashMap;
import java.util.Iterator;

public class AnimotionManager<T> {
	private HashMap<Class,T> managers = new HashMap<Class,T>();
	public void addManager (T manager) {
		Iterator iterator = ((AnimotionManagerClass)manager).supportedClasses().iterator();
		while (iterator.hasNext()) {
			this.managers.put((Class)iterator.next(), (T)manager);
		}
	}
	public T getManager (Object object) {
		Iterator<Class> iterator = this.managers.keySet().iterator();
		Class classManager;
		while (iterator.hasNext()) {
			classManager = iterator.next();
			//System.out.println(classx+" is instance "+classManager);
			if (classManager.isInstance(object)) return this.managers.get(classManager);			
		}
		return null;
		
	}
	/*public T getManager (Class classx) {
		return this.managers.get(classx);
	}*/
}
