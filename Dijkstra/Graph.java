import javax.swing.JOptionPane;

public class Graph {
  
  private static String values;
  private static String numbers;
  private static int[][] costs = {
    //A,  B,  C,  D,  E,  F,  G,  H,  I
    { 0, 10,  2, 30,  0,  0,  0,  0,  0}, //A
    { 0,  0,  0,  0,  0,  0, 20,  0,  0}, //B
    { 0,  0,  0,  0,  0, 10,  0,  0,  0}, //C
    { 0,  0,  0,  0,  8, 33,  0,  0,  0}, //D
    { 0,  5,  0,  0,  0,  0,  0,  0,  0}, //E
    { 0,  0,  0,  0,  9,  0,  0,  0,  0}, //F
    { 0,  0,  0,  0,  0,  0,  0,  0,  5}, //G
    { 10, 0,  5,  0,  0,  0,  0,  0,  0}, //H
    { 0,  0,  0,  0,  7,  0,  0,  0,  0}, //I
  };
  
  /** Inicialización */
  private Graph() {
    values = "";
    numbers = "";
  }
  
  /** Conversión de caracteres a números */
  private static int val(char name) {
    try {
      int[] n = {0, 1, 2, 3, 4, 5, 6, 7, 8};
      return n[name - 65];
    } catch (Exception e) {
      return 0; 
    }
  }
  
  /** Comprobación de adyacencia entre nodos */
  private static boolean isBehind(char x, char y) {
    try {
      int a = val(x);
      int b = val(y);
      if(costs[a][b] > 0) {
        return true;
      } else {
        return false;
      }
    } catch (Exception e) {
      return false;
    }
  }
  
  /** Obtención del costo */
  private static int getWeight(char x, char y) {
    try {
      int a = val(x);
      int b = val(y);
      return costs[a][b];
    } catch(Exception e) {
      return 0;
    }
  }
  
  /** Obtención de un mínimo */
  private static int min(String s) {
    String n = "";
    int newN = Integer.MAX_VALUE;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ' ') {
        if (Integer.parseInt(n) < newN) {
          newN = Integer.parseInt(n);
        }
        n = "";
      } else {
        n += s.charAt(i);
      }
    }
    return newN;
  }
  
  /** Obtención del camino más barato */
  private static int getCheapestPath(char x, char y) {
    return getCheapestPath(x, y, 0);
  }
  
  /** Obtención del camino más barato */
  private static int getCheapestPath(char x, char y, int value) {
    for (char i = 'A'; i <= 'I'; i++) {
      if (isBehind(x, i)) {
        if (i == y) {
          value += getWeight(x, i);
          values += value + " ";
          value = 0;
        } else {
          value += getWeight(x, i);
          value = getCheapestPath(i, y, value);
        }
      }
    }
    return value;
  }
  
  /** Obtención del camino más corto */
  private static int getShortestPath(char x, char y) {
    return getShortestPath(x, y, 0);
  }
  
  /** Obtención del camino más corto */
  private static int getShortestPath(char x, char y, int number) {
    for (char i = 'A'; i <= 'I'; i++) {
      if (isBehind(x, i)) {
        if (i == y) {
          number++;
          numbers += number + " ";
          number = 0;
        } else {
          number++;
          number = getShortestPath(i, y, number);
        }
      }
    }
    return number;
  }
  
  /** Método principal */
  public static void main(String args[]) {
    String message = "";
    Graph a_e = new Graph();
    
    a_e.getCheapestPath('A', 'E');
    a_e.getShortestPath('A', 'E');
    message += "El camino mas barato de la Terminal 'A' a la Terminal 'E' cuesta ";
    message += a_e.min(a_e.values) + "        \n\n";
    message += "El camino mas corto de la Terminal 'A' a la Terminal 'E' pasa por ";
    message += a_e.min(a_e.numbers) + " nodos        \n\n";
    
    Graph h_i = new Graph();
    
    h_i.getCheapestPath('H', 'I');
    h_i.getShortestPath('H', 'I');
    message += "El camino mas barato de la Terminal 'H' a la Terminal 'I' cuesta ";
    message += h_i.min(h_i.values) + "        \n\n";
    message += "El camino mas corto de la Terminal 'H' a la Terminal 'I' pasa por ";
    message += h_i.min(h_i.numbers) + " nodos        \n\n";
    
    JOptionPane.showMessageDialog(null, message, "Información", JOptionPane.INFORMATION_MESSAGE);
  }
  
}