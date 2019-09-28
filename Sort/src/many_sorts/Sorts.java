package many_sorts;
import java.util.*;
import java.lang.*;
public class Sorts {

  void MergeSort(Integer[] cur)
  {
    if (cur.length > 1) {
      int n1 = cur.length/2;
      int n2 = cur.length - n1;
      Integer[] left = new Integer[n1];
      Integer[] right = new Integer[n2];
      System.arraycopy(cur, 0, left, 0, n1);
      System.arraycopy(cur, n1, right, 0, n2);
      MergeSort(left);
      MergeSort(right);
      Merge(cur, left, right);
    }
  }

  void display(Integer[] arr) {
    for(Integer x: arr) {
      System.out.printf("%d ", x);
    }
  }

  public void Merge(Integer[] cur, Integer[] left, Integer[] right) {
    int p, p1, p2;
    p = p1 = p2 = 0;
//    System.out.println("-------------");
//    System.out.print("left: ");
//    display(left);
//    System.out.println();
//    System.out.print("right: ");
//    display(right);
//    System.out.println();
//    System.out.print("v: ");
//    display(arr);
//    System.out.println();

    while (p1 < left.length && p2 < right.length) {
      if(left[p1] < right[p2] ) {
        cur[p++]= left[p1++];
      }
      else {
        cur[p++]= right[p2++];
      }
    }
    while (p1 < left.length) {
      cur[p++]= left[p1++];
    }
    while (p2 < right.length) {
      cur[p++]=right[p2++];
    }
//    System.out.println("After");
//    System.out.print("left: ");
//    display(left);
//    System.out.println();
//    System.out.print("right: ");
//    display(right);
//    System.out.println();
//    System.out.print("v: ");
//    display(arr);
//    System.out.println();
  }

}
