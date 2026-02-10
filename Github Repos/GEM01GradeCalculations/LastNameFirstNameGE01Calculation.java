/*
 *  Name: Francisco Quintero
 *  Class: CS1050 M/W
 *  Description: Guided Exploration 01      
 *  The program will calculate a final grade for this class based on the category weights 
 */

public class LastNameFirstNameGE01Calculation {

    public static void main(String[] args) {

        // Grades
        double Grade1 = 95;
        double Grade2 = 92;
        double Grade3 = 88;
        double Grade4 = 87;
        double Grade5 = 93;

        //weights
        double Weight1 = 0.15;
        double Weight2 = 0.20;
        double Weight3 = 0.25;
        double Weight4 = 0.20;
        double Weight5 = 0.20;

        // Calculate final grade
        double finalGrade =
                (Grade1 * Weight1) +
                (Grade2 * Weight2) +
                (Grade3 * Weight3) +
                (Grade4 * Weight4) +
                (Grade5 * Weight5);

        //show results
        System.out.println("Final Grade: " + finalGrade);
    } //end of Main
}//end of Class