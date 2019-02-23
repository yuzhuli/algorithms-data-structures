package boundedStack;

public class BoundedStack <E> {
  class Node {
    E content;
    Node next;
    Node(E content, Node next) {
      this.content = content;
      this.next = next;
    }
  }

  private Node head;
  int size;
  static int limit=50;

  BoundedStack(E content) {
    head = new Node(content, null);
    size += 1;
  }

  public boolean isEmpty() { return size == 0; }
  boolean isFull() { return size == limit; }

  private void overflow() {
    Node currentNode = head;
    while (currentNode.next.next != null) {
      currentNode = currentNode.next;
    }
    currentNode.next = null;
    size -= 1;
  }

  /*
  private void recursivelyRemove(Node currentNode) {
    if (currentNode.next.next != null) {
      recursivelyRemove(currentNode.next);
    } else {
      currentNode.next = null;
    }
  }
  */

  public void push(E content) {
    if (isFull()) {
      overflow();
    }
    head = new Node(content, head);
    size += 1;
  }

  public E pop() {
    E content = head.content;
    head = head.next;
    size -= 1;
    return content;
  }

}
