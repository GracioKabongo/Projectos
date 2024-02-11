package teste0;
import java.util.*;
class ObjectoVector {
	public static void main (String [] args){
		Vector v = new Vector ();
		Float f = new Float (32.0f);
		v.addElement (f);
		Integer i = new Integer (12);
		v.addElement (i);
		Float f1 = (Float) v.elementAt (0);
		Integer i1 = (Integer) v.elementAt (1);
		System.out.println ("v [0] = "+ f1.toString ());
		System.out.println ("v [1] = "+ i.toString ());
	}
}

