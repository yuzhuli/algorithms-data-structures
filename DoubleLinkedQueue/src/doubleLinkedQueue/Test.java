package doubleLinkedQueue;

public class Test {
//  front is the head of a linked list
  public static void main(String[] args) {
    DLQueue queue = new DLQueue(0);
    //Push Front
    queue.push_front(1);
    queue.push_front(2);
    queue.displayQueue();
    // Push Tail
    queue.push_tail(3);
    queue.push_tail(4);
    queue.displayQueue();
    //Pop Front
    queue.pop_front();
    queue.displayQueue();
    //Pop Tail
    queue.pop_tail();
    queue.displayQueue();
  }
}
