/**
  * Clase concreta heredada de Nodo
  * Representa un nodo interno (o nodo intermedio) del árbol de Huffman
  *
  * @param nodoHijoI El nodo hijo situado a la izquierda del nodo padre
  * @param nodoHijoD EL nodo hijo situado a la derecha del nodo padre
  * @param cadena    La cadena de caracteres del nodo
  * @param peso      El valor de la cadena que establece la codificación Huffman
  */
case class NodoInterno(nodoHijoI: Nodo, nodoHijoD: Nodo, cadena: List[Char], peso: Int) extends Nodo {
  /**
    * Redefinimos el método toString para representar la información de este nodo interno
    */
  override def toString: String = "(" + cadena + ") - " + peso
}
