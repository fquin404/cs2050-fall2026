// Snippet 5
// PREDICTED: prints 5
// ACTUAL:    printed 6
// WHY:       5 + 1 = 6


/**
 * 
 */
public class Snippet_5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [] y = {5};
		bump(y);
		System.out.println(y[0]);
		

	}
public static void bump(int[] arr) {
	arr[0] = arr[0] + 1;
	
}
	
}
