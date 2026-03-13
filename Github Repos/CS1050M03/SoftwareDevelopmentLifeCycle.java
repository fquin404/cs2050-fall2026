/*
 *  Name: Francisco Quintero
 *  Class: CS1050 M/W
 *  Description: Guided Exploration 03
 */

import java.util.Scanner;

public class SoftwareDevelopmentLifeCycle
{

	public static void printSummary()
	{
		System.out.println("Team and Athlete Analysis \n"
				+ "The trainer enters athlete data until they indicate they are done entering data. The trainer will enter each athlete’s weight and height\n"
				+ "For each athlete entered, the BMI value and category will be displayed based on these BMI ranges.\n"
				+ "Under 18.5: Underweight\n" + "18.5 to under 25: Normal\n" + "25 to under 30: Overweight\n"
				+ "30 or greater: Obese");
	}

	public static void GetPositiveDouble(Scanner input)
	{
		double weight;
		double height;

		do
		{
			System.out.print("Enter athlete weight in pounds: ");
			weight = input.nextDouble();

			if (weight <= 0)
			{
				System.out.println("Error 404: weight must be greater than 0.");
			}

		} while (weight <= 0);

		do
		{
			System.out.print("Enter athlete height in inches: ");
			height = input.nextDouble();

			if (height <= 0)
			{
				System.out.println("Error 303: height must be greater than 0.");
			}

		} while (height <= 0);

		BMICalculator(weight, height);
	}

	public static void BMICalculator(double weight, double height)
	{
		final double BMI_US_FACTOR = 703;

		double bmi = weight * BMI_US_FACTOR / (Math.pow(height, 2));

		displayBMI(bmi);
	}

	public static void displayBMI(double bmi)
	{
		System.out.printf("Your body mass index (BMI) is %.1f", bmi);

		if (bmi < 18.5)
		{
			System.out.println(", Needs Review (Underweight)");
		} else if (bmi < 25)
		{
			System.out.println(", Normal");
		} else if (bmi < 30)
		{
			System.out.println(", Overweight");
		} else
		{
			System.out.println(", Obese");
		}
	}

	public static boolean AskToContinue(Scanner input)
	{
		char response;

		while (true)
		{
			System.out.print("Enter another athlete? (y/n): ");
			response = input.next().charAt(0);

			if (response == 'y' || response == 'Y')
			{
				return true;
			} else if (response == 'n' || response == 'N')
			{
				return false;
			} else
			{
				System.out.println("Invalid entry. Please enter y or n.");
			}
		}
	}

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		int athleteCount = 0;
		boolean continueEntry;

		printSummary();

		do
		{
			GetPositiveDouble(input);
			athleteCount++;

			continueEntry = AskToContinue(input);

		} while (continueEntry);

		System.out.println(athleteCount + " athlete calculations were completed.");

		input.close();
	}
}