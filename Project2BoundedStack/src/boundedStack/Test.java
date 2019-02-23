package boundedStack;

public class Test {
  public static void main(String[] args) {
    System.out.println("String Bounded Stack Test");
    BoundedStack<String> stringBS = new BoundedStack<>("S1");
    for (int i=0; i<51; i++) {
      String content = "S" + (stringBS.size + 1);
      stringBS.push(content);
    }
    while (!stringBS.isEmpty()) {
      System.out.println(stringBS.pop());
    }

    System.out.println("Double Bounded Stack Test");
    BoundedStack<Double> doubleBS = new BoundedStack<>(1.0);
    for (int i=0; i<51; i++) {
      Double content = doubleBS.size + 1.0;
      doubleBS.push(content);
    }
    while (!doubleBS.isEmpty()) {
      System.out.println(doubleBS.pop());
    }
  }
}
