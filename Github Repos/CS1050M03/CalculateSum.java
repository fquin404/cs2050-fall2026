
/**
 * 
 */

import java.util.Scanner;

public class CalculateSum

{
	public static int triangleWithLoop(int n)

	{
		Scanner input = new Scanner(System.in);
		int total = 0;
		for (int i = 1; i <= n; i++)
		{
			total = total + i;
		}
		return total;
	}

	public static void main(String[] args)
	{
		int n = 5;
		System.out.println("Triangular number of " + n + " is: " + triangleWithLoop(n));
	}
}
