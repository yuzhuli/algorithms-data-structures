package binarySearchTree;

public class MyBSTmap {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    binTree<Integer> addressBook = new binTree<>();
    addressBook.add("Joe", 555);
    addressBook.add("Kim", 777);
    addressBook.add("Dan", 999);
    addressBook.add("Dan", 888);
    System.out.println(addressBook.root.key);
    addressBook.display();

//    try
//    {
//      System.out.println("Searching for  Dan" + addressBook.getValue("Dan"));
//    }
//    catch (MyException e)
//    {
//      System.out.println(e.getMessage());
//    }
  }

}
class MyException extends Exception {
  public MyException(String msg) {
    super(msg);
  }
}
class binTree <Item>
{

  class node {
    String key;
    Item val;
    node left, right;
  };
  node root;
  public binTree()
  {
    root = null;
  }

  public Item getValue(String key) throws MyException
  {
    node found = treeSearch(root, key);
    if (found != null)
      return found.val;
    else
      throw new MyException("Key not found");

  }

  public void add(String key, Item value)
  {
    root = treeEnter(root, key, value);
  }


  private node treeSearch(node t, String key)
  {

    if (t==null) return null; //doesn't exist
    if (key.compareTo( t.key) < 0)        //found match
    {
      System.out.println("Searching left");
      return treeSearch(t.left, key); //search left
    }

    else if (key.compareTo( t.key) > 0)
    {

      System.out.println( "Searching right");
      return treeSearch(t.right, key);
    }
    else
    {

      return t;
    }
  }

  public node treeEnter(node t, String key, Item value)
  {

    if (t == null)
    {

      node newOne = new node();
      newOne.key = key;
      newOne.val = value;
      newOne.left = newOne.right = null;
      return newOne;
    }
    else if (key.compareTo( t.key) < 0)
    {

      t.left = treeEnter(t.left, key, value);
    }
    else if (key.compareTo( t.key) > 0)
    {

      t.right = treeEnter(t.right, key, value);
    }
    else
    {
      t.val = value;
    }
    return t;
  }
  public void display()
  {
    inorder_print(root);
  }
  public void preorder_print(node node_ptr)
  {
    if (node_ptr != null)
    {
      System.out.println(node_ptr.key + ": " + node_ptr.val);
      preorder_print(node_ptr.left);
      preorder_print(node_ptr.right);
    }
  }

  public void postorder_print(node node_ptr)
  {
    if (node_ptr != null)
    {
      postorder_print(node_ptr.left);
      postorder_print(node_ptr.right);
      System.out.println(node_ptr.key + ": " + node_ptr.val);
    }
  }

  public void inorder_print(node node_ptr)
  {
    if (node_ptr != null)
    {
      inorder_print(node_ptr.left);
      System.out.println(node_ptr.key + ": " + node_ptr.val);
      inorder_print(node_ptr.right);
    }
  }
}