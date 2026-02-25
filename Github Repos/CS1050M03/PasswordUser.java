
/**
 *
 */

/**
 * 
 */
import java.util.Scanner;

public class PasswordUser
{

	static String password = "passington";
	static String username = "Lumina";
//int attempts = 0;

	// boolean loggedIn = false

	// while(!loggedIn attempts<=3);

	public static void main(String[] args)

	{
		Scanner input = new Scanner(System.in);

		System.out.print("Enter your username: ");
		String user = input.next();

		System.out.print("Enter your password: ");
		String pass = input.next();
		input.close();

		{
			if (username != user && password == pass)
				System.out.print("Incorrect Username");

			else if (password != pass && username == user)
				System.out.print("Incorrect Password");

			else if ((username.equals(user)) && (password.equals(pass)))

				System.out.print("Correct Login");

			else if (user != username && pass != password)

				System.out.print("Incorrect Login. Try Again. ");

		}
	}
}
