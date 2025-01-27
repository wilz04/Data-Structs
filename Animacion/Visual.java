import java.awt.*;
import java.awt.event.*;

/** Creacion y presentacion en pantalla de la ventana y sus componentes */
public class Visual extends Frame{
  
  /** Creacion de la ventana y sus componentes */
  public Visual(){
    //creacion de la ventana
    super("Torres de Hanoi");
    setBounds((1024-550)/2,(768-400)/2,500,400);
    setVisible(true);
    setBackground(Color.white);
    
    //creacion de los discos
    Button disco1 = new Button();
    disco1.setBounds(55,280,100,20);
    disco1.setVisible(true);
    disco1.setEnabled(false);
    add(disco1);
    
    Button disco2 = new Button();
    disco2.setBounds(60,260,90,20);
    disco2.setVisible(true);
    disco2.setEnabled(false);
    add(disco2);
    
    Button disco3 = new Button();
    disco3.setBounds(65,240,80,20);
    disco3.setVisible(true);
    disco3.setEnabled(false);
    add(disco3);
    
    Button disco4 = new Button();
    disco4.setBounds(70,220,70,20);
    disco4.setVisible(true);
    disco4.setEnabled(false);
    add(disco4);
    
    Button disco5 = new Button();
    disco5.setBounds(75,200,60,20);
    disco5.setVisible(true);
    disco5.setEnabled(false);
    add(disco5);

    //titulo
    Label titulo = new Label("Animacion de Torres de Hanoi");
    Font letra;
    letra = new Font("",Font.BOLD, 12);
    titulo.setFont(letra);
    titulo.setBounds(20,40,200,10);
    titulo.setVisible(true);
    add(titulo);

    //creacion de las agujas
    Label agujaDesde = new Label();
    agujaDesde.setBounds(100,100,10,200);
    agujaDesde.setVisible(true);
    agujaDesde.setBackground(Color.blue);
    add(agujaDesde);
    
    Label agujaIntermedia = new Label();
    agujaIntermedia.setBounds(250,100,10,200);
    agujaIntermedia.setVisible(true);
    agujaIntermedia.setBackground(Color.blue);
    add(agujaIntermedia);
    
    Label agujaHasta = new Label();
    agujaHasta.setBounds(400,100,10,200);
    agujaHasta.setVisible(true);
    agujaHasta.setBackground(Color.blue);
    add(agujaHasta);

    //boton 'play'
    Button botonPlay = new Button("Play >");
    botonPlay.setBounds(20,360,80,20);
    botonPlay.setVisible(true);
    add(botonPlay);

    //adicion del evento para cerrar la ventana
    addWindowListener(
      new WindowAdapter() {
        public void windowClosing(WindowEvent evt){
          System.exit(0);
        }
      }
    );
  }

  /** Llamada del metodo 'Visual', crea su instancia y devuelve sus resultados */
  public static void main(String[] args) {
    Visual visual = new Visual();
  }
}