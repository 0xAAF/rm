 
package app;

import java.util.ArrayList;
 
public class ActionList  extends ArrayList<Action>{
 
	public int indexOf(String act) { 
		for (int i=0; i<this.size();i++) {
			if (get(i).getName().equals(act)) {
				return i;
			}
		}
    return -1;
	}
}
