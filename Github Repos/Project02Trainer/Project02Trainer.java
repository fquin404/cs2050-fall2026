import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Name: Francisco Quintero
 * Class: CS1050 M/W
 * Description: Project 02 Trainer App
 *
 * This program reads athlete data from text files, stores each athlete as
 * an Athlete object, adds Athlete objects to a Team, performs team analysis,
 * and writes athlete results to an output file.
 */

public class Project02Trainer
{
	public static void main(String[] args)
	{
		displayProgramSummary();

		// ===== test 1 =====
		String fileName = "team1.txt";

		try
		{
			System.out.println("\nTesting file: " + fileName);

			Team team = new Team("Nuggets", 6);

			teamSetUp(fileName, team);

			runAnalysis(team);

		} catch (FileNotFoundException exception)
		{
			System.out.println("Error: Unable to find file " + fileName);
		}

		// ===== test 2 =====
		fileName = "team2.txt";

		try
		{
			System.out.println("\nTesting file: " + fileName);

			Team team = new Team("Team CS", 4);

			teamSetUp(fileName, team);

			runAnalysis(team);

		} catch (FileNotFoundException exception)
		{
			System.out.println("Error: Unable to find file " + fileName);
		}

		System.out.println("\nEnd of program");
	}

	/**
	 * reads athlete data from a file and adds each athlete to the Team.
	 *
	 * each line of the file should contain: name weight height age
	 * 
	 * @param fileName the name of the input file
	 * @param team     the Team object that receives Athlete objects
	 * @throws FileNotFoundException if the input file cannot be found
	 */
	public static void teamSetUp(String fileName, Team team) throws FileNotFoundException
	{
		File inputFile = new File(fileName);
		Scanner fileScanner = new Scanner(inputFile);

		while (fileScanner.hasNext())
		{
			String athleteName = fileScanner.next();
			double athleteWeight = fileScanner.nextDouble();
			double athleteHeight = fileScanner.nextDouble();
			int athleteAge = fileScanner.nextInt();

			Athlete athlete = new Athlete(athleteName, athleteWeight, athleteHeight, athleteAge);
			team.addAthlete(athlete);
		}

		fileScanner.close();
	}

	/**
	 * runs all team analysis methods and writes athlete results to an output file.
	 *
	 * this method keeps main shorter by grouping the steps required after a Team
	 * has been created and filled with Athlete objects.
	 *
	 * @param team the Team object being analyzed
	 * @throws FileNotFoundException if the output file cannot be created
	 */
	public static void runAnalysis(Team team) throws FileNotFoundException
	{
		System.out.println("\n========== Team Analysis ==========");
		System.out.println("Team: " + team.getTeamName());
		System.out.println("Total Athletes: " + team.getAthleteCount());
		System.out.println();

		team.displayAthleteResults();
		team.displayAthletesOutsideNormalBMI();

		double averageMaxHeartRate = team.calculateAverageMaxHeartRate();
		System.out.printf("\nAverage Max Heart Rate: %.2f\n", averageMaxHeartRate);

		team.displayAthletesAboveAverageMHR(averageMaxHeartRate);
		team.displayHighestMHR();
		team.displaySmallestLargestHeight();

		String outputFileName = team.getTeamName() + ".txt";
		team.writeAthletesToFile(outputFileName);
	}

	/**
	 * displays a short summary of what the program does.
	 */
	public static void displayProgramSummary()
	{
		System.out.println("**************************************");
		System.out.println("Team and Athlete Analysis");
		System.out.println("**************************************");
		System.out.println("Reads athlete data from file");
		System.out.println("Displays athlete results");
		System.out.println("Performs team analysis");
		System.out.println("Writes results to file");
		System.out.println();
	}
}

// ATHLETE CLASS

/**
 * represents one athlete.
 *
 * the Athlete class stores the athlete's original data: name, weight, height,
 * and age.
 *
 * BMI and max heart rate are not stored as fields. They are calculated through
 * methods when needed.
 */
class Athlete
{
	private String name;
	private double weight;
	private double height;
	private int age;

	/**
	 * creates an Athlete object using data read from the input file.
	 *
	 * @param name   the athlete's name
	 * @param weight the athlete's weight in pounds
	 * @param height the athlete's height in inches
	 * @param age    the athlete's age in years
	 */
	public Athlete(String name, double weight, double height, int age)
	{
		this.name = name;
		this.weight = weight;
		this.height = height;
		this.age = age;
	}

	/**
	 * gets the athlete's name.
	 *
	 * @return the athlete's name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * gets the athlete's weight.
	 *
	 * @return the athlete's weight in pounds
	 */
	public double getWeight()
	{
		return weight;
	}

	/**
	 * gets the athlete's height.
	 *
	 * @return the athlete's height in inches
	 */
	public double getHeight()
	{
		return height;
	}

	/**
	 * gets the athlete's age.
	 *
	 * @return the athlete's age in years
	 */
	public int getAge()
	{
		return age;
	}

	/**
	 * calculates the athlete's BMI using the formula: 703 * weight / height
	 * squared.
	 *
	 * @return the calculated BMI
	 */
	public double calculateBMI()
	{
		double calculatedBMI = (703 * weight) / (height * height);

		return calculatedBMI;
	}

	/**
	 * calculates the athlete's max heart rate using the formula: 220 - age.
	 *
	 * @return the calculated max heart rate
	 */
	public int calculateMaxHeartRate()
	{
		int calculatedMaxHeartRate = 220 - age;

		return calculatedMaxHeartRate;
	}

	/**
	 * determines the athlete's BMI category.
	 *
	 * Under 18.5 is Underweight. 18.5 to under 30 is Normal. 30 or greater is High.
	 *
	 * @return the BMI category as a String
	 */
	public String determineBMICategory()
	{
		String bmiCategory;
		double calculatedBMI = calculateBMI();

		if (calculatedBMI < 18.5)
		{
			bmiCategory = "Underweight";
		} else if (calculatedBMI < 30)
		{
			bmiCategory = "Normal";
		} else
		{
			bmiCategory = "High";
		}

		return bmiCategory;
	}
}

// TEAM CLASS

/**
 * represents a team of athletes.
 *
 * the Team class stores an array of Athlete objects and provides methods for
 * displaying athlete results, analyzing BMI, analyzing max heart rate, finding
 * height ranges, and writing results to a file.
 */
class Team
{
	private String teamName;
	private Athlete[] athletes;
	private int athleteCount;

	/**
	 * creates a Team object.
	 *
	 * @param teamName the name of the team
	 * @param teamSize the maximum number of athletes the team can store
	 */
	public Team(String teamName, int teamSize)
	{
		this.teamName = teamName;
		athletes = new Athlete[teamSize];
		athleteCount = 0;
	}

	/**
	 * adds an Athlete object to the team if there is room.
	 *
	 * if the team is full, the athlete is not added and a message is displayed.
	 *
	 * @param athlete the Athlete object to add
	 */
	public void addAthlete(Athlete athlete)
	{
		if (athleteCount < athletes.length)
		{
			athletes[athleteCount] = athlete;
			athleteCount++;
		} else
		{
			System.out.println("Team is full. Can't add " + athlete.getName());
		}
	}

	/**
	 * gets the team name.
	 *
	 * @return the team name
	 */
	public String getTeamName()
	{
		return teamName;
	}

	/**
	 * gets the number of athletes currently stored in the team.
	 *
	 * @return the number of athletes in the team
	 */
	public int getAthleteCount()
	{
		return athleteCount;
	}

	/**
	 * displays each athlete's BMI, BMI category, and max heart rate.
	 */
	public void displayAthleteResults()
	{
		System.out.println("========== Athlete Summary ==========");

		for (int athleteIndex = 0; athleteIndex < athleteCount; athleteIndex++)
		{
			Athlete currentAthlete = athletes[athleteIndex];

			System.out.println(currentAthlete.getName());
			System.out.printf("BMI: %.1f\n", currentAthlete.calculateBMI());
			System.out.println("Category: " + currentAthlete.determineBMICategory());
			System.out.println("MHR: " + currentAthlete.calculateMaxHeartRate());
			System.out.println();
		}
	}

	/**
	 * displays athletes whose BMI is outside the normal range.
	 *
	 * athletes below 18.5 are listed as below normal. athletes 30 or greater are
	 * listed as above normal.
	 */
	public void displayAthletesOutsideNormalBMI()
	{
		System.out.println("Athletes Outside Normal BMI Range:");

		boolean foundAthleteOutsideNormalRange = false;

		for (int athleteIndex = 0; athleteIndex < athleteCount; athleteIndex++)
		{
			Athlete currentAthlete = athletes[athleteIndex];
			double calculatedBMI = currentAthlete.calculateBMI();

			if (calculatedBMI < 18.5)
			{
				System.out.println("Below normal: " + currentAthlete.getName());
				foundAthleteOutsideNormalRange = true;
			} else if (calculatedBMI >= 30)
			{
				System.out.println("Above normal: " + currentAthlete.getName());
				foundAthleteOutsideNormalRange = true;
			}
		}

		if (!foundAthleteOutsideNormalRange)
		{
			System.out.println("No athletes outside of normal range");
		}
	}

	/**
	 * calculates the average max heart rate of all athletes on the team.
	 *
	 * @return the average max heart rate
	 */
	public double calculateAverageMaxHeartRate()
	{
		double totalMaxHeartRate = 0;
		double averageMaxHeartRate = 0;

		if (athleteCount > 0)
		{
			for (int athleteIndex = 0; athleteIndex < athleteCount; athleteIndex++)
			{
				totalMaxHeartRate += athletes[athleteIndex].calculateMaxHeartRate();
			}

			averageMaxHeartRate = totalMaxHeartRate / athleteCount;
		}

		return averageMaxHeartRate;
	}

	/**
	 * displays athletes whose max heart rate is above or equal to the team average.
	 *
	 * @param averageMaxHeartRate the average max heart rate for the team
	 */
	public void displayAthletesAboveAverageMHR(double averageMaxHeartRate)
	{
		System.out.println("\nAthletes above or equal to average MHR:");

		for (int athleteIndex = 0; athleteIndex < athleteCount; athleteIndex++)
		{
			Athlete currentAthlete = athletes[athleteIndex];

			if (currentAthlete.calculateMaxHeartRate() >= averageMaxHeartRate)
			{
				System.out.println(currentAthlete.getName());
			}
		}
	}

	/**
	 * finds and displays the athlete with the highest max heart rate.
	 *
	 * if duplicate highest values exist, this method displays the first one found.
	 */
	public void displayHighestMHR()
	{
		if (athleteCount > 0)
		{
			int highestMaxHeartRateIndex = 0;

			for (int athleteIndex = 1; athleteIndex < athleteCount; athleteIndex++)
			{
				if (athletes[athleteIndex].calculateMaxHeartRate() > athletes[highestMaxHeartRateIndex]
						.calculateMaxHeartRate())
				{
					highestMaxHeartRateIndex = athleteIndex;
				}
			}

			System.out.println("\nHighest Max Heart Rate:");
			System.out.println(athletes[highestMaxHeartRateIndex].getName() + ": "
					+ athletes[highestMaxHeartRateIndex].calculateMaxHeartRate());
		} else
		{
			System.out.println("\nHighest Max Heart Rate:");
			System.out.println("No athletes available");
		}
	}

	/**
	 * finds and displays the shortest and tallest athletes.
	 *
	 * if duplicate values exist, this method displays the first one found.
	 */
	public void displaySmallestLargestHeight()
	{
		if (athleteCount > 0)
		{
			int shortestAthleteIndex = 0;
			int tallestAthleteIndex = 0;

			for (int athleteIndex = 1; athleteIndex < athleteCount; athleteIndex++)
			{
				if (athletes[athleteIndex].getHeight() < athletes[shortestAthleteIndex].getHeight())
				{
					shortestAthleteIndex = athleteIndex;
				}

				if (athletes[athleteIndex].getHeight() > athletes[tallestAthleteIndex].getHeight())
				{
					tallestAthleteIndex = athleteIndex;
				}
			}

			System.out.println("\nShortest Athlete:");
			System.out.println(
					athletes[shortestAthleteIndex].getName() + " - " + athletes[shortestAthleteIndex].getHeight());

			System.out.println("Tallest Athlete:");
			System.out.println(
					athletes[tallestAthleteIndex].getName() + " - " + athletes[tallestAthleteIndex].getHeight());
		} else
		{
			System.out.println("\nShortest Athlete:");
			System.out.println("No athletes available");

			System.out.println("Tallest Athlete:");
			System.out.println("No athletes available");
		}
	}

	/**
	 * writes athlete results to an output file.
	 *
	 * the file includes the team name, total athletes, and each athlete's BMI, BMI
	 * category, and max heart rate.
	 *
	 * @param fileName the name of the output file
	 * @throws FileNotFoundException if the output file cannot be created
	 */
	public void writeAthletesToFile(String fileName) throws FileNotFoundException
	{
		File outputFile = new File(fileName);
		PrintWriter writer = new PrintWriter(outputFile);

		writer.println("Team: " + teamName);
		writer.println("Total Athletes: " + athleteCount);
		writer.println();

		for (int athleteIndex = 0; athleteIndex < athleteCount; athleteIndex++)
		{
			Athlete currentAthlete = athletes[athleteIndex];

			writer.println(currentAthlete.getName());
			writer.printf("BMI: %.2f\n", currentAthlete.calculateBMI());
			writer.println("Category: " + currentAthlete.determineBMICategory());
			writer.println("MHR: " + currentAthlete.calculateMaxHeartRate());
			writer.println();
		}

		writer.close();

		System.out.println("\nResults written to file:");
		System.out.println(outputFile.getAbsolutePath());
	}
}