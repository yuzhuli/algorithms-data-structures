package solutionsFromClass;

import java.util.Arrays;

public class JQueue {
  public static void main(String[] args) {
    AQueue atm = new AQueue();
    atm.enQueue(1F);

    atm.enQueue(2F);

    atm.enQueue(3F);

    atm.enQueue(4F);

    atm.deQueue();

    atm.enQueue(5F);

    atm.enQueue(6F);

    atm.enQueue(7F);

    for(int i = 0; i < 6; i++)
    {
      System.out.println(atm.peek());
      atm.deQueue();
    }

  }
}
