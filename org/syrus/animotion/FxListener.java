package org.syrus.animotion;

import java.util.EventListener;

public interface FxListener extends EventListener {
	void fxChange (FxEvent e);
	void fxComplete (FxEvent e);
}
