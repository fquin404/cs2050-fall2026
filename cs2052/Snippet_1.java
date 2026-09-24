// Snippet 1
// PREDICTED: Syntax error, thought += was invalid
// ACTUAL:    7
// WHY:       It was in fact proper syntax, the total ran to 14 and then was cut by 2.
/**
 * 
 */
public class Snippet_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) { 
		int total = 0;
		for (int i = 1; i<= 5; i++){
			total += i;
			
		}
{
	System.out.println(total/2);
	
}

	}

}
