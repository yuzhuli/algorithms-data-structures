package main;

import java.util.Arrays;

class InsertionSort implements Algorithm {
  long moves = 0;
  long compares = 0;
  long milliseconds = 0;

  @Override
  public void sort(Integer[] input) {
    long startTime = System.nanoTime();
    int arrayLength = input.length;
    for ( int j = 1; j < arrayLength; j++) {
      int i = j - 1;
      int key = input[j];
      while (i >= 0 && input[i] > key) {
        input[i + 1] = input[i];
        i -= 1;
        compares += 1;
        moves += 1;
      }
      input[i + 1] = key;
      moves += 1;
    }
    milliseconds = (System.nanoTime() - startTime) / 1000000;
  }

  @Override
  public String getName() {
    return this.getClass().getSimpleName();
  }

  @Override
  public long getMoves() {
    return this.moves;
  }

  @Override
  public long getCompares() {
    return this.compares;
  }

  @Override
  public long getMilliseconds() {
    return milliseconds;
  }

}