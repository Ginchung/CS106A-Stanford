import java.util.*;


public class ExpandableArray {
	
/**	The constructor of the expandable array. 
 *  
 */
	public ExpandableArray() {
		
	}

/** Set the element of a given index in the special array. 
 *  If the internal array is not enough for storing the 
 *  new value, then this implementation expands the array, 
 *  in this certain HashMap, creates new key-value() set 
 *  for it. 
 *  
 *  And I set the index started at 0; 
 */	
	public void set(int index, Object value){
		if(index/10 <= hsmp.size()) {
			Object[] objects = new Object[10];
			hsmp.put(index/10, objects);
		}
/*		for(int i = 0;i<10;i++) {
			(hsmp.get(index/10))[i] = null;
		}*/
		(hsmp.get(index/10))[index%10] = value;
	}
	
/**	Returns the object of the index. However, if the index 
 *  is out-of-bound, return a null value, instead of an 
 *  error exception. 
 */ 
	public Object get(int index) {
		Object object = hsmp.get(index/10)[index%10];
		if(index/10 <= hsmp.size() || object!=null){
			return null;
		}
		return object;
	}
	
	private HashMap<Integer,Object[]> hsmp = new HashMap<Integer,Object[]>();
	
}
