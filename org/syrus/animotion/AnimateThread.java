package org.syrus.animotion;

import java.util.Iterator;
import java.util.Vector;


public class AnimateThread extends Thread { 
	Vector <Fx> fx = new Vector<Fx>();
	Vector <Fx> completedFx = new Vector<Fx>();
	int fps = 80;
	public AnimateThread () {
	}
	public void setFps (int fps) {
		this.fps = fps;
	}
	public void removeFx (Fx fx) {
		this.fx.remove(fx);
	}
	public void addFx (Fx fx) {
		fx.addFxListener(new FxListener() {
			public void fxChange(FxEvent e) {
				
			}
			public void fxComplete(FxEvent e) {
				AnimateThread.this.completedFx.add((Fx)e.getSource());
				
				//AnimateThread.this.removeFx((Fx)e.getSource());
			}
		});
		this.fx.add(fx);
	}
	public void run () {
		Fx fxs;
		while (true && this.fx.size()>0) {
				Iterator<Fx> it = this.fx.iterator();
				while (it.hasNext()) {
					fxs = it.next();
					fxs.step();
					if (this.completedFx.contains(fxs)) it.remove();
				}
				
				
			try {
				this.sleep(1000/this.fps);
			} catch (InterruptedException e) {
				//e.printStackTrace();
			}
		}
	}
};