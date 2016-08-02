package app;
 
public class FizzBuzz { 
 
 public static void main(String[] args) {
 	String result;
	for (int i=1;i<=100;i++) {
	 result="";
	 if (i%3==0) result+="Fizz"; 
	 if (i%5==0) result+="Buzz";
 	 if (result.isEmpty()) result = ""+i;
	 System.out.println(result);
	}  
 }
 
}
