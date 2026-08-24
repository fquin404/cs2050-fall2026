// Snippet 2
// PREDICTED: 9
// ACTUAL:    exception error, index 4 out of bounds
// WHY:       If I had to guess, the index was too long to be properly displayed at the end, thus an error
/**
 * 
 */
public class Snippet_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = {3,7,2,9};
		for (int i = 0; i <= a.length; i++) {
			System.out.println(a[i]);
			
		}
		

	}

}
