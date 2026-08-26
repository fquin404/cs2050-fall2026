
public class myArrayList {

	int intSize = 10;
	int[] privateArray = new int[intSize];
	int size = 0;
	
public static void main(String[] args) {
		
		System.out.println("");
		
	}
public myArrayList(int a) {
	
	add(a);
	
}
public void add(int a) {
	if (size >= privateArray.length) {
		
		int[] newArray = new int[privateArray.length+1];
		
		for (int i = 0; i < privateArray.length; i++) {
		newArray[i] = privateArray[i];
		}
		
		privateArray = newArray;
		
		
	}
	
	
	
	privateArray[size] = a;
	size++;
	
}

public void remove() {


}


public String toString() {
	String temp = "";
	for (int i = 0; i < size; i++) {
		temp = temp + privateArray[i];
		
	} return temp;
	
}}