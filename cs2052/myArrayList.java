//Francisco Quintero CS2050 M/W Prof. Sasha


public class myArrayList { //start of class

	int intSize = 1; 

	int[] privateArray = new int[intSize]; 

	int size = 0; 

	public static void main(String[] args) { // start of main method

		myArrayList testList = new myArrayList(); 

		System.out.println("starting list: " + testList); 

		testList.add(1); 

		testList.add(2); 

		testList.add(3); 

		System.out.println("after add: " + testList); 

		testList.add(1, 9); 

		System.out.println("after indexed add: " + testList); 

		System.out.println("number at index two: " + testList.get(2)); 

		testList.remove(); 

		System.out.println("after remove: " + testList); 

		testList.remove(1);

		System.out.println("after indexed remove: " + testList); 

		myArrayList secondList = new myArrayList(7); 

		System.out.println("list made with starting number: " + secondList); 

	} // end of main

	public myArrayList(int a) { // creates a list with one starting number

		add(a); // adds the starting number to the list

	} // end of constructor

	public myArrayList() { // creates an empty list

	} // end of constructor

	public void add(int a) { // adds a number to the end of the list

		if (size >= privateArray.length) { // checks if the array is full

			int[] newArray = new int[privateArray.length + 1]; // creates an array with one extra space

			for (int i = 0; i < privateArray.length; i++) { // moves through the previous array

				newArray[i] = privateArray[i]; // copies number into the new array

			} // end of copy loop

			privateArray = newArray; // replaces the old array with the new array

		}

		privateArray[size] = a; // places the number in the next open space

		size++; // increases the number of stored items

	}

	public void add(int index, int a) { // adds a number at the chosen index

		add(a); // adds the number and makes more space

		for (int i = size - 1; i > index; i--) { // moves numbers one space to the right

			privateArray[i] = privateArray[i - 1]; // copies the number from the space on the left

		}

		privateArray[index] = a; // places the new number at the chosen index

	}

	public void remove() { // removes the last number in the list

		if (size > 0) { // checks that the list is not empty

			size--; // lowers the number of stored items by one

		} 

	}

	public void remove(int index) { // removes the number at a chosen index

		if (index >= 0 && index < size) { // checks that the index is in the list

			for (int i = index; i < size - 1; i++) { // moves later numbers one space to the left

				privateArray[i] = privateArray[i + 1]; // copies the next number into the current space

			} // end of shifting loop

			size--; // lowers the number of stored items by one

		} 

	}

	public int get(int index) { // gets the number at the chosen index

		return privateArray[index]; // returns the number from the chosen index

	} // end of get

	public String toString() { // changes the list into a string

		String temp = ""; // creates an empty string

		for (int i = 0; i < size; i++) { // moves through all stored numbers

			temp = temp + privateArray[i]; // adds each number to the string

		}

		return temp; // returns the completed string

	}

} // end of class