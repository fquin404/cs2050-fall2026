/**
 * 
 */

/**
 * 
 */
public class Dog {

	/**
	 * @param args
	 */
	private String Name;
	private float weight;
	private String bark;
	
	public Dog(String Name_param, float weight_param, String bark_param) {
		Name = Name_param;
		weight = weight_param;
		bark = bark_param;
		
		
	}
	
	public void setWeight(float weight) {
		
		if (Math.abs(weight).weight - weight <=5)
		this.weight = weight;
		else {
			System.out.println("Weight change is too big! Keep under 5lbs");
		}
		public void setBark(String bark) {
			
			this.bark = bark;
			
		}
			
	}
	
	public String getName() {
		
		return Name;
		
	}
		public float getWeight() {
			
			return weight;
		}
		public void getBark() {
			return bark;
			
		}
		public void Bark()
	{
		System.out.println(this.bark);	
			
			
	}}
