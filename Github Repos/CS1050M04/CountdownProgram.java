/*
 *  Name: Francisco Quintero
 *  Class: CS1050 M/W
 *  Description: Quiz Question 3
 *  Hello World!
 */

import java.util.Scanner;

public class CountdownProgram
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		int startNumber = getPositiveInteger(input);
		displayCountdown(startNumber);

		input.close();
	}

	public static int getPositiveInteger(Scanner input)
	{
		int number;

		while (true)
		{
			System.out.print("Enter start number: ");

			if (input.hasNextInt())
			{
				number = input.nextInt();

				if (number >= 1)
				{
					return number;
				}
			} else
			{
				input.next();
			}

			System.out.println("Invalid, try again.");
		}
	}

	public static void displayCountdown(int startNumber)
	{
		for (int i = startNumber; i >= 1; i--)
		{
			System.out.println(i);
		}

		System.out.println("Blast off!");
	}
}
