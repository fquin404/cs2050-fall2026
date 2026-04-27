
/*
 *  Name: Francisco Quintero
 *  Class: CS1050 M/W
 *  Description: Guided Exploration 05      
 *  This program will dealership.?
 */
import java.io.FileWriter;
import java.io.IOException;

class Dealership
{
	private String name;
	private Car[] inventory;
	private int carCount;

	public Dealership(String name, int maxCars)
	{
		this.name = name;
		this.inventory = new Car[maxCars];
		this.carCount = 0;
	}

	// add a car
	public boolean addCar(Car car)
	{
		if (carCount < inventory.length)
		{
			inventory[carCount++] = car;
			return true;
		} else
		{
			System.out.println("Inventory full. Cannot add more cars.");
			return false;
		}
	}

	// display all cars
	public void displayCars()
	{
		if (carCount == 0)
		{
			System.out.println("No cars in inventory.");
			return;
		}

		for (int i = 0; i < carCount; i++)
		{
			System.out.println(inventory[i]);
		}
	}

	// find most expensive car
	public Car getMostExpensiveCar()
	{
		if (carCount == 0)
			return null;

		Car mostExpensive = inventory[0];

		for (int i = 1; i < carCount; i++)
		{
			if (inventory[i].getPrice() > mostExpensive.getPrice())
			{
				mostExpensive = inventory[i];
			}
		}

		return mostExpensive;
	}

	// write to file
	public void writeToFile(String filename)
	{
		try (FileWriter writer = new FileWriter(filename))
		{
			writer.write("Dealership: " + name + "\n");
			writer.write("Inventory:\n");

			for (int i = 0; i < carCount; i++)
			{
				writer.write(inventory[i].toString() + "\n");
			}

			System.out.println("Inventory successfully written to file.");
		} catch (IOException e)
		{
			System.out.println("Error writing to file.");
			e.printStackTrace();
		}
	}
}

class Car
{
	private String make;
	private String model;
	private double price;

	public Car(String make, String model, double price)
	{
		this.make = make;
		this.model = model;
		this.price = price;
	}

	public double getPrice()
	{
		return price;
	}

	public String toString()
	{
		return make + " " + model + " - $" + price;
	}
}

public class DealershipTask
{
	public static void main(String[] args)
	{

		// create dealership
		Dealership dealership = new Dealership("Elite Motors", 5);

		// add cars
		dealership.addCar(new Car("Toyota", "Camry", 25000));
		dealership.addCar(new Car("Tesla", "Model 3", 40000));
		dealership.addCar(new Car("BMW", "M3", 70000));

		// display cars
		System.out.println("All Cars:");
		dealership.displayCars();

		// find most expensive car
		Car expensive = dealership.getMostExpensiveCar();
		if (expensive != null)
		{
			System.out.println("\nMost Expensive Car:");
			System.out.println(expensive);
		}

		// write to file
		dealership.writeToFile("dealership_inventory.txt");
	}
}