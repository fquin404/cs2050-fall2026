/*
 *  Name: Francisco Quintero
 *  Class: CS1050 M/W
 *  Description: project iteration 1a
 */

import java.util.Scanner;

public class TrainingHeartRate
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		// athlete names and maximum heart rates
		String[] athletes =
		{ "Gordon", "Jokic", "Peyton", "Bruce", "Deb", "Monty" };
		double[] maxHeartRates =
		{ 190, 190, 197, 192, 161, 200 };

		char response = ' ';

		// aAsk until a valid response is entered
		while (response != 'y' && response != 'Y' && response != 'n' && response != 'N')
		{
			System.out.print("Do you want to calculate the training heart rates? (y/n): ");
			response = input.next().charAt(0);

			if (response != 'y' && response != 'Y' && response != 'n' && response != 'N')
			{
				System.out.println("Error: enter y, Y, n, or N. Try again.");
			}
		}

		if (response == 'y' || response == 'Y')
		{
			double percentage = 0;
			boolean validPercentage = false;

			// ask until a valid percentage is entered
			while (!validPercentage)
			{
				System.out.print("Enter training percentage: ");

				if (input.hasNextDouble())
				{
					percentage = input.nextDouble();

					if (percentage > 0)
					{
						validPercentage = true;
					} else
					{
						System.out.println("Error: value must be greater than 0. Try again.");
					}
				} else
				{
					input.next();
					System.out.println("Error: please enter a numeric value.");
				}
			}

			double decimalPercent = percentage / 100.0;

			System.out.println();
			for (int i = 0; i < athletes.length; i++)
			{
				double trainingHeartRate = maxHeartRates[i] * decimalPercent;
				System.out.printf("%s Training Heart Rate: %.1f%n", athletes[i], trainingHeartRate);
			}
		} else
		{
			System.out.println("Training Program Analysis complete");
		}

		input.close();
	}
}
