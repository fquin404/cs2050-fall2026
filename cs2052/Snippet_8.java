// Snippet 8
// PREDICTED: 176, 184, 158
// ACTUAL:    error
// WHY:       doubled is not able to be pulled, the compiler receives an error
/**
 * 
 */
public class Snippet_8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] scores = {88, 92, 79};
		for (int i = 0; i < scores.length; i++) {
			int doubled = scores[i] * 2;
			
		}
System.out.println(doubled);

	}

}
