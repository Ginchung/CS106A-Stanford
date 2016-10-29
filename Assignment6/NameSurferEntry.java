/*
 * File: NameSurferEntry.java
 * --------------------------
 * This class represents a single entry in the database.  Each
 * NameSurferEntry contains a name and a list giving the popularity
 * of that name for each decade stretching back to 1900.
 */

import acm.util.*;
import java.util.*;

public class NameSurferEntry implements NameSurferConstants {

/* Constructor: NameSurferEntry(line) */
/**
 * Creates a new NameSurferEntry from a data line as it appears
 * in the data file.  Each line begins with the name, which is
 * followed by integers giving the rank of that name for each
 * decade.
 */
	public NameSurferEntry(String line) {
		// You fill this in //
		StringTokenizer tk = new StringTokenizer(line," ");
		int i = 0;
		while(true){
			if(tk.hasMoreTokens()){
				Info[i] += tk.nextToken();
				i++;
			} else
				break;
		}
	}

/* Method: getName() */
/**
 * Returns the name associated with this entry.
 */
	public String getName() {
		// You need to turn this stub into a real implementation //
		if(Info[0].length()!=0){
			return Info[0];
		}
		return null;
	}

/* Method: getRank(decade) */
/**
 * Returns the rank associated with an entry for a particular
 * decade.  The decade value is an integer indicating how many
 * decades have passed since the first year in the database,
 * which is given by the constant START_DECADE.  If a name does
 * not appear in a decade, the rank value is 0.
 */
	public int getRank(int decade) {
		// You need to turn this stub into a real implementation //
		
		/*Decade here should enter in a number such as, 0, 1, 2, ..., 10.
		 * Means that in 1900, 1910, ..., 1990, 2000, respectively. 
		 */
		if(decade>=0 && decade<=10){
			return Integer.parseInt(Info[decade+1]);
		}
		return 0;
	}

/* Method: toString() */
/**
 * Returns a string that makes it easy to see the value of a
 * NameSurferEntry.
 */
	public String toString() {
		// You need to turn this stub into a real implementation //
		String result = "";
		int i;
		for(i=0;i<12;i++){
			if(i == 1) result+="[";
			if(i==11){
				result+=Info[i];
				break;
			} else
				result = result + Info[i] + " ";
		}
		result+="]";
		return result;
	}
	
	private String[] Info = new String[]{"","","","","","","","","","","",""};
}

