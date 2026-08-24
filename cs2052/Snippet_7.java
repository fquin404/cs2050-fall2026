// Snippet 7
// PREDICTED: 1,2,3,4,5,6,7,8,9,10
// ACTUAL:    error
// WHY:       getCount is not nested therefore receives a nullpointer exception

/**
 * 
 */
public class Snippet_7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Counter c = new Counter();
		c.setCount(10);
		System.out.println(c.getCount));
		

	}

	public class Counter {
		private int count = 0;
		public void setCount(int count) {
			count = count;
			
		}
	public int getCount(){
		return count;
		
		
	}
	}
	
	
}
