package org.syrus.animotion;

import java.awt.Color;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Timer;
import java.util.Vector;

import org.syrus.animotion.easing.*;
import org.syrus.animotion.fx.*;
import org.syrus.animotion.fx.interpolators.*;

public class Animotion {
	protected static AnimotionManager<Interpolator> interpolatorManager = new AnimotionManager<Interpolator>();
	protected static AnimotionManager<Setter> setterManager = new AnimotionManager<Setter>();
	public static class Property {
		public static int WIDTH = 1001;
		public static int HEIGHT = 1002;
		public static int OPACITY = 1002;
	}
	public static class Easing {
		public static org.syrus.animotion.Easing EaseInQuad = new EaseInQuad();
		public static org.syrus.animotion.Easing EaseOutQuad = new EaseOutQuad();
		public static org.syrus.animotion.Easing LinearTween = new LinearTween();
		public static org.syrus.animotion.Easing Default = new LinearTween();
		public static org.syrus.animotion.Easing EaseInElastic = new EaseInElastic();
	}
	public static void addInterpolator (Interpolator interpolator) {
		Animotion.interpolatorManager.addManager(interpolator);
	}
	public static Interpolator getInterpolator (Object object) {
		return Animotion.interpolatorManager.getManager(object);
	}
	public static void addSetter (Setter setter) {
		Animotion.setterManager.addManager(setter);
	}
	public static Setter getSetter (Object object) {
		return Animotion.setterManager.getManager(object);
	}
	public Animotion (Object object) {
		//
		
		//System.out.println(new Vector(Arrays.asList(object)));
		//this.manager = manager;
	}
	public static AnimateElement animate (Object what, HashMap<Object, Object> to, int duration, org.syrus.animotion.Easing ease) {

		AnimateElement animate = new AnimateElement(what);
		animate.animate(to,duration,ease);
		return animate;
	}
	public static AnimateObject animate (Object what, Object to, int duration, org.syrus.animotion.Easing ease) {

		AnimateObject animate = new AnimateObject(what);
		animate.animate(to,duration,ease);
		return animate;
	}
}
