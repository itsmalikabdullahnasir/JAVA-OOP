import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Iterator;

public class BookInventorySystem {
    private ArrayList<Book> inventory;
    private final String FILENAME = "inventory.txt"; // File name for storing inventory data

    public BookInventorySystem() {
        inventory = new ArrayList<>();
        // Load inventory data from file during application startup
        loadInventoryFromFile();
    }

    private void loadInventoryFromFile() {
    }

    // Other methods (addBook, removeBook, updateBook, searchBook, loadInventoryFromFile, saveInventoryToFile, exit)

    // Method to display all books in the inventory using iterator
    public void displayInventory() {
        Iterator<Book> iterator = new InventoryIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void addBook(Book book) {
        inventory.add(book);
    }

    public void removeBook(String book2) {
    }

    public ArrayList<Book> searchBook(String title) {
        ArrayList<Book> foundBooks = new ArrayList<>();
        // Search logic here...
        return foundBooks;
    }

    public void updateBook(String book3, Book updatedBook) {
    }

    // Inner class implementing Iterator for iterating over the inventory
    private class InventoryIterator implements Iterator<Book> {
        private int index;

        public InventoryIterator() {
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < inventory.size();
        }

        @Override
        public Book next() {
            if (hasNext()) {
                Book book = inventory.get(index);
                index++;
                return book;
            } else {
                throw new IndexOutOfBoundsException("No more elements in the inventory.");
            }
        }
    }
}
