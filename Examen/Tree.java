public class Tree {
  
  public Node _root;
  
  public Tree() {
    _root = null;
  }
  
  public void insert(Node n) {
    if (_root == null) {
      _root = n;
    } else {
      _root.insert(n);
    }
  }
  
  public String getMean(String word) {
    String mean;
    if (_root.data.equals(word)) {
      mean = _root.mean;
    } else {
      mean = _root.getMean(word);
    }
    return mean;
  }
  
  public void show() {
    _root.show();
  }
  
}