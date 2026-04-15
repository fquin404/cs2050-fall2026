import java.util.Scanner;

public class TrainingApp
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		displayOverview();

		int numAthletes = getValidNumber(input);

		String[] names = new String[numAthletes];
		double[] bmis = new double[numAthletes];
		double[] heartRates = new double[numAthletes];

		enterAthleteData(names, bmis, heartRates, input);

		displaySummary(names, bmis, heartRates);

		bmiAnalysis(names, bmis);

		mhrAnalysis(names, heartRates);

		trainingHeartRate(names, heartRates, input);

		System.out.println("\n**************************************");
		System.out.println("Training Program Analysis Complete");
		System.out.println("**************************************");

		input.close();
	}

	// display overview
	public static void displayOverview()
	{
		System.out.println("**************************************");
		System.out.println("Program Overview");
		System.out.println("**************************************");
		System.out.println("The trainer enters how many athletes are on the team.");
		System.out.println("Then the trainer enters each athlete's weight, height and age.");
		System.out.println("For each athlete, the program calculates BMI and Max Heart Rate.");
		System.out.println("BMI Categories");
		System.out.println("Under 18.5: Underweight");
		System.out.println("18.5 to under 30: Normal");
		System.out.println("30 or greater: High");
		System.out.println("Calculates percentage of max heart rate for athlete training goal if needed\n");
	}

	// number validation
	public static int getValidNumber(Scanner input)
	{
		int num = 0;

		while (num <= 0)
		{
			System.out.print("Enter the number of athletes on the team: ");
			num = input.nextInt();

			if (num <= 0)
			{
				System.out.println("Error: value must be greater than 0.");
			}
		}

		return num;
	}

	public static void enterAthleteData(String[] names, double[] bmis, double[] heartRates, Scanner input)
	{
		for (int i = 0; i < names.length; i++)
		{
			System.out.println("\nEnter data for athlete " + (i + 1));

			input.nextLine();

			// getting name
			String name = "";
			while (name.equals("") || name.contains(" "))
			{
				System.out.print("Enter athlete's first name: ");
				name = input.nextLine();

				if (name.equals("") || name.contains(" "))
				{
					System.out.println("Error: name must be one word.");
				}
			}

			names[i] = name;

			// getting weight
			double weight = 0;
			while (weight <= 0)
			{
				System.out.print("Enter weight in pounds: ");
				weight = input.nextDouble();

				if (weight <= 0)
				{
					System.out.println("Error: value must be greater than 0.");
				}
			}

			// getting height
			double height = 0;
			while (height <= 0)
			{
				System.out.print("Enter height in inches: ");
				height = input.nextDouble();

				if (height <= 0)
				{
					System.out.println("Error: value must be greater than 0.");
				}
			}

			// getting age
			int age = 0;
			while (age <= 0)
			{
				System.out.print("Enter age in years: ");
				age = input.nextInt();

				if (age <= 0)
				{
					System.out.println("Error: value must be greater than 0.");
				}
			}

			// performing calculations
			bmis[i] = (703 * weight) / (height * height);
			heartRates[i] = 220 - age;
		}
	}

	// displaying the summary
	public static void displaySummary(String[] names, double[] bmis, double[] heartRates)
	{
		System.out.println("\n========== Athlete Summary ==========");

		for (int i = 0; i < names.length; i++)
		{
			System.out.println(names[i]);
			System.out.printf("BMI: %.1f\n", bmis[i]);

			if (bmis[i] < 18.5)
			{
				System.out.println("Category: Underweight");
			} else if (bmis[i] < 30)
			{
				System.out.println("Category: Normal");
			} else
			{
				System.out.println("Category: High");
			}

			System.out.println("MHR: " + (int) heartRates[i] + "\n");
		}
	}

	// analyzing BMI
	public static void bmiAnalysis(String[] names, double[] bmis)
	{
		System.out.println("========== BMI Analysis ==========");

		boolean found = false;

		for (int i = 0; i < names.length; i++)
		{
			if (bmis[i] < 18.5)
			{
				System.out.println("Below normal: " + names[i]);
				found = true;
			} else if (bmis[i] >= 30)
			{
				System.out.println("Above normal: " + names[i]);
				found = true;
			}
		}

		if (!found)
		{
			System.out.println("No athletes outside of normal range");
		}
	}

	// analyzing maximum heart rates
	public static void mhrAnalysis(String[] names, double[] heartRates)
	{
		System.out.println("\n========== MHR Analysis ==========");

		double total = 0;
		int highestIndex = 0;

		for (int i = 0; i < names.length; i++)
		{
			total += heartRates[i];

			if (heartRates[i] > heartRates[highestIndex])
			{
				highestIndex = i;
			}
		}

		double avg = total / names.length;

		System.out.printf("Team Average Max Heart Rates: %.1f\n", avg);

		System.out
				.println("\n" + names[highestIndex] + " has highest max heart rate: " + (int) heartRates[highestIndex]);

		System.out.println("\nAthletes above or equal to average MHR:");

		for (int i = 0; i < names.length; i++)
		{
			if (heartRates[i] >= avg)
			{
				System.out.println(names[i]);
			}
		}
	}

	// training heart rates method
	public static void trainingHeartRate(String[] names, double[] heartRates, Scanner input)
	{
		char choice = ' ';

		while (!(choice == 'y' || choice == 'Y' || choice == 'n' || choice == 'N'))
		{
			System.out.print("\nDo you want to calculate the training heart rates? (y/n): ");
			choice = input.next().charAt(0);

			if (!(choice == 'y' || choice == 'Y' || choice == 'n' || choice == 'N'))
			{
				System.out.println("Error: enter y, Y, n, or N.");
			}
		}

		if (choice == 'y' || choice == 'Y')
		{
			double percent = 0;

			while (percent <= 0)
			{
				System.out.print("\nEnter training percentage: ");
				percent = input.nextDouble();

				if (percent <= 0)
				{
					System.out.println("Error: value must be greater than 0.");
				}
			}

			System.out.println();

			for (int i = 0; i < names.length; i++)
			{
				double trainingHR = heartRates[i] * (percent / 100.0);
				System.out.printf("%s Training Heart Rate: %.1f\n", names[i], trainingHR);
			}
		}
	}
}