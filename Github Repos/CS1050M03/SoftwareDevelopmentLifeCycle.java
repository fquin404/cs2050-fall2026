
/*
 *  Name: Francisco Quintero
 *  Class: CS1050 M/W
 *  Description: Guided Exploration 03
 */
import java.util.Scanner;

public class SoftwareDevelopmentLifeCycle
{
	public static void printSummary(String[] args)
	{
		System.out.println("Team and Athlete Analysis \n"
				+ "The trainer enters athlete data until they indicate they are done entering data. The trainer will enter each athlete’s weight and height\n"
				+ "For each athlete entered, the BMI value and category will be displayed based on these BMI ranges.\n"
				+ "Under 18.5: Underweight\n" + "18.5 to under 25: Normal\n" + "25 to under 30: Overweight\n"
				+ "30 or greater: Obese");

	}// end of printSummary

	public static void GetPositiveDouble(String[] args)
	{
		Scanner input = new Scanner(System.in);
		{
			// Get the user's weight.
			System.out.print("Enter your weight, in pounds: ");
			// ADD CODE to input next double for weight
			final double weight = input.nextDouble();
			// Get the user's height.
			System.out.print("Enter your height, in inches: ");
			// ADD CODE input next double for height
			final double height = input.nextDouble();

			BMICalculator(weight, height);
		}

	}// end of GetPositiveDouble

	public static void BMICalculator(double weight, double height)
	{
		Scanner input = new Scanner(System.in);
		{
			final double BMI_US_FACTOR = 730;
			// Calculate the user's body mass index.
			double bmi = weight * BMI_US_FACTOR / (Math.pow(height, 2));
			displayBMI(bmi);
		}
	}

	public static void displayBMI(double bmi)
	{
		// Display the user's BMI.

		System.out.printf("Your body mass index (BMI) is %f", bmi);
		{
			if (bmi <= 18.5)
			{
				System.out.println(", you are Underweight");
			} else
			{
				if (bmi <= 24.9)
				{
					System.out.println(", you are Healthy");
				} else
				{
					if (bmi <= 29.9)
					{
						System.out.println(", you are Overweight");
					} else
					{
						if (bmi >= 30)
							System.out.println(", you are Obese");
					}
				}
			}
		}
	}

	/*
	 * public static boolean AskToContinue() {
	 * 
	 * return true; }
	 */
	public static void main(String[] args)
	{
		printSummary(args);
		GetPositiveDouble(args);
		BMICalculator(0, 0);
		displayBMI(0);
		// AskToContinue();

	}// end of main
}// end of class