/*
 *  Name: Francisco Quintero
 *  Class: CS1050 M/W
 *  Description: Guided Exploration 03
 */

public class CalculateSum
{

	public static void main(String[] args)
	{

		int max = 4;
		int sum;

		sum = calcSum(max);

		System.out.println("Sum from 1 to " + max + " = " + sum);

	}// end of main

	public static int calcSum(int currentMax)

	{
		int sum = 0;

		for (int i = 1; i <= currentMax; i++)
		{
			sum = sum + i;

		}
		return sum;
	}

}// end of class

/*
 * import java.util.Scanner;
 * 
 * public class CalculateSum
 * 
 * { public static int triangleWithLoop(int n)
 * 
 * { int total = 0; for (int i = 1; i <= n; i++) { total = total + i; } return
 * total;
 * 
 * }
 * 
 * public static void main(String[] args) {
 * System.out.print("Enter your number: "); Scanner input = new
 * Scanner(System.in); int n = input.nextInt(); input.close();
 * System.out.println("Triangular number of " + n + " is: " +
 * triangleWithLoop(n)); } }
 */