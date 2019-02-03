package waldo;

public class LinkedList {

  class Node {
    String name;
    int passportNum;
    String destination;
    Node next;

    Node(String name, int passportNum, String destination, Node next) {
      this.name = name;
      this.passportNum = passportNum;
      this.destination = destination;
      this.next = next;
    }
  }

  Node firstNode;

  public void addFirst(String name, int passportNum, String destination) {
    firstNode = new Node(name, passportNum,destination, firstNode);
  }

  public int size() {
    return findSizeRecursively(this.firstNode);
  }

  public int findSizeRecursively(Node currentNode) {
    if (currentNode.next == null) {
      return 1;
    } else {
      return 1 + findSizeRecursively(currentNode.next);
    }
  }

  public String findNode(String name) {
    return findNodeRecursively(name, this.firstNode);
  }

  public String findNodeRecursively(String name, Node currentNode) {
    if (name.equals(currentNode.name)) {
      return currentNode.destination;
    }
    if (currentNode.next != null) {
      return findNodeRecursively(name, currentNode.next);
    } else {
      return "No such tourist found";
    }
  }
}
