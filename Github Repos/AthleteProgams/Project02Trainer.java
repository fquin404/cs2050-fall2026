import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * ==== Francisco Quintero ====
 * ==== CS1050 M/W ====
 * Trainer App (Classes and Files
 */

public class Project02Trainer
{
	public static void main(String[] args)
	{
		displayProgramSummary();

		// ===== case 1 =====
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

		// ===== case 2 =====
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

	// ==== file reading ====
	public static void teamSetUp(String fileName, Team team) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File(fileName));

		while (file.hasNext())
		{
			String name = file.next();
			double weight = file.nextDouble();
			double height = file.nextDouble();
			int age = file.nextInt();

			Athlete a = new Athlete(name, weight, height, age);
			team.addAthlete(a);
		}

		file.close();
	}

	// ==== file analysis ====
	public static void runAnalysis(Team team) throws FileNotFoundException
	{
		System.out.println("\n========== Team Analysis ==========");
		System.out.println("Team: " + team.getTeamName());
		System.out.println("Total Athletes: " + team.getAthleteCount());
		System.out.println();

		team.displayAthleteResults();
		team.displayAthletesOutsideNormalBMI();

		double avg = team.calculateAverageMaxHeartRate();
		System.out.printf("\nAverage Max Heart Rate: %.2f\n", avg);

		team.displayAthletesAboveAverageMHR(avg);
		team.displayHighestMHR();
		team.displaySmallestLargestHeight();

		String outputFileName = team.getTeamName() + ".txt";
		team.writeAthletesToFile(outputFileName);
	}

	// ==== display summry ====
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

// ==== athlete class ====
class Athlete
{
	private String name;
	private double height;
	private double bmi;
	private int mhr;

	public Athlete(String name, double weight, double height, int age)
	{
		this.name = name;
		this.height = height;
		this.bmi = (703 * weight) / (height * height);
		this.mhr = 220 - age;
	}

	public String getName()
	{
		return name;
	}

	public double getHeight()
	{
		return height;
	}

	public double getBMI()
	{
		return bmi;
	}

	public int getMHR()
	{
		return mhr;
	}

	public String getBMICategory()
	{
		if (bmi < 18.5)
			return "Underweight";
		else if (bmi < 30)
			return "Normal";
		else
			return "High";
	}
}

// ==== team class ====
class Team
{
	private String teamName;
	private Athlete[] athletes;
	private int count;

	public Team(String teamName, int size)
	{
		this.teamName = teamName;
		athletes = new Athlete[size];
		count = 0;
	}

	public void addAthlete(Athlete a)
	{
		if (count < athletes.length)
		{
			athletes[count] = a;
			count++;
		} else
		{
			System.out.println("Team is full. Can't add " + a.getName());
		}
	}

	public String getTeamName()
	{
		return teamName;
	}

	public int getAthleteCount()
	{
		return count;
	}

	// ==== display results ====
	public void displayAthleteResults()
	{
		System.out.println("========== Athlete Summary ==========");

		for (int i = 0; i < count; i++)
		{
			Athlete a = athletes[i];
			System.out.println(a.getName());
			System.out.printf("BMI: %.1f\n", a.getBMI());
			System.out.println("Category: " + a.getBMICategory());
			System.out.println("MHR: " + a.getMHR());
			System.out.println();
		}
	}

	public void displayAthletesOutsideNormalBMI()
	{
		System.out.println("Athletes Outside Normal BMI Range:");

		boolean found = false;

		for (int i = 0; i < count; i++)
		{
			Athlete a = athletes[i];

			if (a.getBMI() < 18.5)
			{
				System.out.println("Below normal: " + a.getName());
				found = true;
			} else if (a.getBMI() >= 30)
			{
				System.out.println("Above normal: " + a.getName());
				found = true;
			}
		}

		if (!found)
		{
			System.out.println("No athletes outside of normal range");
		}
	}

	public double calculateAverageMaxHeartRate()
	{
		double total = 0;

		for (int i = 0; i < count; i++)
		{
			total += athletes[i].getMHR();
		}

		return total / count;
	}

	public void displayAthletesAboveAverageMHR(double avg)
	{
		System.out.println("\nAthletes above or equal to average MHR:");

		for (int i = 0; i < count; i++)
		{
			if (athletes[i].getMHR() >= avg)
			{
				System.out.println(athletes[i].getName());
			}
		}
	}

	public void displayHighestMHR()
	{
		int index = 0;

		for (int i = 1; i < count; i++)
		{
			if (athletes[i].getMHR() > athletes[index].getMHR())
			{
				index = i;
			}
		}

		System.out.println("\nHighest Max Heart Rate:");
		System.out.println(athletes[index].getName() + ": " + athletes[index].getMHR());
	}

	public void displaySmallestLargestHeight()
	{
		int smallest = 0;
		int largest = 0;

		for (int i = 1; i < count; i++)
		{
			if (athletes[i].getHeight() < athletes[smallest].getHeight())
			{
				smallest = i;
			}

			if (athletes[i].getHeight() > athletes[largest].getHeight())
			{
				largest = i;
			}
		}

		System.out.println("\nShortest Athlete:");
		System.out.println(athletes[smallest].getName() + " - " + athletes[smallest].getHeight());

		System.out.println("Tallest Athlete:");
		System.out.println(athletes[largest].getName() + " - " + athletes[largest].getHeight());
	}

	public void writeAthletesToFile(String fileName) throws FileNotFoundException
	{
		PrintWriter writer = new PrintWriter(fileName);

		writer.println("Team: " + teamName);
		writer.println("Total Athletes: " + count);
		writer.println();

		for (int i = 0; i < count; i++)
		{
			Athlete a = athletes[i];

			writer.println(a.getName());
			writer.printf("BMI: %.2f\n", a.getBMI());
			writer.println("Category: " + a.getBMICategory());
			writer.println("MHR: " + a.getMHR());
			writer.println();
		}

		writer.close();

		System.out.println("\nResults written to file:");
		System.out.println(fileName);
	}
}