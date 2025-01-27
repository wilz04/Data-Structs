import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;

public class Main extends JFrame implements ActionListener {
  
  JMenuItem miInvestString;
  JMenuItem miCheckSymbols;
  
  JMenuItem miRunLine;
  
  JMenuItem miDictionary;
  
  JMenuItem miAbout;
  JMenuItem miExit;
  
  /** Construcción de la interface gráfica */
  public Main() {
    JMenuBar menuBar = new JMenuBar();
    
    JMenu mPile = new JMenu("Pilas");
    JMenu mLine = new JMenu("Colas");
    JMenu mTree = new JMenu("Arboles");
    JMenu mHelp = new JMenu("Ayuda");
    
    miInvestString = new JMenuItem("Invertir cadena");
    miCheckSymbols = new JMenuItem("Comprobar {[()]}");
    
    miRunLine = new JMenuItem("Correr cola");
    
    miDictionary = new JMenuItem("Diccionario");
    
    miAbout = new JMenuItem("Acerca de...");
    miExit = new JMenuItem("Salir");
    
    miInvestString.addActionListener(this);
    miCheckSymbols.addActionListener(this);
    
    miRunLine.addActionListener(this);
    
    miDictionary.addActionListener(this);
    
    miAbout.addActionListener(this);
    miExit.addActionListener(this);
    
    mPile.add(miInvestString);
    mPile.add(miCheckSymbols);
    
    mLine.add(miRunLine);
    
    mTree.add(miDictionary);
    
    mHelp.add(miAbout);
    mHelp.addSeparator();
    mHelp.add(miExit);
    
    menuBar.add(mPile);
    menuBar.add(mLine);
    menuBar.add(mTree);
    menuBar.add(mHelp);
    
    setJMenuBar(menuBar);
  }
  
  /** Método de manejo de eventos */
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == miInvestString) {
      OnRelease.investString();
    }
    if (e.getSource() == miCheckSymbols) {
      setVisible(false);
      setBounds((1024-400)/2, (768-400)/2, 400, 400);
      
      JEditorPane editorPane;
      setLayout(new GridLayout(1, 1));
      editorPane = new JEditorPane();
      add(new JScrollPane(editorPane));
      
      setVisible(true);
      
      JFileChooser fileChooser = new JFileChooser();
      int fcFocus = fileChooser.showOpenDialog(this);
      if (fcFocus == fileChooser.APPROVE_OPTION) {
        try {
          URL fileName = fileChooser.getSelectedFile().toURL();
          editorPane.setPage(fileName);
          OnRelease.checkSymbols(editorPane.getText());
        } catch (Exception io) {
          JOptionPane.showMessageDialog(null, "Error al abrir el documento", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
      }
    }
    if (e.getSource() == miRunLine) {
      OnRelease.runLine();
    }
    if (e.getSource() == miDictionary) {
      OnRelease.getMean();
    }
    if (e.getSource() == miAbout) {
      OnRelease.showCredits();
    }
    if (e.getSource() == miExit) {
      OnRelease.exit();
    }
  }
  
  /** Método principal */
  public static void main(String args[]) {
    Main main = new Main();
    main.setBounds((1024-400)/2, (768-50)/2, 400, 50);
    main.setResizable(false);
    main.setTitle("Estructuras");
    main.setVisible(true);
  }
  
}
    