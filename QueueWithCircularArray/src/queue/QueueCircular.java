package queue;

public class QueueCircular {
  public int rear, front, count;
  private int queueMax = 3;
  private int[] queue;

  public QueueCircular() {
    queue = new int[queueMax];
  }

  public void enQueue(int num) {
    if (count == queueMax) {
      growQueue();
    }
    queue[rear] = num;
    rear = advance(rear);
    count += 1;
  }

  public void displayQueue() {
    for (int i=0; i<queueMax; i++) {
      System.out.printf("%d ", queue[i]);
    }
    System.out.println();
  }

  private int advance(int index) {
    if (index == queueMax - 1) {
      return 0;
    } else {
      index ++;
      return index;
    }
  }

  private void growQueue() {
    int newQueueMax = queueMax * 2;
    int[] newQueue = new int[newQueueMax];

    //Method 1
    int newQIndex = 0;
    int oldQPointer = front;
    while (newQIndex < queueMax) {
      if (oldQPointer == queueMax) {oldQPointer = 0;}
      newQueue[newQIndex] = queue[oldQPointer];
      oldQPointer += 1;
      newQIndex += 1;
    }
    queueMax = newQueueMax;
    queue = newQueue;

//    //Method 2
//    if (front < rear) {
//      for (int i=0; i<queueMax; i++) {
//        newQueue[i] = queue[i];
//      }
//    } else {
//      int j = 0;
//      for (int i=front; i<queueMax; i++) {
//        newQueue[j] = queue[i];
//        j += 1;
//      }
//      for (int i=rear; i<front; i++) {
//        newQueue[j] = queue[i];
//        j += 1;
//      }
//    }
//    front = 0;
//    rear = queueMax;
//    queueMax = newQueueMax;
//    queue = newQueue;
  }

}
