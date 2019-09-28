package main;

public interface Algorithm {
  public String getName();
  public void sort(Integer[] input);
  public long getMoves();
  public long getCompares();
  public long getMilliseconds();
}
