package yl.project5;

public class Book implements Comparable<Book> {
  int isbn;
  String title;
  String author;
  String subject;

  Book(int isbn, String title, String author, String subject) {
    this.isbn = isbn;
    this.title = title;
    this.author = author;
    this.subject = subject;
  }

  public String toString() {
    String result = "";
    result += "ISBN" + isbn + "/";
    result += title + "/";
    result += author + "/";
    result += subject;
    return result;
  }

  @Override
  public int compareTo(Book book) {
    return this.isbn - book.isbn;
  }
}
