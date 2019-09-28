class HashChain {
  class Node {
    String key;
    int val;
    Node next;

    Node(String key, int val, Node next) {
      this.key = key;
      this.val = val;
      this.next = next;
    }
  }
  static int numOfBuckets = 5;
  Node[] buckets = new Node[numOfBuckets];

  HashChain() {
    for (int i=0; i<numOfBuckets; i++) {
      buckets[i] = null;
    }
  }

  void insertKeyValuePair(String key, int val) {
    int index = getHashIndex(key.charAt(0));
    Node match = findNodeForKey(key, buckets[index]);
    if (match != null) {
      match.val = val;
    } else {
      Node newNode = new Node(key, val, buckets[index]);
      buckets[index] = newNode;
    }
  }

  int getValueOf(String key) {
    int index = getHashIndex(key.charAt(0));
    Node result = findNodeForKey(key, buckets[index]);
    return result == null? -1 : result.val;
  }

  void displayHashTable() {
    for (int i=0; i<numOfBuckets; i++) {
      System.out.printf("bucket%d: ", i);
      for (Node cur=buckets[i]; cur!=null; cur=cur.next) {
        System.out.printf("%s %d, ", cur.key, cur.val);
      }
      System.out.println();
    }
  }

  Node findNodeForKey(String key, Node head) {
    for (Node cur=head; cur != null; cur=cur.next) {
      if (cur.key.equals(key)) { return cur; }
    }
    return null;
  }

  int getHashIndex(char key) {
    int hashcode = (int) key;
    //System.out.println(hashcode);
    return (int)(hashcode % numOfBuckets);
  }
}

public class HashTest {
  public static void main(String[] args) {
    String testA = "ABCDEFG";
    int i = 0;
    HashChain hash1 = new HashChain();
    while (i < testA.length()) {
      char c = testA.charAt(i);
      hash1.insertKeyValuePair(Character.toString(c), 80+i);
      i ++;
    }
    hash1.displayHashTable();
  }
}

