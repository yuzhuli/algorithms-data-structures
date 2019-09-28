package main;

import java.util.Arrays;

public class KnuthShellSort implements Algorithm {
  long moves = 0;
  long compares = 0;
  long milliseconds = 0;

  @Override
  public String getName() {
    return this.getClass().getSimpleName();
  }

  @Override
  public void sort(Integer[] input) {
    long startTime = System.nanoTime();
    int interval = 1;
    int length = input.length;
    while (interval < length / 3) {
      interval = 3 * interval + 1;
    }
    while (interval > 0) {
      for (int j = interval; j < length; j++) {
        int key = input[j];
        int i = j - interval;
        while (i >= 0 && input[i] > key) {
          input[i + interval] = input[i];
          i -= interval;
          moves += 1;
          compares += 1;
        }
        input[i + interval] = key;
        moves += 1;
      }
      interval = (interval - 1) / 3;
    }
    milliseconds = (System.nanoTime() - startTime) / 1000000;
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
