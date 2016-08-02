package javacalculator;
 
import java.util.ArrayList;
import java.util.Scanner;

public class Inputer {
	final private ArrayList<Float> values;
	final private String delimeter;
	final private Validator validator;
	private String action, line, lineForPrint;
	public Inputer(Validator validator, String delimeter) {
		this.validator=validator;
		this.delimeter=delimeter;
		values = new ArrayList();
	}
	public String readln() {
		Scanner scanner = new Scanner(System.in);
		line = scanner.nextLine();
		reset();
		parse(line);
		return line;
	} 
	private void parse(String line) {
	
		line = line.trim(); //remove whitespace on both side
		String[] str = line.split(delimeter);
		if (str.length<3) return;
		this.action = str[0]; 
		lineForPrint = str[1];
		for (int i=1;i<str.length;i++)
			if (validator.isValid(str[i]) && !str[i].equals(".")) {
				values.add(Float.valueOf(str[i]));
				if (i>1)lineForPrint +=" "+ action + " " + str[i];
			} else { 
				//if we input " + 5 6 * 4" do reset and make error ( action not contains in Actions )
				reset();
			} 
	}
	public void reset() {
		values.clear();
		action = "";
	}
	public String getAction() {
		return action;
	}
	public ArrayList<Float> getValues() {
		return values;
	}
	public String getInputPrint() { 
		return lineForPrint;
	}
	public String getInput() { 
		return line;
	}
}
