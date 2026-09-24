//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CSArrayList<String> list = new CSArrayList<>();

        System.out.println("New list:");
        System.out.println(list.debugView());

        list.add("A"); // adds a to the list
        list.add("B"); // adds b to the list
        list.add("C"); // adds c to the list
        System.out.println(System.lineSeparator() + "After adding A, B, and C:"); // prints a heading
        System.out.println(list.debugView()); // prints the updated list
    }
}
