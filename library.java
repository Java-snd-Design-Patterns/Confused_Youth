package library;

import java.util.Scanner;

public class library {
    private books bookInventory;
    private students studentRegistry;

    private static library instance;

    private library() {
        bookInventory = books.getInstance();
        studentRegistry = students.getInstance();
    }

    public static library getInstance() {
        if (instance == null) {
            instance = new library();
        }
        return instance;
    }

    public void displayMenu() {
        System.out.println("Enter 0 to Exit Application.");
        System.out.println("Enter 1 to Add new Book.");
        System.out.println("Enter 2 to Upgrade Quantity of a Book.");
        System.out.println("Enter 3 to Search a Book.");
        System.out.println("Enter 4 to Show All Books.");
        System.out.println("Enter 5 to Register Student.");
        System.out.println("Enter 6 to Show All Registered Students.");
        System.out.println("Enter 7 to Check Out Book.");
        System.out.println("Enter 8 to Check In Book.");
    }

    public void runLibrary() {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            System.out.println("Enter your choice:");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 0:
                    System.out.println("Exiting application...");
                    break;
                case 1:
                    bookInventory.addBook();
                    break;
                case 2:
                    bookInventory.upgradeBookQty();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    bookInventory.showAllBooks();
                    break;
                case 5:
                    studentRegistry.addStudent();
                    break;
                case 6:
                    studentRegistry.showAllStudents();
                    break;
                case 7:
                    checkOutBook();
                    break;
                case 8:
                    checkInBook();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println("-----------------------------");
        } while (choice != 0);
    }

    private void searchBook() {
        Scanner input = new Scanner(System.in);
        int searchChoice;

        System.out.println("Enter 1 to Search by Serial Number.");
        System.out.println("Enter 2 to Search by Author Name.");
        System.out.println("Enter your choice:");
        searchChoice = input.nextInt();

        switch (searchChoice) {
            case 1:
                bookInventory.searchBySno();
                break;
            case 2:
                bookInventory.searchByAuthorName();
                break;
            default:
                System.out.println("Invalid choice. Returning to main menu...");
                break;
        }
    }

    private void checkOutBook() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Serial No of Book to be Checked Out:");
        int sNo = input.nextInt();
        input.nextLine();

        book checkedOutBook = bookInventory.checkOutBook(sNo);

        if (checkedOutBook != null) {
            System.out.println("Book checked out successfully!");
            // Perform additional operations if needed
        }
    }

    private void checkInBook() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Serial No of Book to be Checked In:");
        int sNo = input.nextInt();
        input.nextLine();

        book checkedInBook = bookInventory.checkOutBook(sNo);

        if (checkedInBook != null) {
            System.out.println("Book checked in successfully!");
            // Perform additional operations if needed
        }
    }

    public static void main(String[] args) {
        library lib = library.getInstance();
        lib.runLibrary();
    }
}
