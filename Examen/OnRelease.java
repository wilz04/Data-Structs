import javax.swing.JOptionPane;

public class OnRelease {
  
  /** Inversión de la cadena */
  public static void investString() {
    String word = JOptionPane.showInputDialog("Digita tu palabra:");
    Pile pile = new Pile();
    for (int i=0; i<word.length(); i++) {
      pile.insert(new Node(word.charAt(i)));
    }
    String newWord = "";
    for (int i=0; i<word.length(); i++) {
      newWord += pile.delete().data;
    }
    JOptionPane.showMessageDialog(null, newWord, "Inversión:", JOptionPane.INFORMATION_MESSAGE);
  }
  
  /** Revisión de los simbolos {[()]} en el texto */
  public static void checkSymbols(String text) {
    boolean value;
    String message;
    try {
      Pile pile = new Pile();
      for (int i=0; i<text.length(); i++) {
        if (text.charAt(i) == '{' || text.charAt(i) == '[' || text.charAt(i) == '(') {
          pile.insert(new Node(text.charAt(i)));
        }
        if (text.charAt(i) == ')' && pile.top.data.equals("(")) {
          pile.delete();
        }
        if (text.charAt(i) == ']' && pile.top.data.equals("[")) {
          pile.delete();
        }
        if (text.charAt(i) == '}' && pile.top.data.equals("{")) {
          pile.delete();
        }
      }
      value = pile.isEmpty();
    } catch (Exception e) {
      value = false;
    }
    if (value) {
      message = "El archivo posee equlibrados los simbolos de separación";
    } else {
      message = "El archivo no posee equlibrados los simbolos de separación";
    }
    JOptionPane.showMessageDialog(null, message, "Resultado:", JOptionPane.INFORMATION_MESSAGE);
  }
  
  /** Corrida de la prueba de cola */
  public static void runLine() {
    Line line = new Line();
    line.insert(new Node("a"));
    line.insert(new Node("b"));
    line.insert(new Node("c"));
    line.insert(new Node("d"));
    line.insert(new Node("e"));
    line.insert(new Node("f"));
    line.insert(new Node("g"));
    line.insert(new Node("h"));
    line.insert(new Node("i"));
    line.insert(new Node("j"));
    line.show();
    line.toEmpty();
    System.out.println(line.isEmpty());
    line.show();
  }
  
  /** Busqueda de significado */
  public static void getMean() {
    Tree tree = Data.load();
    String word = JOptionPane.showInputDialog("Digita tu palabra:");
    try {
      JOptionPane.showMessageDialog(null, tree.getMean(word), "Significado:", JOptionPane.INFORMATION_MESSAGE);
    } catch(Exception e) {}
  }
  
  /** Muestra de créditos */
  public static void showCredits() {
    JOptionPane.showMessageDialog(null, "050004 - Wilberth Castro F.", "Creado por:", JOptionPane.INFORMATION_MESSAGE);
  }
  
  /** Salida */
  public static void exit() {
    System.exit(0);
  }
  
}