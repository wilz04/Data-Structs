public class Line {
  Node first;
  public Line() {
    first = null;
  }

  public void insert(Node n) {
    if (first == null) {
      first = n;
    } else {
      Node temp = first;
      while (temp.next != null) {
        temp = temp.next;
      }
      temp.next = n;
    }
  }

  public Node delete() {
    Node temp = first;
    first = first.next;
    return(temp);
  }
  
  public void toEmpty() {
    first = null;
  }
  
  public boolean isEmpty() {
    return first == null;
  }

  public void show() {
    Node temp = first;
    while (temp != null) {
      temp.show();
      temp = temp.next;
    }
  }

}