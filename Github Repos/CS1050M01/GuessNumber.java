import java.util.Scanner; //imports scanner

public class GuessNumber //declares class
{
	public static void main(String[] args)
	{		
		final int RANDOM_MULTIPLIER = 100; //limits to 100

		int number = (int) (Math.random() * RANDOM_MULTIPLIER) + 1; //picks number

		try (Scanner keyboardInput = new Scanner(System.in)) {
			System.out.println("Guess a magic number between 0 and 100"); //user prompt

			int guess = -1; //picks number - 100
			while (guess != number) //holds guess
			{

				System.out.print("\nEnter your guess: "); //prompts user to keyboard
				guess = keyboardInput.nextInt();

				if (guess == number) 
				{
					System.out.println("Yes, the number is " + number); //win
				}
				else if (guess > number)
				{
					System.out.println("Your guess is too high"); //loss+
				}
				else
				{
					System.out.println("Your guess is too low"); //loss-
				}
			}
		}

	}//end of main code
}//end of class code
