//Francisco Quintero CS2050 M/W Prof. Sasha

//DO NOT DELETE KEEP / THIS AS AN EXAMPLE / REFERENCE FOR LATER

public class myArrayList { // creates the custom array list class

	int intSize = 1; // sets the starting array length to one

	int[] privateArray = new int[intSize]; // creates the array that stores the numbers

	int size = 0; // keeps track of how many numbers are stored

	public myArrayList(int a) { // creates a list with one starting number

		add(a); // adds the starting number to the list

	} // end of the constructor

	public myArrayList() { // creates an empty list

	} // end of the empty constructor

	public void add(int a) { // adds a number to the end of the list

		if (size >= privateArray.length) { // checks if the array is full

			int[] newArray = new int[privateArray.length + 1]; // creates an array with one more space

			for (int i = 0; i < privateArray.length; i++) { // moves through the old array

				newArray[i] = privateArray[i]; // copies each number into the new array

			} // end of the copying loop

			privateArray = newArray; // replaces the old array with the new array

		} // end of the full array check

		privateArray[size] = a; // places the number in the next open space

		size++; // increases the number of stored items

	} // end of the add method

	public void add(int index, int a) { // adds a number at a chosen index

		if (index >= 0 && index <= size) { // checks that the index can be used

			if (size >= privateArray.length) { // checks if the array is full

				int[] newArray = new int[privateArray.length + 1]; // creates an array with one more space

				for (int i = 0; i < privateArray.length; i++) { // moves through the old array

					newArray[i] = privateArray[i]; // copies each number into the new array

				} // end of copying loop

				privateArray = newArray; // replaces the old array with the new array

			} // end of full array check

			for (int i = size; i > index; i--) { // moves later numbers one space to the right

				privateArray[i] = privateArray[i - 1]; // copies the number from the space on the left

			} // end of shifting loop

			privateArray[index] = a; // places the new number at the chosen index

			size++; // increases the number of stored items

		} // end of the index check

	} // end of indexed add method

	public void remove() { // removes the last number in the list

		if (size > 0) { // checks that the list is not empty

			size--; // lowers the number of stored items by one

			privateArray[size] = 0; // clears the unused array space

		} // end of the empty list check

	} // end of the remove method

	public void remove(int index) { // removes the number at a chosen index

		if (index >= 0 && index < size) { // checks that the index is in the list

			for (int i = index; i < size - 1; i++) { // moves later numbers one space to the left

				privateArray[i] = privateArray[i + 1]; // copies the next number into the current space

			} // end of shifting loop

			size--; // lowers the number of stored items by one

			privateArray[size] = 0; // clears the unused array space

		} // end of index check

	} // end of index remove

	public int get(int index) { // gets the number at a chosen index

		return privateArray[index]; // returns the number from the chosen index

	} // end of the get method

	public String toString() { // changes the list into a string

		String temp = ""; // creates an empty string

		for (int i = 0; i < size; i++) { // moves through all stored numbers

			temp = temp + privateArray[i]; // adds each number to the string

		} // end of string loop

		return temp; // returns the completed string

	} // end of toString method

} // end of class
