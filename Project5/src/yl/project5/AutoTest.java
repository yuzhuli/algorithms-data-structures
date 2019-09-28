package yl.project5;

import java.util.Random;

public class AutoTest {

  static public void main(String[] args) {
    AutoTest test = new AutoTest();
    // Test for even number of books in the library.
    test.runTest(10);
    // Test for odd number of books in the library.
    test.runTest(9);
  }

  void runTest(int size) {
    Library library = new Library();
    putBooksIntoLibrary(library, size);
    System.out.println("------TEST-----");
    System.out.println("Before Sort: ");
    // Display all books before sorting.
    library.displayAll();
    library.bookSort();
    System.out.println("After Sort: ");
    // Display only the non-duplicate books in sorted order.
    library.displaySorted();
    System.out.printf("Size of sorted array: %d%n", library.getSortedsize());
    System.out.printf("Number of duplicates: %d%n%n", library.getDups());
  }

  void putBooksIntoLibrary(Library library, int size) {
    for (int i = 0; i < size; i++) {
      // By setting the range of ISBN number smaller than library size,
      // we make sure there will be duplicates.
      int isbn = generateRandomInt(size - 5);
      String s = Integer.toString(isbn);
      library.inputBook(isbn, s, s, s);
    }
  }

  int generateRandomInt(int bound) {
    Random generator = new Random();
    return generator.nextInt(bound);
  }
}
