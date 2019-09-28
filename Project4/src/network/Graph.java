package network;
import java.util.HashSet;

public class Graph {
  int nodeCount;
  int maxSize = 8;
  boolean[][] edgeMatrix = new boolean[maxSize][maxSize];
  Node[] nodes = new Node[maxSize];

  public void addNode(String[] names) {
    for (String name: names) {
      Node newNode = new Node(name, nodeCount);
      nodes[nodeCount] = newNode;
      nodeCount += 1;
      for (int i=0; i<nodeCount; i++) {
        edgeMatrix[newNode.id][i] = false;
        edgeMatrix[i][newNode.id] = false;
      }
    }
  }

  public void addEdge(int source, int target) {
    edgeMatrix[source][target] = true;
  }

  public void removeEdge(int source, int target) {
    edgeMatrix[source][target] = false;
  }

  public boolean isEdgeExist(int source, int target) {
    return edgeMatrix[source][target];
  }

  public HashSet<Integer> getNeighborsOf(Node node) {
    HashSet<Integer> neighbors = new HashSet<Integer>();
    for (int i = 0; i < nodeCount; i++) {
      if (edgeMatrix[node.id][i]) {
        neighbors.add(i);
      }
    }
    return neighbors;
  }

  public boolean areAllEven() {
    for (int row = 0; row < nodeCount; row++) {
      int count = 0;
      for (int col = 0; col < nodeCount; col++) {
        if (edgeMatrix[row][col]) {
          count += 1;
        }
      }
      if (count % 2 != 0) {
        return false;
      }
    }
    return true;
  }

  public void displayGraph() {
    for (Node node: nodes) {
      if (node == null) return;
      System.out.printf("%s: ", node.name);
      HashSet<Integer> allNeighbors = getNeighborsOf(node);
      for (Integer id : allNeighbors) {
        String nodeName = nodes[id].name;
        System.out.printf("%s ", nodeName);
      }
      System.out.printf("(%d edges)%n", allNeighbors.size());
    }
  }

}
