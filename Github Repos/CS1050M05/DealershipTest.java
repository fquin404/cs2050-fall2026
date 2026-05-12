/** CS1050M05
 * 
 */

/**
 * 
 */
public class DealershipTest
{
	private String name;
	private Car[] inventory;
	private int carCount;

	public DealershipTest(String name, int maxCars)
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

	final class Car
	{
		private String make;
		private String model;
		private int price;

		public Car(String make, String model, int price)
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

}
