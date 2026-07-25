import java.util.Scanner;

public class Main {
    public static String getValidString(Scanner sc, String prompt, boolean allowDigits) {
        String input;
        String allowedPattern = allowDigits ? "[a-zA-Z0-9 .,'-]+" : "[a-zA-Z .,'-]+";
        while (true) {
            System.out.print(prompt);
            input = sc.nextLine().trim();
            input = input.replaceAll("[\u2018\u2019]", "'").replaceAll("[\u2013\u2014]", "-");
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty. Please try again.");
            } else if (!input.matches(allowedPattern)) {
                if (allowDigits) {
                    System.out.println("Invalid characters detected. Please try again.");
                } else {
                    System.out.println("Numbers are not allowed here. Please try again.");
                }
            } else {
                break;
            }
        }
        return input;
    }

    public static int getValidInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }

    public static int getValidYear(Scanner sc, String prompt) {
    int year;
    while (true) {
        year = getValidInt(sc, prompt);
        if (year < 1000 || year > 2026) {
            System.out.println("Year must be between 999 and 2026. Please try again.");
        } else {
            break;
        }
    }
    return year;
}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        int choice = 0;

        while (choice != 4) {
            System.out.println();
            System.out.println("Menu");
            System.out.println("1 - Add Book");
            System.out.println("2 - Display Book");
            System.out.println("3 - Search Book");
            System.out.println("4 - Exit");
            choice = getValidInt(sc, "Enter choice: ");

            switch (choice) {
                case 1:
                    String title = getValidString(sc, "Enter title: ", true);
                    String author = getValidString(sc, "Enter author: ", false);
                    int year = getValidYear(sc, "Enter year: ");
                    library.addBook(new Book(title, author, year));
                    break;
                case 2:
                    library.displayBooks();
                    break;
                case 3:
                    String searchTitle = getValidString(sc, "Enter a book to search: ", true);
                    library.searchBook(searchTitle);
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}