package main;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AlgorithmTest {
  String s1 = "ALGORITHM";
  String s2 = "MOVES";
  String s3 = "COMPARES";
  String s4 = "MILLISECONDS";

  public void testRandomUniqueIntegers(Algorithm[] algorithms) {
    System.out.println("======================");
    System.out.println("Unsorted Random Unique");
    System.out.println("======================");
    int[] testSizes = {100, 1000, 10000, 100000};
    for (int n: testSizes) {
      System.out.printf("%nN = %d%n%n", n);
      System.out.printf("%15s %15s %15s %15s%n", s1, s2, s3, s4);
      ArrayList<Integer> numbersToSort = getRandomUniqueIntegers(n);
      for (Algorithm algo: algorithms) {
        algo.sort(numbersToSort.toArray(new Integer[n]));
        String name = algo.getName();
        long compares = algo.getCompares();
        long moves = algo.getMoves();
        long milliseconds = algo.getMilliseconds();
        System.out.printf("%15s %15s %15d %15d%n", name, compares, moves, milliseconds);
      }
    }
  }

  public void testReverseSortedUniqueIntegers(Algorithm[] algorithms) {
    System.out.println("======================");
    System.out.println("Reverse Sorted Unique");
    System.out.println("======================");
    int[] testSizes = {100, 1000, 10000, 100000};
    for (int n: testSizes) {
      System.out.printf("%nN = %d%n%n", n);
      System.out.printf("%15s %15s %15s %15s%n", s1, s2, s3, s4);
      ArrayList<Integer> numbersToSort = getReverseSortedUniqueIntegers(n);
      for (Algorithm algo: algorithms) {
        algo.sort(numbersToSort.toArray(new Integer[n]));
        String name = algo.getName();
        long compares = algo.getCompares();
        long moves = algo.getMoves();
        long milliseconds = algo.getMilliseconds();
        System.out.printf("%15s %15s %15d %15d%n", name, compares, moves, milliseconds);
      }
    }
  }

  private ArrayList<Integer> getRandomUniqueIntegers(int n) {
    ArrayList<Integer> a = new ArrayList<>(n);
    for (int i = 0; i <= n; i++){
      a.add(i);
    }
    Collections.shuffle(a);
    return a;
  }

  private ArrayList<Integer> getReverseSortedUniqueIntegers(int n) {
    ArrayList<Integer> a = new ArrayList<>(n);
    for (int i = 0; i <= n; i++){
      a.add(i);
    }
    Collections.reverse(a);
    return a;
  }

  public static void main(String[] args) {
    Algorithm shellAlgo = new KnuthShellSort();
    Algorithm insertionAlgo = new InsertionSort();
    Algorithm[] algoArray = {shellAlgo, insertionAlgo};
    AlgorithmTest test1 = new AlgorithmTest();
    test1.testRandomUniqueIntegers(algoArray);
    test1.testReverseSortedUniqueIntegers(algoArray);
  }
}
