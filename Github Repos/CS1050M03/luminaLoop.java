/*
 * 
 */

/**
 * 
 */
import java.util.Scanner;

public class luminaLoop
{

	/**
	 * @param args
	 */
	public static void main(String[] args)

	{
		Scanner input = new Scanner(System.in);
		{
			System.out.print("Enter a positive number for an exponent: ");
			// ADD CODE to input next double for weight
			final double exponent = input.nextDouble();
			{
			while (exponent <= 0)
				{
					System.out.printf("Error: Code 404: Please Enter a new number");
				}

				{
				do while (exponent >= 1)
					{
						System.out.printf("The exponent is",exponent);
					}
				}
			}
		}
	}
}