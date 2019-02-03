package waldo;

public class Testing {
  public static void main(String[] args) {
    LinkedList tourist = new LinkedList();
    tourist.addFirst("Waldo", 12345, "Prague");
    tourist.addFirst("Mark", 12346, "New York");
    tourist.addFirst("Rachel", 12347, "Paris");
    String destination1 = tourist.findNode("Waldo");
    String destination2 = tourist.findNode("Mark");
    String destination3 = tourist.findNode("Rachel");
    String destination4 = tourist.findNode("Li");
    System.out.printf("Waldo's destination: %s%n", destination1);
    System.out.printf("Mark's destination: %s%n", destination2);
    System.out.printf("Rachel's destination: %s%n", destination3);
    System.out.printf("Yuzhu's destination: %s%n", destination4);
    int totalSize = tourist.size();
    System.out.printf("List Size: %d%n", totalSize);
  }
}
