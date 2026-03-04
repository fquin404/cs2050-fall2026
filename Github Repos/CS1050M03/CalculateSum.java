
/**
 * 
 */

import java.util.Scanner;

public class CalculateSum

{
	public static int triangleWithLoop(int n)

	{
		int total = 0;
		for (int i = 1; i <= n; i++)
		{
			total = total + i;
		}
		return total;

	}

	public static void main(String[] args)
	{
		System.out.print("Enter your number: ");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.close();
		System.out.println("Triangular number of " + n + " is: " + triangleWithLoop(n));
	}
}
