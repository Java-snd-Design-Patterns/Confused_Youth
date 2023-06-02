package library;

import java.util.Scanner;

public class book {
    private int sNo;
    private String bookName;
    private String authorName;
    private int bookQty;
    private int bookQtyCopy;

    private book(int sNo, String bookName, String authorName, int bookQty) {
        this.sNo = sNo;
        this.bookName = bookName;
        this.authorName = authorName;
        this.bookQty = bookQty;
        this.bookQtyCopy = bookQty;
    }

    public static book createBook() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Serial No of Book:");
        int sNo = input.nextInt();
        input.nextLine();
        System.out.println("Enter Book Name:");
        String bookName = input.nextLine();
        System.out.println("Enter Author Name:");
        String authorName = input.nextLine();
        System.out.println("Enter Quantity of Books:");
        int bookQty = input.nextInt();

        return new book(sNo, bookName, authorName, bookQty);
    }

    // Getters and setters...

    @Override
    public String toString() {
        return "Serial No: " + sNo + "\nBook Name: " + bookName + "\nAuthor Name: " + authorName +
                "\nAvailable Quantity: " + bookQtyCopy + "\nTotal Quantity: " + bookQty;
    }

	public int getBookQtyCopy() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getBookQty() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getSNo() {
		// TODO Auto-generated method stub
		return sNo;
	}

	public void setBookQty(int i) {
		// TODO Auto-generated method stub
		
	}

	public String getAuthorName() {
		// TODO Auto-generated method stub
		return authorName;
	}

	public String getBookName() {
		// TODO Auto-generated method stub
		return bookName;
	}
}
