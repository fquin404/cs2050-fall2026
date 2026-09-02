//Francisco Quintero CS2050 M/W Prof. Sasha

public class Main { // creates the main class

	public static void main(String[] args) { // starts the main method

		myArrayList numbers = new myArrayList(); // creates an empty list for testing

		System.out.println("starting list: " + numbers); // prints the empty list

		numbers.add(1); // adds one to the end of the list

		numbers.add(2); // adds two to the end of the list

		numbers.add(3); // adds three to the end of the list

		numbers.add(4); // adds four to the end of the list

		System.out.println("after growing the array: " + numbers); // prints the list after it grows

		numbers.add(0, 5); // inserts five at the beginning

		System.out.println("after inserting at the beginning: " + numbers); // prints the beginning insert result

		numbers.add(3, 9); // inserts nine in the middle

		System.out.println("after inserting in the middle: " + numbers); // prints the middle insert result

		System.out.println("value at index three: " + numbers.get(3)); // tests the get method

		numbers.remove(0); // removes the first number

		System.out.println("after removing the first value: " + numbers); // prints the first removal result

		numbers.remove(2); // removes a number from the middle

		System.out.println("after removing a middle value: " + numbers); // prints the middle removal result

		numbers.remove(); // removes the last number

		System.out.println("after removing the last value: " + numbers); // prints the last removal result

		myArrayList startingNumber = new myArrayList(7); // creates a list with one starting number

		System.out.println("list made with the second constructor: " + startingNumber); // tests the second constructor

	} // ends the main method

} // ends the main class
