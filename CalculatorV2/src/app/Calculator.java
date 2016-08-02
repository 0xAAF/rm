package app;

class Calculator {
	private final Inputer input;
	private final ActionList actions;
	private float result;
	public Calculator (ActionList actions, Validator validator, String delimeter) {
		this.actions=actions;
		this.input=new Inputer(validator,delimeter);
	}
	public boolean update() {
		input.readln();
		int actionNumber = actions.indexOf(input.getAction());
		if (actionNumber>=0) 
			result = actions.get(actionNumber).calculate(input.getValues());
		else return false;
		return true;
	}
	public String getAction() {
		return input.getAction();
	}
	public String getString() {
		return input.getInputPrint();
	}
	public float getResult() {
		return result;
	}
	public String getInput() {
		return input.getInput();
	}
}