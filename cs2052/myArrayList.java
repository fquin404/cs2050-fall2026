//Francisco Quintero CS2050 M/W Prof. Sasha

//DO NOT DELETE KEEP THIS AS AN EXAMPLE / REFERENCE FOR LATER

public class myArrayList { // creates the custom array list class

	int intSize = 1; // sets the starting array length to one

	int[] privateArray = new int[intSize]; // creates the array that stores the numbers

	int size = 0; // keeps track of how many numbers are stored

	public myArrayList(int a) { // creates a list with one starting number

		add(a); // adds the starting number to the list

	} // ends the constructor

	public myArrayList() { // creates an empty list

	} // ends the empty constructor

	public void add(int a) { // adds a number to the end of the list

		if (size >= privateArray.length) { // checks if the array is full

			int[] newArray = new int[privateArray.length + 1]; // creates an array with one more space

			for (int i = 0; i < privateArray.length; i++) { // moves through the old array

				newArray[i] = privateArray[i]; // copies each number into the new array

			} // ends the copying loop

			privateArray = newArray; // replaces the old array with the new array

		} // ends the full array check

		privateArray[size] = a; // places the number in the next open space

		size++; // increases the number of stored items

	} // ends the add method

	public void add(int index, int a) { // adds a number at a chosen index

		if (index >= 0 && index <= size) { // checks that the index can be used

			if (size >= privateArray.length) { // checks if the array is full

				int[] newArray = new int[privateArray.length + 1]; // creates an array with one more space

				for (int i = 0; i < privateArray.length; i++) { // moves through the old array

					newArray[i] = privateArray[i]; // copies each number into the new array

				} // ends the copying loop

				privateArray = newArray; // replaces the old array with the new array

			} // ends the full array check

			for (int i = size; i > index; i--) { // moves later numbers one space to the right

				privateArray[i] = privateArray[i - 1]; // copies the number from the space on the left

			} // ends the shifting loop

			privateArray[index] = a; // places the new number at the chosen index

			size++; // increases the number of stored items

		} // ends the index check

	} // ends the indexed add method

	public void remove() { // removes the last number in the list

		if (size > 0) { // checks that the list is not empty

			size--; // lowers the number of stored items by one

			privateArray[size] = 0; // clears the unused array space

		} // ends the empty list check

	} // ends the remove method

	public void remove(int index) { // removes the number at a chosen index

		if (index >= 0 && index < size) { // checks that the index is in the list

			for (int i = index; i < size - 1; i++) { // moves later numbers one space to the left

				privateArray[i] = privateArray[i + 1]; // copies the next number into the current space

			} // ends the shifting loop

			size--; // lowers the number of stored items by one

			privateArray[size] = 0; // clears the unused array space

		} // ends the index check

	} // ends the indexed remove method

	public int get(int index) { // gets the number at a chosen index

		return privateArray[index]; // returns the number from the chosen index

	} // ends the get method

	public String toString() { // changes the list into a string

		String temp = ""; // creates an empty string

		for (int i = 0; i < size; i++) { // moves through all stored numbers

			temp = temp + privateArray[i]; // adds each number to the string

		} // ends the string loop

		return temp; // returns the completed string

	} // ends the toString method

} // ends the custom array list class
