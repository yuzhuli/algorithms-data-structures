package yl.project5;

public class Test {
  public static void main(String[] args) {
    Library library = new Library();
    library.inputBook(1, "aa", "aa", "aa");
    library.inputBook(2, "bb", "bb", "bb");
    library.inputBook(1, "aa", "aa", "aa");
    library.inputBook(3, "cc", "cc", "cc");
    library.inputBook(1, "aa", "aa", "aa");
    library.inputBook(3, "cc", "cc", "cc");
    library.inputBook(2, "bb", "bb", "bb");
    library.bookSort();
    library.displaySorted();
    System.out.println(library.getSortedsize());
    System.out.println(library.getDups());
  }
}
