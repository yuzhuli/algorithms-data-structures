package network;

public class Test {
  static public void main(String[] args) {
    //graphA
    System.out.println("graphA");
    Graph graphA = new Graph();
    String[] names = {"A", "B", "C", "D", "E", "F"};
    graphA.addNode(names);
    graphA.addEdge(0, 1);
    graphA.addEdge(0, 2);
    graphA.addEdge(1, 0);
    graphA.addEdge(1, 3);
    graphA.addEdge(2, 0);
    graphA.addEdge(2, 3);
    graphA.addEdge(3, 1);
    graphA.addEdge(3, 2);
    graphA.addEdge(3, 4);
    graphA.addEdge(3, 5);
    graphA.addEdge(4, 3);
    graphA.addEdge(4, 5);
    graphA.addEdge(5, 3);
    graphA.addEdge(5, 4);
    System.out.printf("Are all even? %s%n", graphA.areAllEven());
    graphA.displayGraph();
    System.out.println();

    //graphB
    System.out.println("graphB");
    Graph graphB = new Graph();
    String[] names2 = {"M", "N", "O", "P", "Q"};
    graphB.addNode(names2);
    graphB.addEdge(0, 1);
    graphB.addEdge(0, 2);
    graphB.addEdge(1, 0);
    graphB.addEdge(1, 2);
    graphB.addEdge(2, 0);
    graphB.addEdge(2, 1);
    graphB.addEdge(3, 4);
    graphB.addEdge(4, 3);
    System.out.printf("Are all even? %s%n", graphB.areAllEven());
    graphB.displayGraph();
  }
}
