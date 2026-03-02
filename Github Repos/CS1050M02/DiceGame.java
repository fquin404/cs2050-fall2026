public class DiceGame
{

	public static void main(String[] args)
	{

		{
			double max = 6;
			double min = 1;
			double d1 = (int) (Math.random() * ((max - min) + 1)) + min;
			double d2 = (int) (Math.random() * ((max - min) + 1)) + min;
			double Roll = (int) (d1 + d2);
			// Display the user's roll.
			System.out.printf("Your roll is a %f", Roll);
			{
				if (d1 + d2 == 7)
				{
					System.out.println(", Winner!");
				} else
				{
					if (d1 + d2 == 11)
					{
						System.out.println(", Winner!");
					} else
					{
						if (d1 + d2 == 12)
						{
							System.out.println(", Jackpot!!");
						} else
						{
							System.out.println(", Loser :P");
						}
					}
				}
			}
		}
	}// end of main

}// end of class