package bstWaldo;

public class node {
  String key;
  String val;
  node left, right;
  public node(String key, String val) {
    this.key = key;
    this.val = val;
    left = right = null;
  }
}
