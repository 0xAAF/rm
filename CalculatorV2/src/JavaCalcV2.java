package javacalculator;
 
public class JavaCalcV2 {

public static void main(String[] args) {
	//add validators here
	Validator validNumber = new Validator();
	validNumber.add("-*[\\d.?]{1,}");
	//validNumber.add("^-*\\d{1,2}|-*100$"); //value between -100 and 100
	
	//add avaliable actions here
	ActionList actions = new ActionList();
	actions.add(new Action("+") {
		@Override
		public float action(float a, float b) {
			return a + b;
		}
	}); 
	actions.add(new Action("-") {
		@Override
		public float action(float a, float b) {
			return a - b;
		}
  });
	actions.add(new Action("*") {
		@Override
		public float action(float a, float b) {
			return a * b;
		}
  });
	actions.add(new Action("/") {
		@Override
		public float action(float a, float b) {
			return a / b;
		}
  });
	actions.add(new Action("%") {
		@Override
		public float action(float a, float b) {
			return a % b;
		}
  });
	actions.add(new Action("^") {
		@Override
		public float action(float a, float b) {
			return (float) Math.pow(a, b);
		}
  });
	actions.add(new Action("sqr") {
		@Override
		public float action(float a, float b) {
			return (float) Math.pow(a, 1f/b);
		}
  }); 
	actions.add(new Action("per") {
		@Override
		public float action(float a, float b) {
			return 100f/(a/b);
		}
  });
	
	System.out.println("Введите знак действия, первое и второе число. например '+ 2 3'");
	System.out.println("доступные операции: +, -, *, /, ^(степень), % (остаток от деления), sqr (b-корень числа a), per (процент b от а)");
	
	boolean calculated;
	
	Calculator calculator = new Calculator(actions,validNumber,"[ ]+");
	while (true) { //infinity loop 
		System.out.print("> ");
		calculated = calculator.update();
		
		if (calculator.getInput().equals("exit")) System.exit(0); 
		if (calculated) { 
			System.out.println(calculator.getString()+ " = "+calculator.getResult());
		} else {
			System.out.println("Неверный ввод.");
		}
	} 
 }
} 
