public class Node {
  
  public String data;
  public Node next;
  
  public String mean;
  public Node left;
  public Node right;
  
  public Node(char data) {
    this.data = data + "";
    next = null;
    
    left = null;
    right = null;
  }
  
  public Node(String data) {
    this.data = data;
    next = null;
    
    left = null;
    right = null;
  }
  
  public Node(String data, String mean) {
    this.data = data;
    next = null;
    
    this.mean = mean;
    left = null;
    right = null;
  }
  
  public void insert(Node n) {
    insert(n, 0);
  }
  
  public void insert(Node n, int i) {
    if (n.data.charAt(i) < data.charAt(i)) {
      if (left == null) {
        left = n;
      } else {
        left.insert(n);
      }
    }
    if (n.data.charAt(i) > data.charAt(i)) {
      if (right == null) {
        right = n;
      } else {
        right.insert(n);
      }
    }
    if (n.data.charAt(i) == data.charAt(i)) {
      try {
        n.data.charAt(i+1);
        insert(n, i+1);
      } catch (Exception e) {}
    }
  }
  
  public String getMean(String word) {
    String mean = getMean(word, 0);
    return mean;
  }
  
  public String getMean(String word, int i) {
    String mean = "";
    if (word.charAt(i) < data.charAt(i)) {
      if (left.data.equals(word)) {
        mean = left.mean;
      } else {
        mean = left.getMean(word);
      }
    }
    if (word.charAt(i) > data.charAt(i)) {
      if (right.data.equals(word)) {
        mean = right.mean;
      } else {
        mean = right.getMean(word);
      }
    }
    return mean;
  }
  
  public void show() {
    if (left != null) {
      left.show();
    }
    System.out.println(data);
    if (right != null) {
      right.show();
    }
  }
  
}