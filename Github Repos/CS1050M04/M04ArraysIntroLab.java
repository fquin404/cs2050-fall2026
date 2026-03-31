public class M04ArraysIntroLab
{

	public static void main(String[] args)
	{
		// Array
		double[] grades =
		{ 88.11, 95.78, 73.58, 72.00, 25.00 };

		int minIndex = findMinIndex(grades);
		double minGrade = grades[minIndex];

		System.out.println("Grades array:");
		for (int i = 0; i < grades.length; i++)
		{
			System.out.println("Index " + i + ": " + grades[i]);
		}
		System.out.println("Minimum grade: " + minGrade + " at index " + minIndex);
	}

	public static int findMinIndex(double[] grades)
	{
		int minIndex = 0;
		double minValue = grades[0];
		for (int i = 1; i < grades.length; i++)
		{
			if (grades[i] < minValue)
			{
				minValue = grades[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
}
