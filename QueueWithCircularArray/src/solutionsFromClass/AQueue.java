package solutionsFromClass;

public class AQueue {
  private int Front, Rear, Count;
  private int QueueMax = 5;
  private float[] info;
  public AQueue()
  {
    info = new float[QueueMax];
    Front = 0;
    Rear = QueueMax -1;
    Count = 0;
  }
  public void enQueue(float Item)
  {
    if (Count == QueueMax)
    {

      resize(Count * 2);
    }

    Rear = Advance(Rear);
    info[Rear] = Item;
    Count++;

  }
  public void deQueue()
  {
    if (Count == 0)
    {
      System.out.println("ERROR: Cannot remove -- queue is empty");
    }
    else
    {
      Front = Advance(Front);
      Count--;
    }
  }
  public float peek()
  {
    return info[Front];
  }
  public boolean isEmpty()
  {
    if (Count == 0)
      return true;
    else
      return false;
  }

  private int Advance(int Index)
  {
    Index++;
    if (Index == QueueMax)
      Index = 0;
//    System.out.println("Front: " + Front + "Rear: " + Rear);
    return Index;
  }
  private void resize(int capacity)
  {
    float[] a = new float[capacity];
    if(Front < Rear)
    {
      System.arraycopy(info, 0, a, 0, Count);
    }
    else
    {
      int rhs = Count - Front;
      int lhs = Rear + 1;
      System.arraycopy(info, Front, a, 0, rhs);
      System.arraycopy(info, 0, a, rhs, lhs);
      Front = 0;
      Rear = Count - 1;
//      System.arraycopy(info, 0, a, 0, lhs);
//      System.arraycopy(info, Front, a, capacity - rhs , rhs );
//      Front = capacity -rhs;
    }


    QueueMax = capacity;
    info = a;

  }
}
