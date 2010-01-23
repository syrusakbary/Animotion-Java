package org.syrus.animotion.fx.interpolators;

import java.awt.Color;

public class ColorSwingInterpolator extends CoreInterpolator<Color> {
	public ColorSwingInterpolator() {
		this.addSupportedClass(Color.class);
	}
	@Override
	public Color doStep(Color start, Color end, double state) {
		// TODO Auto-generated method stub
		//return start+(end-start)*state;
		int rS = start.getRed();
		int gS = start.getGreen();
		int bS = start.getBlue();

		int rE = end.getRed();
		int gE = end.getGreen();
		int bE = end.getBlue();
		
		int r = ((Double)(rS+(rE-rS)*state)).intValue();
		int g = ((Double)(gS+(gE-gS)*state)).intValue();
		int b = ((Double)(bS+(bE-bS)*state)).intValue();
		return new Color (r,g,b);
	}

}
