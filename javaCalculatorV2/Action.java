package javacalculator;

import java.util.ArrayList;

public abstract class Action {
	private final String name;
	public Action(String name) {
		this.name = name;
	}
	public float calculate(ArrayList<Float> value) { 
		float result = value.get(0);
		for (int i = 1; i<value.size();i++)
			result=action(result,value.get(i));
		return result;
	}
	public String getName() {
		return name;
	}
	abstract public float action(float a, float b);
}