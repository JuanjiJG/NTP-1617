/**
  * Clase para representar conjuntos definidos mediante una función
  * característica (un predicado). De esta forma, se declara el tipo
  * conjunto como un predicado que recibe un entero (elemento) como
  * argumento y devuelve un valor booleano que indica si pertenece o no
  * al conjunto
  *
  * @param funcionCaracteristica
  */
class Conjunto(val funcionCaracteristica: Int => Boolean) {
  /**
    * Crea una cadena con el contenido completo del conjunto
    *
    * @return una cadena con el contenido completo del conjunto
    */
  override def toString(): String = {
    val elementos = for (i <- -Conjunto.LIMITE to Conjunto.LIMITE
                         if funcionCaracteristica(i)) yield i
    elementos.mkString("{", ",", "}")
  }

  /**
    * Método para determinar la pertenencia de un elemento al
    * conjunto
    *
    * @param elemento el elemento del que se quiere comprobar
    *                 su pertecencia al conjunto
    * @return valor booleano indicando si el elemento cumple
    *         la función característica o no
    */
  def apply(elemento: Int): Boolean = {
    funcionCaracteristica(elemento)
  }
}

/**
  * Objecto companion que ofrece métodos para trabajar con
  * conjuntos
  */
object Conjunto {
  /**
    * Límite para la iteración necesaria de algunas operaciones,
    * entre -1000 y 1000
    */
  private final val LIMITE = 1000

  /**
    * Método que permite crear objetos de la clase Conjunto
    * de forma sencilla
    *
    * @param f la función característica del conjunto
    * @return un objeto de la clase Conjunto
    */
  def apply(f: Int => Boolean): Conjunto = {
    new Conjunto(f)
  }
}
