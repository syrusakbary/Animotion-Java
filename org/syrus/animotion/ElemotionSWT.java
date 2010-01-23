package org.syrus.animotion;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.widgets.Composite;

public abstract class ElemotionSWT extends Elemotion implements PaintListener {
	public Composite composite;
	public ElemotionSWT (Composite parent) {
		composite = new Composite(parent, SWT.NONE);
		composite.addPaintListener(this);
	}
	public ElemotionSWT (Composite parent, int style) {
		composite = new Composite(parent, style);
		composite.addPaintListener(this);
	}
	@Override
	abstract public void paintControl(PaintEvent e);
	public void redraw () {
		this.composite.getDisplay().getDefault().asyncExec(new Runnable() {
            public void run() {
            	composite.redraw();
            }
		});
	}
	public Elemotion property (int key, Object value) {
		super.property(key, value);
		this.redraw();
		return this;
	}
}
