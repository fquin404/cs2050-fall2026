/*
 *  Name: Francisco Quintero
 *  Class: CS1050 M/W
 *  Description: Guided Exploration 03      
 *  This program will help a person choose concert seats.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConcertTicketPrices
{

	public static void main(String[] args)
	{

		Scanner input = new Scanner(System.in);
		char sectionChar;
		String sectionName = "";
		int row = 0;
		int price = 0;

		// input for section
		System.out.print("Enter ONE character for section - F: Front, C: Center, S: Side, U: Upper: ");
		String sectionInput = input.next();
		sectionChar = sectionInput.charAt(0);
		char upperSectionChar = Character.toUpperCase(sectionChar);

		// chooses the section
		if (upperSectionChar == 'F')
		{
			sectionName = "Front Section";
		} else if (upperSectionChar == 'C')
		{
			sectionName = "Center Section";
		} else if (upperSectionChar == 'S')
		{
			sectionName = "Side Section";
		} else if (upperSectionChar == 'U')
		{
			sectionName = "Upper Section";
		} else
		{
			System.out.println("Invalid section, program ending");
			input.close();
			return;
		}

		System.out.println("Selected " + sectionName);

		// asking for the row
		try
		{
			System.out.print("Enter row: ");
			row = input.nextInt();

			if (row < 1 || row > 60)
			{
				System.out.println("Invalid row, program ending");
				input.close();
				return;
			}

			// assigning price to the rows
			if (row <= 15)
			{
				price = 450;
			} else if (row <= 30)
			{
				price = 300;
			} else
			{
				price = 200;
			}

			// show the result
			System.out.println("Section " + sectionName + " row " + row + " price: $" + price);

		} catch (InputMismatchException e)
		{
			System.out.println("Invalid input for row. Please enter a number.");
			System.out.println("Invalid row, program ending");
		}
	}// end of class
}// end of main
