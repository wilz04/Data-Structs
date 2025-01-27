public class Pile {
  
  public Node top;
  
  public Pile() {
    top = null;
  }

  public void insert(Node c) {
    if (top == null) {
      top = c;
    } else {
      Node temp = top;
      top = c;
      top.next = temp;
    }
  }

  public Node delete() {
    Node temp = top;
    if (top != null) {
      top = top.next;
    }
    return temp;
  }
  
  public boolean isEmpty() {
    return top == null;
  }

  public void show() {
    Node temp;
    temp = top;
    while (temp != null) {
      temp.show();
      temp = temp.next;
    }
  }

}