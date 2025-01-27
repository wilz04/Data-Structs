public class Data {
  
  /** Carga de los datos */
  public static Tree load() {
    Tree tree = new Tree();
    tree.insert(new Node("a_1", "a_2"));
    tree.insert(new Node("b_1", "b_2"));
    tree.insert(new Node("c_1", "c_2"));
    tree.insert(new Node("d_1", "d_2"));
    tree.insert(new Node("e_1", "e_2"));
    tree.insert(new Node("f_1", "f_2"));
    tree.insert(new Node("g_1", "g_2"));
    tree.insert(new Node("h_1", "h_2"));
    tree.insert(new Node("i_1", "i_2"));
    tree.insert(new Node("j_1", "j_2"));
    return tree;
  }

}