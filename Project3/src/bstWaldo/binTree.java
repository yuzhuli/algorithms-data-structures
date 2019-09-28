package bstWaldo;

public class binTree {
  node root;

  public binTree() {
    root = null;
  }

  public void Load(node[] arr) {
    LoadArray(arr, 0, arr.length - 1);
  }

  private void LoadArray(node[] arr, int l, int r) {
    int mid = (l + r) / 2;
    add(arr[mid].key, arr[mid].val);
    if (l <= mid - 1) {
      LoadArray(arr, l, mid - 1);
    }
    if (mid + 1 <= r) {
      LoadArray(arr, mid + 1, r);
    }
  }

  public int getTreeHeight(node current) {
    if (current == null) {return 0;}
    int leftHeight = 1 + getTreeHeight(current.left);
    int rightHeight = 1+ getTreeHeight(current.right);
    return leftHeight > rightHeight? leftHeight: rightHeight;
  }

  public node FindMax() {
    return FindMaxNode(root);
  }

  private node FindMaxNode(node current) {
    if (current.right == null) {
      return current;
    } else {
      return FindMaxNode(current.right);
    }
  }

  public node FindMin() {
    return FindMinNode(root);
  }

  private node FindMinNode(node current) {
    if (current.left == null) {
      return current;
    } else {
      return FindMinNode(current.left);
    }
  }

  public void drawTreeGraph(int height) {
    for (int i=1; i<=height; i++) {
      double count = (Math.pow(2, height - i) * 2 - 1) /2;
      String whiteSpaces = "";
      for (int j=0; j<count; j++) {
        whiteSpaces += " ";
      }
      System.out.print(whiteSpaces);
      printGivenLevel(root, i);
      System.out.println();
    }
  }

  private void printGivenLevel(node current, int level) {
    if (current == null) {
      return;
    } else if (level == 1) {
      System.out.printf("%s ", current.key);
    } else {
      printGivenLevel(current.left, level -1);
      printGivenLevel(current.right, level -1);
    }
  }

  public String getValue(String key) throws MyException {
    node found = treeSearch(root, key);
    if (found != null)
      return found.val;
    else
      throw new MyException("Key not found");

  }

  public void add(String key, String value) {
    root = treeEnter(root, key, value);
  }

  public node treeEnter(node t, String key, String value) {
    if (t == null) {
      node newOne = new node(key, value);
      return newOne;
    }
    else if (key.compareTo( t.key) < 0) {
      t.left = treeEnter(t.left, key, value);
    }
    else if (key.compareTo( t.key) > 0) {
      t.right = treeEnter(t.right, key, value);
    }
    else {
      t.val = value;
    }
    return t;
  }

  private node treeSearch(node t, String key) {
    if (t==null) return null; //doesn't exist
    if (key.compareTo( t.key) < 0) {
      return treeSearch(t.left, key); //search left
    }
    else if (key.compareTo( t.key) > 0) {
      return treeSearch(t.right, key);
    }
    else {
      return t;
    }
  }

  public void display() {
    inorder_print(root);
  }

  public void inorder_print(node node_ptr) {
    if (node_ptr != null) {
      inorder_print(node_ptr.left);
      System.out.println(node_ptr.key + ": " + node_ptr.val);
      inorder_print(node_ptr.right);
    }
  }

}