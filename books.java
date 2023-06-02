package library;

import java.util.Scanner;

public class books {
    private book[] theBooks;
    private int count;

    private static books instance;

    private books() {
        theBooks = new book[50];
        count = 0;
    }

    public static books getInstance() {
        if (instance == null) {
            instance = new books();
        }
        return instance;
    }

    public void addBook() {
        if (count >= 50) {
            System.out.println("No Space to Add More Books.");
            return;
        }

        book newBook = book.createBook();

        for (int i = 0; i < count; i++) {
            if (compareBookObjects(newBook, theBooks[i])) {
                System.out.println("Book with the same Serial No or Name already exists.");
                return;
            }
        }

        theBooks[count] = newBook;
        count++;

        System.out.println("Book added successfully!");
    }

    private boolean compareBookObjects(book b1, book b2) {
        return b1.getBookName().equalsIgnoreCase(b2.getBookName()) ||
                b1.getSNo() == b2.getSNo();
    }

    public void searchBySno() {
        System.out.println("Enter Serial No of Book:");
        Scanner input = new Scanner(System.in);
        int sNo = input.nextInt();
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (theBooks[i].getSNo() == sNo) {
                System.out.println(theBooks[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No book with Serial No " + sNo + " found.");
        }
    }

    public void searchByAuthorName() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Author Name:");
        String authorName = input.nextLine();
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (theBooks[i].getAuthorName().equalsIgnoreCase(authorName)) {
                System.out.println(theBooks[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books by " + authorName + " found.");
        }
    }

    public void showAllBooks() {
        if (count == 0) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("Showing all books:");
        for (int i = 0; i < count; i++) {
            System.out.println(theBooks[i]);
            System.out.println("-----------------------------");
        }
    }

    public void upgradeBookQty() {
        System.out.println("Enter Serial No of Book:");
        Scanner input = new Scanner(System.in);
        int sNo = input.nextInt();

        for (int i = 0; i < count; i++) {
            if (theBooks[i].getSNo() == sNo) {
                System.out.println("Enter No of Books to be Added:");
                int addingQty = input.nextInt();
                theBooks[i].setBookQty(theBooks[i].getBookQty() + addingQty);
                theBooks[i].setBookQty(theBooks[i].getBookQtyCopy() + addingQty);
                System.out.println("Quantity upgraded successfully!");
                return;
            }
        }

        System.out.println("No book with Serial No " + sNo + " found.");
    }

	public book checkOutBook(int sNo) {
		// TODO Auto-generated method stub
		return null;
	}
}
