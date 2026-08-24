// Snippet 3
// PREDICTED: Bottom lines conflict
// ACTUAL:    false true
// WHY:       I misread and it seems its displaying whether or not the two strings are equal or in-equal.

/**
 * 
 */
public class Snippet_3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "cs2050";
		String s2 = new String("cs2050");
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
		

	}

}
