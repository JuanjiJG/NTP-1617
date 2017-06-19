/**
  * Clase concreta heredada de Nodo
  * Representa un nodo hoja (o nodo terminal) del árbol de Huffman
  *
  * @param caracter El caracter que representa el nodo
  * @param peso     El valor de la cadena que establece la codificación Huffman
  */
case class NodoHoja(caracter: Char, peso: Int) extends Nodo {
  /**
    * Redefinimos el método toString para representar la información de este nodo hoja
    */
  override def toString: String = "(" + caracter + ") - " + peso
}
