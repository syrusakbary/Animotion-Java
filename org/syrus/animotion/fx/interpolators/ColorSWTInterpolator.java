package org.syrus.animotion.fx.interpolators;

import org.eclipse.swt.graphics.Color;


public class ColorSWTInterpolator extends CoreInterpolator<Color> {
	public ColorSWTInterpolator() {
		this.addSupportedClass(Color.class);
	}
	private int colorRange (int color) {
		return (color>255)?255:(color<0?0:color);
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
		
		r = this.colorRange(r);
		g = this.colorRange(g);
		b = this.colorRange(b);
		return new Color (start.getDevice(),r,g,b);
	}

}
