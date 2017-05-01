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
  * Objeto companion que ofrece métodos para trabajar con
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

  /**
    * Método para crear un conjunto de un solo elemento
    *
    * @param elemento el elemento del que se quiere crear un conjunto
    * @return un conjunto que representa a ese único elemento
    */
  def conjuntoUnElemento(elemento: Int): Conjunto = {

  }

  /**
    * Método para calcular la unión de dos conjuntos
    *
    * @param c1 el primer conjunto
    * @param c2 el segundo conjunto
    * @return un conjunto que es el resultado de la unión de los dos conjuntos
    */
  def union(c1: Conjunto, c2: Conjunto): Conjunto = {

  }

  /**
    * Método para calcular la intersección de dos conjuntos
    *
    * @param c1 el primer conjunto
    * @param c2 el segundo conjunto
    * @return un conjunto que es el resultado de la intersección de los dos conjuntos
    */
  def interseccion(c1: Conjunto, c2: Conjunto): Conjunto = {

  }

  /**
    * Método para calcular la diferencia de dos conjuntos
    *
    * @param c1 el primer conjunto
    * @param c2 el segundo conjunto
    * @return un conjunto que es el resultado de la difererncia de los dos conjuntos
    */
  def diferencia(c1: Conjunto, c2: Conjunto): Conjunto = {

  }

  /**
    * Método para filtrar un conjunto dado un predicado
    *
    * @param c         el conjunto a filtrar
    * @param predicado la condición que deben cumplir los elementos para pasar el filtrado
    * @return un conjunto filtrado con solo los elementos que cumplen el predicado
    */
  def filtrar(c: Conjunto, predicado: Int => Boolean): Conjunto = {

  }

  /**
    * Método para comprobar si se cumple un predicado para todos los elementos del conjunto
    *
    * @param c         el conjunto sobre el que hacer la comprobación
    * @param predicado la condición que deben cupmplir todos los elementos del conjunto
    * @return un booleano que indica si todos los elementos del conjunto cumplen el predicado
    */
  def paraTodo(c: Conjunto, predicado: Int => Boolean): Boolean = {
    @annotation.tailrec
    def paraTodo(conjunto: Conjunto, predicado:

    def iterar(elemento: Int): Boolean = {
      if (???) ???
      else if (???) ???
      else predicado(elemento) && iterar(???)
    }

    iterar(-LIMITE)
  }

  /**
    * Método para comprobar si existe al menos un elemento para el que se cumple un predicado
    *
    * @param c         el conjunto sobre el que comprobar si existe el elemento
    * @param predicado la condición que debe cumplir al menos un elemento
    * @return un booleano que indica si existe al menos un elemento que cumple el predicado
    */
  def existe(c: Conjunto, predicado: Int => Boolean): Boolean = {

  }

  /**
    * Método para aplicar un mapeado sobre un conjunto, transformándolo en otro
    *
    * @param c       el conjunto sobre el que aplicar el mapeado
    * @param funcion la función a aplicar a los elementos del conjunto
    * @return un conjunto nuevo resultado de mapear el pasado como argumento
    */
  def map(c: Conjunto, funcion: Int => Int): Conjunto = {

  }
}
