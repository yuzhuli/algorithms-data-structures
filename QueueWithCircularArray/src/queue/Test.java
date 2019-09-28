package queue;

public class Test {
  public static void main(String[] args) {
    QueueCircular queue = new QueueCircular();
//    System.out.println(queue.rear);
    queue.enQueue(1);
//    System.out.println(queue.rear);
    queue.enQueue(2);
//    System.out.println(queue.rear);
    queue.enQueue(3);
//    System.out.println(queue.rear);
    queue.enQueue(4);
    queue.displayQueue();
  }
}
