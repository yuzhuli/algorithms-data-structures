package yl.project5;
import java.util.ArrayList;

public class Library {
  private int sortedsize;
  private int dups;
  ArrayList<Book> books = new ArrayList<Book>();

  void displayAll() {
    for (Book b : books) {
      System.out.printf("%s, ", b.toString());
    }
    System.out.println();
  }

  void displaySorted() {
    for (int i = 0; i < sortedsize; i++) {
      System.out.printf("%s, ", books.get(i).toString());
    }
    System.out.println();
  }

  void inputBook(int isbn, String title, String author, String subject) {
    Book book = new Book(isbn, title, author, subject);
    books.add(book);
  }

  int getSortedsize() {
    return sortedsize;
  }

  int getDups() {
    return dups;
  }

  void bookSort() {
    sortedsize = mergeSort(books);
    dups = books.size() - sortedsize;
  }

  private int mergeSort(ArrayList<Book> cur) {
    // if there is only one book, no need to divide
    if (cur.size() == 1) { return 1; }
    // initialize variables
    int[] validSizes =new int[2];
    ArrayList<ArrayList<Book>> bookListsToMerge = new ArrayList<ArrayList<Book>>();
    // copy left and right side to new ArrayList
    int halflength = cur.size() / 2;
    ArrayList<Book> left = new ArrayList<>();
    copy(cur, left, 0, halflength);
    ArrayList<Book> right = new ArrayList<>();
    copy(cur, right, halflength, cur.size());
    // sort left and right separately and get the number of valid elements for each of them
    validSizes[0] = mergeSort(left);
    validSizes[1] = mergeSort(right);
    bookListsToMerge.add(left);
    bookListsToMerge.add(right);
    // merge left and right and return the valid size for the merged list
    return merge(cur, bookListsToMerge, validSizes);
  }

  private int merge(ArrayList<Book> destinationList, ArrayList<ArrayList<Book>> bookListsToMerge, int[] validSizes) {
    // initialize variables
    int destinationIndex = 0;
    int[] indices = {0, 0};
    Book candidate;
    int result;
    // start merging
    while (true) {
      // find candidate
      result = findBookToInsert(bookListsToMerge, indices, validSizes);
      // nothing to merge. all elements of left and right are visited.
      if (result == -1) {
        break;
        // merge element from the left
      } else if (result == 0) {
        candidate = bookListsToMerge.get(0).get(indices[0]);
        if (mergeOneBook(destinationList, destinationIndex, candidate)) {
          destinationIndex += 1;
        }
        indices[0] += 1;
      } else {
        // merge element from the right
        candidate = bookListsToMerge.get(1).get(indices[1]);
        if (mergeOneBook(destinationList, destinationIndex, candidate)) {
          destinationIndex += 1;
        }
        indices[1] += 1;
      }
    }
    // return the number of valid elements in the destination ArrayList
    return destinationIndex;
  }

  private int findBookToInsert(ArrayList<ArrayList<Book>> bookListsToMerge, int[] indices, int[] validSizes) {
    // both of the indices are larger than their valid size; nothing to merge;
    if (indices[0] >= validSizes[0] && indices[1] >= validSizes[1]) {
      return -1;
      // left index is larger than its valid size; merge right;
    } else if (indices[0] >= validSizes[0]) {
      return 1;
      // right index is larger than its valid size; merge left;
    } else  if (indices[1] >= validSizes[1]) {
      return 0;
    } else {
      // both of left and right have elements to be checked. find the smaller one;
      Book lCandidate = bookListsToMerge.get(0).get(indices[0]);
      Book rCandidate = bookListsToMerge.get(1).get(indices[1]);
      if (lCandidate.compareTo(rCandidate) <= 0) {
        return 0;
      } else {
        return 1;
      }
    }
  }

  private Boolean mergeOneBook(ArrayList<Book> destinationList, int destinationIndex, Book candidate) {
    // if this is the first element to merge OR it is larger than the previously merged element, then merge it;
    if (destinationIndex == 0 || candidate.compareTo(destinationList.get(destinationIndex - 1)) > 0) {
      //destinationList.add(destinationIndex, candidate);
      destinationList.set(destinationIndex, candidate);
      return true;
    }
    return false;
  }

  private void copy(ArrayList<Book> sourceList, ArrayList<Book> destList, int start, int end) {
    for (int i = start; i < end ; i++) {
      destList.add(sourceList.get(i));
    }
  }
}
