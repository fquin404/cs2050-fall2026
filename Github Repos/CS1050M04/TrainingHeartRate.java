import java.util.Scanner;

public class TrainingHeartRate
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		// Example athlete names and max heart rates
		String[] athletes =
		{ "Gordon", "Jokic", "Peyton", "Bruce", "Deb", "Monty" };
		double[] maxHeartRates =
		{ 190, 190, 197, 192, 161, 200 };

		char response;

		// Validate y/n response
		while (true)
		{
			System.out.print("Do you want to calculate the training heart rates? (y/n): ");
			response = input.next().charAt(0);

			if (response == 'y' || response == 'Y' || response == 'n' || response == 'N')
			{
				break;
			}

			System.out.println("Error: enter y, Y, n, or N.");
		}

		if (response == 'y' || response == 'Y')
		{
			double percentage;

			// Validate training percentage
			while (true)
			{
				System.out.print("Enter training percentage: ");
				percentage = input.nextDouble();

				if (percentage > 0)
				{
					break;
				}

				System.out.println("Error: value must be greater than 0.");
			}

			// Convert percentage into decimal
			double decimalPercent = percentage / 100.0;

			// Display each athlete's training heart rate
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
