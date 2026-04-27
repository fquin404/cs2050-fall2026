import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

// =============================
// Athlete Class
// =============================
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
		this.bmi = calculateBMI(weight, height);
		this.mhr = calculateMHR(age);
	}

	private double calculateBMI(double weight, double height)
	{
		return (703 * weight) / (height * height);
	}

	private int calculateMHR(int age)
	{
		return 220 - age;
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

// =============================
// Team Class
// =============================
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

	public void displaySummary()
	{
		System.out.println("========== Athlete Summary ==========");
		System.out.println("Team: " + teamName);
		System.out.println("Total Athletes: " + count + "\n");

		for (int i = 0; i < count; i++)
		{
			Athlete a = athletes[i];
			System.out.println(a.getName());
			System.out.printf("BMI: %.1f\n", a.getBMI());
			System.out.println("Category: " + a.getBMICategory());
			System.out.println("MHR: " + a.getMHR() + "\n");
		}
	}

	public void bmiAnalysis()
	{
		System.out.println("Athletes Outside Normal BMI Range:");
		for (int i = 0; i < count; i++)
		{
			Athlete a = athletes[i];
			if (a.getBMI() < 18.5)
				System.out.println("Below normal: " + a.getName());
			else if (a.getBMI() >= 30)
				System.out.println("Above normal: " + a.getName());
		}
	}

	public double getAverageMHR()
	{
		double total = 0;
		for (int i = 0; i < count; i++)
			total += athletes[i].getMHR();

		return total / count;
	}

	public void displayAboveAverageMHR(double avg)
	{
		System.out.println("\nAthletes above or equal to average MHR:");
		for (int i = 0; i < count; i++)
		{
			if (athletes[i].getMHR() >= avg)
				System.out.println(athletes[i].getName());
		}
	}

	public Athlete getHighestMHR()
	{
		int index = 0;
		for (int i = 1; i < count; i++)
		{
			if (athletes[i].getMHR() > athletes[index].getMHR())
				index = i;
		}
		return athletes[index];
	}

	public Athlete getShortest()
	{
		int index = 0;
		for (int i = 1; i < count; i++)
		{
			if (athletes[i].getHeight() < athletes[index].getHeight())
				index = i;
		}
		return athletes[index];
	}

	public Athlete getTallest()
	{
		int index = 0;
		for (int i = 1; i < count; i++)
		{
			if (athletes[i].getHeight() > athletes[index].getHeight())
				index = i;
		}
		return athletes[index];
	}

	public Athlete[] getAthletes()
	{
		return athletes;
	}

	public int getCount()
	{
		return count;
	}

	public String getTeamName()
	{
		return teamName;
	}
}

// =============================
// Main Program Class
// =============================
class AthleteProgram
{
	public static void main(String[] args)
	{
		displayOverview();

		Team team = new Team("Team CS", 4);

		readFromFile("team2.txt", team);

		team.displaySummary();

		System.out.println("========== Team Analysis ==========");
		team.bmiAnalysis();

		double avg = team.getAverageMHR();
		System.out.printf("\nAverage Max Heart Rate: %.2f\n", avg);

		team.displayAboveAverageMHR(avg);

		Athlete highest = team.getHighestMHR();
		System.out.println("\nHighest Max Heart Rate:");
		System.out.println(highest.getName() + ": " + highest.getMHR());

		Athlete shortest = team.getShortest();
		Athlete tallest = team.getTallest();

		System.out.println("\nShortest Athlete:");
		System.out.println(shortest.getName() + " - " + shortest.getHeight());

		System.out.println("Tallest Athlete:");
		System.out.println(tallest.getName() + " - " + tallest.getHeight());

		writeToFile(team);
	}

	// =============================
	// Overview
	// =============================
	public static void displayOverview()
	{
		System.out.println("**************************************");
		System.out.println("Program Overview");
		System.out.println("**************************************");
		System.out.println("Reads athlete data from file and analyzes BMI and MHR.\n");
	}

	// =============================
	// File Reading
	// =============================
	public static void readFromFile(String fileName, Team team)
	{
		try
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
		} catch (FileNotFoundException e)
		{
			System.out.println("Error: Unable to find file " + fileName);
		}
	}

	// =============================
	// File Writing
	// =============================
	public static void writeToFile(Team team)
	{
		try
		{
			PrintWriter writer = new PrintWriter(team.getTeamName() + ".txt");

			writer.println("Team: " + team.getTeamName());
			writer.println("Total Athletes: " + team.getCount() + "\n");

			for (int i = 0; i < team.getCount(); i++)
			{
				Athlete a = team.getAthletes()[i];

				writer.println(a.getName());
				writer.printf("BMI: %.2f\n", a.getBMI());
				writer.println("Category: " + a.getBMICategory());
				writer.println("MHR: " + a.getMHR() + "\n");
			}

			writer.close();

			System.out.println("\nResults written to file:");
			System.out.println(team.getTeamName() + ".txt");
		} catch (Exception e)
		{
			System.out.println("Error writing file.");
		}
	}
}