import java.awt.print.Book;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {

        BookInventorySystem inventorySystem = new BookInventorySystem();

        inventorySystem.addBook(new Book());
        inventorySystem.addBook(new Book());
        inventorySystem.addBook(new Book());

        System.out.println("Initial Inventory:");
        inventorySystem.displayInventory();
        System.out.println();

        System.out.println("Search Results for 'book':");
        ArrayList<Book> searchResults = inventorySystem.searchBook("book");
        for (Book book : searchResults) {
            System.out.println(book);
        }
        System.out.println();

        try {
            inventorySystem.removeBook("Book2");
            System.out.println("Book removed successfully.");
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        try {
            Book updatedBook = new Book();
            inventorySystem.updateBook("Book3", updatedBook);
            System.out.println("Book updated successfully.");
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        System.out.println("Updated Inventory:");
        inventorySystem.displayInventory();
    }
}