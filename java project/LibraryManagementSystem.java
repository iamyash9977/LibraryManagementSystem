
import java.util.ArrayList;
import java.util.Scanner;

class Book{
    private String title;
    private String author;
    private boolean isAvailable;

    public String toString(){
        return "Book [title="+ title +", author=" + author +", isAvailable"+ isAvailable + "]";
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author=author;
    }

    public boolean isAvailable(){
        return isAvailable;
    }
    public Book(String title, String author, boolean isAvailable){
        super();
        this.title=title;
        this.author=author;
        this.isAvailable=isAvailable;
    }

    public void setAvailable(boolean isAvailable){
        this.isAvailable = isAvailable;
    }

}

class Library{
    private ArrayList<Book> books=new ArrayList<>();
    public void addBook(String title, String author) {
        Book newBook=new Book(title,author,true);
        books.add(newBook);
        System.out.println("Book added successfully");
    }

    public void displayBook(){
        if(books.isEmpty()){
            System.out.println("No Books Available in the library");
        }else{
            System.out.println("Available Books in Library");
            for(Book book:books){
                System.out.println(book);
            }
        }
    }
    public void borrowBook(String title){
        for(Book book:books){
            if(book.getTitle().equalsIgnoreCase(title)) {
                if(book.isAvailable()){
                    book.setAvailable(false);
                    System.out.println("You have sucessfully Borrowed" + title);
                }else{
                    System.out.println("Sorry, The book is currenlty borrowed");
                }
                return;

            }
        }
        System.out.println("Book Not found in library");

    }
    public void returnBook(String title) {
    for(Book book:books){
        if(book.getTitle().equalsIgnoreCase(title)){
            if(!book.isAvailable()){
            book.setAvailable(true);
            System.out.println("You have Successfully retunrd " + title);
            }else{
                System.out.println("This book wasn't borrowed:");
            }
            return;
        }
    }
    System.out.println("book not found in the library:");
    }
     
}

public class LibraryManagementSystem {
    private static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args){
        Library library = new Library();
        boolean exit=false;
        while(!exit){
            System.out.println("\n===Libraru Management System====");
            System.out.println("1. Add a new Book ");
            System.out.println("2. Display All Books ");
            System.out.println("3. Borrow a Book ");
            System.out.println("4. Return a Book ");
            System.out.println("5. Exit. ");
            System.out.println("Enter Your Choice ");

            int choice=scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addBookToLibrary(library);
                    break;

                case 2:
                    library.displayBook();
                    break;
            
                case 3:
                    borrowBookFromLibrary(library);
                    break;

                case 4:
                    returnBookToLibrary(library);
                    break;

                case 5:
                    exit=true;
                    System.out.println("Exiting the library management system... Good bye");
                    break;

                default:
                    System.out.println("Invalid choice try again later");
                    break;
            }

        }

    }
    private static void addBookToLibrary(Library library) {
        System.out.println("Enter the title of the book");
        String title=scanner.nextLine();
        System.out.println("Enter the author of the book");
        String author=scanner.nextLine();
        library.addBook(title, author);
    }
    private static void borrowBookFromLibrary(Library library){
        System.out.println("Enter the title of the book to borrow");
        String title=scanner.nextLine();
        library.borrowBook(title);
    }
    private static void returnBookToLibrary(Library library){
        System.out.println("Enter the title of the book to return");
        String title=scanner.nextLine();
        library.returnBook(title);
    }


}