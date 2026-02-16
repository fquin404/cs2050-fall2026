
/**
 * Calculate the BMI using formula in US units. 
 * User will enter weight in pounds and height in inches
 */
import java.util.Scanner;
// ADD CODE to import Scanner class

public class BodyMassIndexActivity
{

	public static void main(String[] args)
	{
		// Create constant and variables
		// constants
		// factor formula in pounds
		// Variables
		// The user's weight
		// The user's height
		// The user's BMI

		try (// Create a Scanner object for scanning input from keyboard
				Scanner input = new Scanner(System.in))
		{
			// Tell the user what the program will do.
			System.out.println("This program will calculate your " + "body mass index, or BMI.");

			// Get the user's weight.
			System.out.print("Enter your weight, in pounds: ");
			// ADD CODE to input next double for weight
			final double weight = input.nextDouble();
			// Get the user's height.
			System.out.print("Enter your height, in inches: ");
			// ADD CODE input next double for height
			final double height = input.nextDouble();
			// ADD code for BMI factor
			final double BMI_US_FACTOR = 730;
			// Calculate the user's body mass index.
			double bmi = weight * BMI_US_FACTOR / (Math.pow(height, 2));

			// Display the user's BMI.
			System.out.printf("Your body mass index (BMI) is %f", bmi);
			{
				if (bmi >= 18.5)
				{
					System.out.println(" ,you are Underweight");
				} else
				{
					if (bmi >= 24.9)
					{
						System.out.println(" ,you are Healthy");
					} else
					{
						if (bmi >= 29.9)
						{
							System.out.println(" ,you are Overweight");
						} else
						{
							if (bmi >= 30)
								System.out.println(" ,you are Obese");
						}
					}
				}
			}
		}
	}// end of main
}// end of class