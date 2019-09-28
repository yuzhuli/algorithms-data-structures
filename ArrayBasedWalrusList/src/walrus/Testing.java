package walrus;

public class Testing {
  public static void main(String[] args) {
    WalrusList walrusList = new WalrusList();
    walrusList.addFirst(1, 100, 100);
    walrusList.printWalrusList();
    walrusList.addFirst(2, 200, 200);
    walrusList.printWalrusList();
    walrusList.addLast(3, 300, 300);
    walrusList.printWalrusList();
    walrusList.addLast(4, 400, 400);
    walrusList.printWalrusList();
  }
}
