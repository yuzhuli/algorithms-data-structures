package bstWaldo;

public class MyBSTmap {

  public static void main(String[] args) {
    //Create the arr
    node[] arr = new node[7];
    arr[0] = new node("AA", "destination AA");
    arr[1] = new node("BB", "destination BB");
    arr[2] = new node("CC", "destination CC");
    arr[3] = new node("DD", "destination DD");
    arr[4] = new node("EE", "destination EE");
    arr[5] = new node("FF", "destination FF");
    arr[6] = new node("Waldo", "destination Waldo");

    //Load BST from arr
    binTree touristTree = new binTree();
    touristTree.Load(arr);

    //Verify tree height
    int treeHeight = touristTree.getTreeHeight(touristTree.root);
    System.out.println();
    System.out.println("Tree Height is: " + treeHeight);
    System.out.println();

    //Draw Tree Graph and do an in-order print
    System.out.println("An ugly graph of the tree: ");
    touristTree.drawTreeGraph(treeHeight);
    System.out.println();
    System.out.println("An in-order print of the tree is: ");
    touristTree.display();
    System.out.println();

    //Find Min and Max tourist
    System.out.println("Min Tourist: " + touristTree.FindMin().key);
    System.out.println("Max Tourist: " + touristTree.FindMax().key);
    System.out.println();

    //Search for Waldo
    try {
      System.out.println("Searching for Waldo: " + touristTree.getValue("Waldo"));
    }
    catch (MyException e) {
      System.out.println(e.getMessage());
    }

    //Search for some non-existing tourist
    try {
      System.out.println("Searching for Yuzhu: " + touristTree.getValue("Yuzhu"));
    }
    catch (MyException e) {
      System.out.println("Searching for Yuzhu: " + e.getMessage());
    }
  }
}