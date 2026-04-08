
/*
 *  Name: Francisco Quintero
 *  Class: CS1050 M/W
 *  Description: Project a1
 */
import java.util.Scanner;

public class TrainingHeartRate
{

	public TrainingHeartRate(String[] args)
	{
		Scanner input = new Scanner(System.in);

		// athlete names and max heart rates
		String[] athletes =
		{ "Gordon", "Jokic", "Peyton", "Bruce", "Deb", "Monty" };
		double[] maxHeartRates =
		{ 190, 190, 197, 192, 161, 200 };

		char response = ' ';

		// validate y/n
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

			// validate
			while (percentage <= 0)
			{
				System.out.print("Enter training percentage: ");
				percentage = input.nextDouble();

				if (percentage <= 0)
				{
					System.out.println("Error: value must be greater than 0. Try again.");
				}
			}

			// convert percentage into decimal
			double decimalPercent = percentage / 100.0;

			// display training heart rate
			for (int i = 0; i < athletes.length; i++)
			{
				double trainingHeartRate = maxHeartRates[i] * decimalPercent;
				System.out.printf("%s Training Heart Rate: %.1f%n", athletes[i], trainingHeartRate);
			}
		} else
		{
			System.out.println("Training Program Analysis complete");

		}
	}// end of main
}// end of class