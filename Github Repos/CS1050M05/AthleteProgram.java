
/*
 *  Name: Francisco Quintero
 *  Class: CS1050 M/W
 *  Description: Project Design Iteration (classes)   
 *  This program will make help trainers to view crucial training data on athletes.
 */
import java.util.Scanner;

class Athlete
{
	String name;
	double bmi;
	int mhr;

	public Athlete(String name, double bmi, int mhr)
	{
		this.name = name;
		this.bmi = bmi;
		this.mhr = mhr;
	}

	public String getBMICategory()
	{
		if (bmi < 18.5)
		{
			return "Underweight";
		} else if (bmi < 30)
		{
			return "Normal";
		} else
		{
			return "High";
		}
	}
}

public class AthleteProgram
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		// =============================
		// Program Overview
		// =============================
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

		// =============================
		// Number of Athletes
		// =============================
		int numAthletes = 0;

		while (numAthletes <= 0)
		{
			System.out.print("Enter the number of athletes on the team: ");
			numAthletes = input.nextInt();

			if (numAthletes <= 0)
			{
				System.out.println("Error: value must be greater than 0.");
			}
		}

		Athlete[] team = new Athlete[numAthletes];

		// =============================
		// Athlete Entry
		// =============================
		for (int i = 0; i < numAthletes; i++)
		{
			System.out.println("\nEnter data for athlete " + (i + 1));

			input.nextLine(); // clear buffer

			// Name validation
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

			// Weight
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

			// Height
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

			// Age
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

			// Calculations
			double bmi = (703 * weight) / (height * height);
			int mhr = 220 - age;

			team[i] = new Athlete(name, bmi, mhr);
		}

		// =============================
		// Athlete Summary
		// =============================
		System.out.println("\n========== Athlete Summary ==========");

		for (int i = 0; i < team.length; i++)
		{
			System.out.println(team[i].name);
			System.out.printf("BMI: %.1f\n", team[i].bmi);
			System.out.println("Category: " + team[i].getBMICategory());
			System.out.println("MHR: " + team[i].mhr + "\n");
		}

		// =============================
		// BMI Analysis
		// =============================
		System.out.println("========== BMI Analysis ==========");

		boolean foundOutside = false;

		for (int i = 0; i < team.length; i++)
		{
			if (team[i].bmi < 18.5)
			{
				System.out.println("Below normal: " + team[i].name);
				foundOutside = true;
			} else if (team[i].bmi >= 30)
			{
				System.out.println("Above normal: " + team[i].name);
				foundOutside = true;
			}
		}

		if (!foundOutside)
		{
			System.out.println("No athletes outside of normal range");
		}

		// =============================
		// MHR Analysis
		// =============================
		System.out.println("\n========== MHR Analysis ==========");

		double total = 0;
		int highestIndex = 0;

		for (int i = 0; i < team.length; i++)
		{
			total += team[i].mhr;

			if (team[i].mhr > team[highestIndex].mhr)
			{
				highestIndex = i;
			}
		}

		double avg = total / team.length;

		System.out.printf("Team Average Max Heart Rates: %.1f\n", avg);
		System.out.println("\n" + team[highestIndex].name + " has highest max heart rate: " + team[highestIndex].mhr);

		System.out.println("\nAthletes above or equal to average MHR:");
		for (int i = 0; i < team.length; i++)
		{
			if (team[i].mhr >= avg)
			{
				System.out.println(team[i].name);
			}
		}

		// =============================
		// Training Heart Rate
		// =============================
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

			while (percent < 1 || percent > 100)
			{
				System.out.print("\nEnter training percentage (1-100): ");
				percent = input.nextDouble();

				if (percent < 1 || percent > 100)
				{
					System.out.println("Error: value must be between 1 and 100.");
				}
			}

			System.out.println();

			for (int i = 0; i < team.length; i++)
			{
				double trainingHR = team[i].mhr * (percent / 100.0);
				System.out.printf("%s Training Heart Rate: %.1f\n", team[i].name, trainingHR);
			}
		}

		System.out.println("\n**************************************");
		System.out.println("Training Program Analysis Complete");
		System.out.println("**************************************");

		input.close();
	}
}