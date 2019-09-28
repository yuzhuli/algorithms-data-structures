package main;

import java.util.*;

public class AdjMatrixGraph implements Graph {
  class Node {
    String name;
    int index;
    Node(String name, int index) {
      this.name = name;
      this.index = index;
    }
  }

  static int MAX = 8;
  int size = 0;
  Hashtable<String, Node> nodes;
  boolean[][] adjMatrix = new boolean[MAX][MAX];

  @Override
  public void addNodes(String[] names) {
    for (String name: names) {
      Node node = new Node(name, size);
      nodes.put(name, node);
      size += 1;
    }
  }

  @Override
  public void addEdge(String sourceName, String destName) {
    int sourceIndex = getIndexOf(sourceName);
    int destIndex = getIndexOf(destName);
    adjMatrix[sourceIndex][destIndex] = true;
  }

  @Override
  public HashSet<Integer> getNeighbors(String name) {
    int sourceIndex = getIndexOf(name);
    HashSet<Integer> neighbors = new HashSet<Integer>();
    for (int i = 0; i < size; i++) {
      if (adjMatrix[sourceIndex][i]) {
        neighbors.add(i);
      }
    }
    return neighbors;
  }

  @Override
  public int getIndexOf(String name) {
    return nodes.get(name).index;
  }

  @Override
  public String getNameAtIndex(int target) {
    Iterator<Map.Entry<String, Node>> itr = nodes.entrySet().iterator();
    while (itr.hasNext()) {
      Map.Entry<String, Node> entry = itr.next();
      if (entry.getValue().index == target) {
        return entry.getKey();
      }
    }
    return null;
  }

  @Override
  public void bfsTraverse(String name) {
    int sourceIndex = getIndexOf(name);
  }

  @Override
  public void dfsTraverse(String name) {
    int sourceIndex = getIndexOf(name);

  }

  void recursiveDFS(boolean[] visited, int index) {

  }

  @Override
  public boolean areOnSamePath(String sourceName, String destName) {
    return false;
  }
}
