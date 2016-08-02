package app;
 
import java.util.ArrayList;

public class Validator extends ArrayList<String>{
 
 public boolean isValid(String text) { 
	 for (String match:this)
		 if (!text.matches(match)) return false;
	 return true;
 }
}
