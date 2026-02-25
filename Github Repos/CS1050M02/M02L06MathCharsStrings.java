/*
 *  Name: Francisco Quintero
 *  Class: CS1050 M/W
 *  Description: Guided Exploration 03      
 *  This program will make a mad lib after taking input.
 */

import java.util.Scanner;

public class M02L06MathCharsStrings
{

	public static void main(String[] args)
	{

		Scanner input = new Scanner(System.in);
		// string is an object that represents a sequence of characters.

		// char is a primitive data type that represents a single character

		// next() reads a single word (token) from the input, stopping at whitespace.

		// concatenate means to link or join things together.

		System.out.print("Enter a first name: ");
		String firstName = input.next();

		System.out.print("Enter a last name: ");
		String lastName = input.next();

		System.out.print("Enter a noun: ");
		String noun = input.next();

		System.out.print("Enter a verb ending in -ing: ");
		String verb = input.next();

		System.out.print("Enter an adjective: ");
		String adjective = input.next();

		System.out.print("Enter a place: ");
		String place = input.next();

		System.out.print("Enter your favorite letter: ");
		char favoriteLetter = input.next().charAt(0); // charAt(0) is used here to get the first character of the
														// firstName String.

		char lastInitial = lastName.charAt(0);

		String story = "Once upon a time, " + firstName + " " + lastInitial + " was " + verb + " through the " + place
				+ " with a " + noun + ". It was a very " + adjective + " day. Their favorite letter was "
				+ favoriteLetter + ".";

		// print the story
		System.out.println("\n" + story);
	}
}
