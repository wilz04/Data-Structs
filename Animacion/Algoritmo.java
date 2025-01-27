import javax.swing.*;

/** Desarrollo de la clase que devuelve la solucion al problema principal */
public class Algoritmo {
  
  /** Metodo que contiene al algoritmo */
  public static void  mover(int  n, int  desde, int  hasta, int  intermedia) {
    if (n == 1) {
      System.out.println("Mover el disco superior de la aguja " + desde + " a la aguja " + hasta);
    } else {
      mover(n-1, desde, intermedia, hasta);
      mover(1, desde, hasta, intermedia);
      mover(n-1, intermedia, hasta, desde);
    }
  }

  /** Metodo principal, entrada del parametro 'numDiscos' (numero de discos) y llamada del metodo mover */
  public static void main(String[] args) {
    int numDiscos = Integer.parseInt(JOptionPane.showInputDialog("Digite el número de discos"));
    mover(numDiscos, 1, 3, 2);
  }
}