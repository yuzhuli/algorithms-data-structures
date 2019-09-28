package doubleLinkedQueue;

public class DLQueue<E> {
  class DLNode<E> {
    E content;
    DLNode next;
    DLNode prev;
    DLNode(E content, DLNode next, DLNode prev) {
      this.content = content;
      this.next = next;
      this.prev = prev;
    }
  }

  DLNode head;
  DLNode tail;
  int size;

  DLQueue(E content) {
    DLNode newNode = new DLNode(content, null, null);
    head = newNode;
    tail = newNode;
    size += 1;
    System.out.printf("%s is added. Queue created%n", head.content);
  }

  public void push_tail(E x) {
    DLNode newNode = new DLNode(x, null, tail);
    tail.next = newNode;
    tail = newNode;
    size += 1;
    System.out.printf("%s added at tail%n", tail.content);
  }

  public void push_front(E x) {
    DLNode newNode = new DLNode(x, head, null);
    head.prev = newNode;
    head = newNode;
    size += 1;
    System.out.printf("%s added at front%n", head.content);
  }

  public void pop_front() {
    if (size == 0) {
      System.out.println("Queue is empty. Cannot delete");
    }
    if (size == 1) {
      System.out.printf("%s deleted from front%n", head.content);
      head = null;
      tail = null;
      size = 0;
    }
    if (size > 1){
      System.out.printf("%s deleted from front%n", head.content);
      head.next.prev = null;
      head = head.next;
      size -= 1;
    }
  }

  public void pop_tail() {
    if (size == 0) {
      System.out.println("Queue is empty. Cannot delete");
    }
    if (size == 1) {
      System.out.printf("%s deleted from tail%n", tail.content);
      head = null;
      tail = null;
      size = 0;
    }
    if (size > 1){
      System.out.printf("%s deleted from tail%n", tail.content);
      tail.prev.next = null;
      tail = tail.prev;
      size -= 1;
    }
  }

  public boolean isEmpty() {return size == 0;}

  public void displayQueue() {
    System.out.print("Queue: ");
    DLNode p = head;
    while (p != null) {
      System.out.printf("%s, ", p.content);
      p = p.next;
    }
    System.out.println("Queue Ends");
  }
}
