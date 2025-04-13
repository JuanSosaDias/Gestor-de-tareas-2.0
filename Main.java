import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        try {
            manager.importTasks(TaskStorage.load());
        } catch (IOException e) {
            System.out.println("No previous tasks found.");
        }

        Scanner scanner = new Scanner(System.in);
        String option;

        do {
            System.out.println("\nTask Manager");
            System.out.println("1. Add Task");
            System.out.println("2. Complete Task");
            System.out.println("3. List Tasks");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.print("Task description: ");
                    String desc = scanner.nextLine();
                    manager.addTask(desc);
                    break;
                case "2":
                    manager.listTasks();
                    System.out.print("Task number to complete: ");
                    int index = Integer.parseInt(scanner.nextLine());
                    manager.completeTask(index);
                    break;
                case "3":
                    manager.listTasks();
                    break;
                case "4":
                    try {
                        TaskStorage.save(manager.exportTasks());
                    } catch (IOException e) {
                        System.out.println("Failed to save tasks.");
                    }
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (!option.equals("4"));
    }
}
