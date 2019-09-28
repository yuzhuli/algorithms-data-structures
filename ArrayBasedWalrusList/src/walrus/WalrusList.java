package walrus;

public class WalrusList {

  class Walrus {
    int id;
    int weight;
    int tuskLength;
    Walrus(int id, int weight, int tuskLength) {
      this.id = id;
      this.weight = weight;
      this.tuskLength = tuskLength;
    }
  }

  private int listSize = 0;
  private Walrus[] contents = new Walrus[1];

  public int getFirstWalrusID() {
    return contents[listSize - 1].id;
  }

  public int getFirstWalrusWeight() {
    return contents[listSize - 1].weight;
  }

  public int getFirstWalrusTuskLength() {
    return contents[listSize - 1].tuskLength;
  }

  public int size() {
    return listSize;
  }

  private void extendContentList() {
    Walrus[] newContents;
    newContents = new Walrus[contents.length * 2];
    System.arraycopy(contents, 0, newContents, 0, listSize);
    contents = newContents;
  }

  public void addLast(int id, int weight, int tuskLength) {
    Walrus walrus = new Walrus(id, weight, tuskLength);
    if (listSize == contents.length) {
      extendContentList();
    }
    contents[listSize] = walrus;
    listSize += 1;
  }

  public void addFirst(int id, int weight, int tuskLength) {
    Walrus walrus = new Walrus(id, weight, tuskLength);
    if (listSize == contents.length) {
      extendContentList();
    }
    for (int i=listSize-1; i>=0; i--) {
      contents[i + 1] = contents[i];
    }
    contents[0] = walrus;
    listSize += 1;
  }

  public int totalWeigtht() {
    int total = 0;
    for (int i=0; i<listSize; i++) {
      total += contents[i].weight;
    }
    return total;
  }

  public void printWalrusList() {
    for (int i=0; i<listSize; i++) {
      System.out.printf("id %d, ", contents[i].id);
    }
    System.out.println();
  }
}
