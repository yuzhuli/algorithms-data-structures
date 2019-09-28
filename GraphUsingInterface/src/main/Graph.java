package main;

import java.util.*;

public interface Graph {
  public void addNodes(String[] names);
  public void addEdge(String sourceName, String destName);
  public HashSet<Integer> getNeighbors(String name);
  public int getIndexOf(String name);
  public String getNameAtIndex(int target);
  public void bfsTraverse(String name);
  public void dfsTraverse(String name);
  public boolean areOnSamePath(String sourceName, String destName);
}
