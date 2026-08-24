// Snippet 4
// PREDICTED: either 5 or undeclared variable
// ACTUAL:    printed 5
// WHY:       x = 5 so it printed 5

/**
 * 
 */
public class Snippet_4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x = 5;
		bump(x);
		System.out.println(x);
		

	}
	public static void bump(int n) {
		n = n + 1;
}}
