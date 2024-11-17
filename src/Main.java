import java.util.ArrayList;
import java.util.Scanner;
public class Main
{
    private static final Scanner in = new Scanner(System.in); // got help w/ methods
    private static final ArrayList<String> list = new ArrayList<>() ; // got help w/ methods
    public static void main(String[] args)
    {

        boolean finished = false;

        while (!finished) {
            showMenu();
            String choice = SafeInput.getRegExString(in, "Choose an option [AaDdIiPpQq]: ", "[AaDdIiPpQq]").toUpperCase();

            if (choice.equals("A"))
            {
                addItem();
            } else if (choice.equals("D"))
            {
                deleteItem();
            } else if (choice.equals("I"))
            {
                insertItem();
            } else if (choice.equals("P"))
            {
                printList();
            } else if (choice.equals("Q"))
            {
                if (SafeInput.getYNConfirm(in, "Are you sure you want to quit?"))
                {
                    finished = true;
                }
            }
        }
    }
    private static void showMenu()
    {
        String menu = """
            \n--- Menu ---
            A - Add an item
            D - Delete an item
            I - Insert an item
            P - Print the list
            Q - Quit
            """;
        System.out.print(menu);
    }
    private static void printList()
    {
        System.out.println("\n--- List Items ---");
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, list.get(i)); // got help w/ formatting
        }
    }
    private static void printNumberedList() {
        System.out.println("\n--- Numbered List ---");
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, list.get(i)); // got help w/ formatting
        }
    }

    private static void addItem() {
        String item = SafeInput.getNonZeroLenString(in, "Enter the item to add");
        list.add(item);
        System.out.println("Item added.");
    }


    private static void deleteItem() {

        printNumberedList();
        int deletedItem = SafeInput.getRangedInt(in, "Enter the number of the item to delete", 1, list.size());
        list.remove(deletedItem - 1);
        System.out.println("Item deleted.");
    }

    private static void insertItem() {
        printNumberedList();
        int position = SafeInput.getRangedInt(in, "Enter the position to insert at (1 to " + (list.size() + 1) + ")", 1, list.size() + 1);
        String item = SafeInput.getNonZeroLenString(in, "Enter the item to insert");
        list.add(position - 1, item);
        System.out.println("Item inserted.");
    }




}
