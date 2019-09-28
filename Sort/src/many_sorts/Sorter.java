package many_sorts;
import java.util.*;
import java.lang.*;

public class Sorter {
  public static void main(String[] args) {
    // TODO code application logic here
    //Integer[] scores = {20, 10, 30, 32, 12, 12, 12};
    //Integer[] scores = {10,10,10,10,10};
//    ArrayList<Integer> scores = new ArrayList<Integer>();
//    scores.add(20);
//    scores.add(10);
//    scores.add(40);
//    scores.add(30);
    Integer[] scores = {20, 10, 50, 40, 30};
    Sorts inorder = new Sorts();

    inorder.MergeSort(scores);
    System.out.println("Sorted scores: ");

    //for(int i = 0; i < scores.length; i++)
    for(Integer x: scores)
      System.out.println(x);

  }

}
