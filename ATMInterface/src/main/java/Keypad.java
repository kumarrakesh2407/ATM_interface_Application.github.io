import java.util.Scanner;

public class Keypad {
    private Scanner scanner;

    public Keypad() {
        this.scanner = new Scanner(System.in);
    }

    public String getInput(String prompt) {
        System.out.print(prompt);
        if (scanner.hasNextLine()) {
            return scanner.nextLine();
        }
        return "";
    }

    public int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                if (scanner.hasNextLine()) {
                    String input = scanner.nextLine();
                    return Integer.parseInt(input);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    public double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                if (scanner.hasNextLine()) {
                    String input = scanner.nextLine();
                    return Double.parseDouble(input);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid amount.");
            }
        }
    }
}
