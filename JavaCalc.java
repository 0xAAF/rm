package javacalculator;
 
import java.util.Scanner;

public class JavaCalc {

 public static void main(String[] args) { 
  ConsoleCalculator consoleCalculator = new ConsoleCalculator();
	System.out.println("Введите знак действия, первое второе число. например '+ 2 3'");
	System.out.println("доступные операции: +, -, *, /, ^(степень), % (остаток от деления), sqr (b-корень числа a), per (процент b от а)");
	
	while (true) { //infinity loop 
	 System.out.print("> ");
	 consoleCalculator.input();
	 System.out.println("----------------");
	 if (consoleCalculator.isValid())
		System.out.println(consoleCalculator.getInput()+" = "+consoleCalculator.getResult());
	 else 
		System.out.println("Невверный ввод.");
	 System.out.println("----------------");
	}
 }
}
class ConsoleCalculator  {
 //input order (eg. + 1 2 )
 private final int  
	VALUE_ACTION = 0,
	VALUE_A = 1,
	VALUE_B = 2;
 private String input[];
 private String line; 
 private boolean valid;
 private float result; 
 void input() {
	Scanner scanner = new Scanner(System.in);  
	line = scanner.nextLine(); //read input
	if (line.contains("exit")) System.exit(0); //input 'exit' for exit. 

	input = parse(line); 
	valid = validate(input);
	if (valid) {
	 result  = calculate(input);
	} 
 }
 boolean isValid() {
	return valid;
 }
 float getResult() { 
	return result;
 }
 String getInput() {  
	return input[VALUE_A]+" "+input[VALUE_ACTION]+" "+input[VALUE_B];
 }
 private String[] parse(String line) { 
	return line.split("[ ]+");
 }

 private boolean validate(String[] input) {
	boolean valid=true;
	//if spam in input String.matches throws exception OutOfBounds.
	//avoid it with try catch
	try {
	if (!input[VALUE_ACTION].matches("([+-///*%/^]|(sqr)|(per))") 
	||  !input[VALUE_A].matches("-?[\\d.?]*")
	||  !input[VALUE_B].matches("-?[\\d.?]*")) valid=false;
	} catch (Exception e) {valid = false;}
	return valid;
 }

 private float calculate(String[] input) {
	float a,b,result = 0;
	a=Float.valueOf(input[VALUE_A]);
	b=Float.valueOf(input[VALUE_B]);

	if (input[VALUE_ACTION].contains("+")) {result = a + b;}
	else if (input[VALUE_ACTION].contains("-")) {result = a - b;} 
	else if (input[VALUE_ACTION].contains("/")) {result = a / b;} 
	else if (input[VALUE_ACTION].contains("*")) {result = a * b;} 
	else if (input[VALUE_ACTION].contains("%")) {result = a % b;} 
	else if (input[VALUE_ACTION].contains("^")) {result = (float) Math.pow(a, b);} 
	else if (input[VALUE_ACTION].contains("sqr")) {result = (float) Math.pow(a, 1.0/b);} 
	else if (input[VALUE_ACTION].contains("per")) {result = 100/(a/b);} 
	return result;
 }
}
