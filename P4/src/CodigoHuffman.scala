import scala.io.Source

/**
  * Clase object con la funcionalidad necesaria para trabajar con árboles Huffman
  */
object CodigoHuffman {

  /*
  FUNCIONES DE UTILIDAD PARA LOS NODOS (PUNTO 2 DEL GUIÓN)
   */

  /**
    * Función para calcular el peso de un nodo del árbol Huffman
    *
    * @param nodo El nodo del que calcular su peso
    * @return Un valor entero que indica el peso del nodo
    */
  def calcularPeso(nodo: Nodo): Int = {
    /*
    Si es un nodo hoja, nos quedamos únicamente con su peso.
    Si es un nodo interno, nos quedamos con la suma de los pesos de sus nodos hijo (recursividad)
     */
    nodo match {
      case NodoHoja(_, coste) => coste
      case NodoInterno(nodoHijoI, nodoHijoD, _, _) => calcularPeso(nodoHijoI) + calcularPeso(nodoHijoD)
    }
  }

  /**
    * Método para obtener la lista de caracteres que representa un nodo, considerando todos sus nodos inferiores
    *
    * @param nodo El nodo del que queremos obtener su lista de caracteres
    * @return Una lista con los caracteres que representa el nodo
    */
  def obtenerCaracteres(nodo: Nodo): List[Char] = {
    /*
    Si es un nodo hoja, nos quedamos únicamente con su caracter.
    Si es un nodo interno, nos quedamos con la concatenación de los caracteres de sus nodos hijo (recursividad)
     */
    nodo match {
      case NodoHoja(caracter, _) => List(caracter)
      case NodoInterno(nodoHijoI, nodoHijoD, _, _) => List.concat(obtenerCaracteres(nodoHijoI), obtenerCaracteres(nodoHijoD))
    }
  }

  /**
    * Método para generar un árbol a partir de una lista de nodos
    * Se combinan los dos primeros nodos de la lista para formar un nuevo nodo interno
    *
    * @param listaNodosHoja La lista de nodos
    * @return Un nuevo nodo interno que resulta de la combinación de los subnodos
    */
  def generarArbol(listaNodosHoja: List[Nodo]): Nodo = {
    /*
    Para construir el nuevo nodo interno debemos pasarle el cálculo
    del nuevo peso y concatenar las listas de caracteres
     */
    NodoInterno(listaNodosHoja.head, listaNodosHoja.tail.head,
      obtenerCaracteres(listaNodosHoja.head) ++ obtenerCaracteres(listaNodosHoja.tail.head),
      calcularPeso(listaNodosHoja.head) + calcularPeso(listaNodosHoja.tail.head))
  }


  /*
  FUNCIONES DE CONSTRUCCIÓN DE ÁRBOLES DE CODIFICACIÓN (PUNTO 2.1 DEL GUIÓN)
   */

  /**
    * Método para calcular las veces que se repite un caracter en una lista
    *
    * @param listaCaracteres La lista de caracteres que queremos comprobar
    * @return Una lista de caracteres que se compone de pares (caracter-nºrepeticiones)
    */
  def calcularRepeticionesCaracteres(listaCaracteres: List[Char]): List[(Char, Int)] = {
    listaCaracteres.groupBy(identity).mapValues(_.size).toList
  }

  /**
    * Método para crear una lista de nodos hoja, ordenados por su peso ascendente
    *
    * @param listaRepeticiones La lista de repeticiones de los caracteres
    * @return Una lista de nodos hoja ordenados
    */
  def generarListaNodosHojaOrdenados(listaRepeticiones: List[(Char, Int)]): List[NodoHoja] = {
    /*
    Creamos una lista de pesos ordenados por orden ascendente (es decir, de menos a más peso).
    El peso del nodo hoja será el número de apariciones de dicho caracter.
     */
    listaRepeticiones.sortWith((lista1Rep, listaRep2) => lista1Rep._2 < listaRep2._2).map(listaRep => NodoHoja(listaRep._1, listaRep._2))
  }

  /**
    * Método para comprobar si una lista de nodos contiene un único elemento
    *
    * @param listaNodos La lista de nodos que queremos comprobar
    * @return Un booleano que indica si la lista contiene un elemento o no
    */
  def singleton(listaNodos: List[Nodo]): Boolean = {
    listaNodos.size == 1
  }

  /**
    * Método para combinar los dos primeros elementos de una lista de nodos
    *
    * @param listaNodosHoja La lista de nodos que queremos combinar
    * @return Una lista de nodos con los dos primeros nodos combinados
    */
  def combinar(listaNodosHoja: List[Nodo]): List[Nodo] = {
    /*
    Pasos a seguir:
      - Crear un nodo interno con los dos primeros de la lista (los de menor peso)
      - Combinar el nuevo nodo interno con el resto de la lista (que ahora tiene 2 elementos menos)
        - La inserción se hace conservando el orden (es decir, primero los de menor peso)
     */
    (generarArbol(listaNodosHoja) :: listaNodosHoja.tail.tail).sortWith((nodoA, nodoB) => calcularPeso(nodoA) < calcularPeso(nodoB))
  }

  /**
    * Método iterativo que llama a los métodos definidos anteriormente para ir generando el árbol de codificación
    *
    * @param singleton  Una función singleton que compruebe el nº de elementos de la lista
    * @param combinar   Una función que combine los dos primeros elementos de la lista en un nodo interno
    * @param listaNodos Una lista de nodos para ir procesando
    * @return Una lista de nodos (de un solo elemento Nodo)
    */
  @annotation.tailrec
  def repetir(singleton: List[Nodo] => Boolean, combinar: List[Nodo] => List[Nodo])(listaNodos: List[Nodo]): List[Nodo] = {
    /*
    - Si en la lista de nodos solo queda un elemento, terminar y devolverla.
    - En caso contrario, volver a llamar a la función repetir pasándole la lista combinada (los dos primeros elementos unificados)
     */
    if (singleton(listaNodos)) listaNodos
    else repetir(singleton, combinar)(combinar(listaNodos))
  }

  /**
    * Método para generar un árbol de codificación
    * Hace uso de la función repetir para generar un objeto Nodo que contenga el árbol completo
    *
    * @param listaCaracteres La lista de caracteres para construir el árbol de codificación
    * @return Un objeto Nodo que corresponde al árbol de codificación de la lista de caracteres
    */
  def crearArbolDeCodificacion(listaCaracteres: List[Char]): Nodo = {
    repetir(singleton, combinar)(generarListaNodosHojaOrdenados(calcularRepeticionesCaracteres(listaCaracteres))).head
  }


  /*
  FUNCIÓN DE DECODIFICACIÓN (PUNTO 3.1 DEL GUIÓN)
   */

  /**
    * Método para decodificar una lista de 0's y 1's y pasarlo a lista de caracteres
    *
    * @param nodoRaiz        Un árbol de codificación Huffman
    * @param listaCodificada Una lista de 0's y 1's para decodificar
    * @return Una lista de caracteres, que representan el mensaje decodificado
    */
  def decodificar(nodoRaiz: Nodo, listaCodificada: List[Int]): List[Char] = {
    def auxiliar(nodoAux: Nodo, listaCodificadaAux: List[Int]): List[Char] = {
      nodoAux match {                                           // Comprobamos el nodo actual del árbol
        case NodoHoja(caracter, _) =>                           // CASO NODO HOJA
          if (listaCodificadaAux.isEmpty)                       // Si es el último bit codificado y no hay mas texto...
            List(caracter)                                      // ... devolver el caracter
          else                                                  // En caso contrario...
            caracter :: auxiliar(nodoRaiz, listaCodificadaAux)  // ... volver a ejecutar con el nodo raiz y la misma lista
        case NodoInterno(nodoHijoI, nodoHijoD, _, _) =>         // CASO NODO INTERNO
          if (listaCodificadaAux.head == 0)                     // Si el bit es un 0 (izquierda)...
            auxiliar(nodoHijoI, listaCodificadaAux.tail)        // ... continuamos con el nodo hijo izquierdo y la lista menos el primer elemento
          else                                                  // En caso contrario (derecha)...
            auxiliar(nodoHijoD, listaCodificadaAux.tail)        // ... continuamos con el nodo hijo derecho y la lista menos el primer elemento
      }
    }

    auxiliar(nodoRaiz, listaCodificada)                         // Comenzar desde la raiz con la lista completa
  }


  /*
  FUNCIONES DE CODIFICACIÓN (PUNTO 3.2 DEL GUIÓN)
  MÉTODO POCO EFICIENTE
   */

  /**
    * Método para codificar una lista de caracteres con un arbol de codificacion Huffman
    * Es un método poco eficiente por el uso de la recursividad
    *
    * @param nodoRaiz        Un árbol de codificación Huffman
    * @param listaCaracteres Una lista de caracteres para codificar
    * @return Una lista de 0's y 1's, que representan el mensaje codificado
    */
  def codificar(nodoRaiz: Nodo, listaCaracteres: List[Char]): List[Int] = {
    def auxiliar(nodoAux: Nodo, listaCaracteresAux: List[Char]): List[Int] = {
      nodoAux match {                                                         // Comprobamos el nodo actual del árbol
        case NodoHoja(_, _) =>                                                // CASO NODO HOJA
          if (listaCaracteresAux.tail.isEmpty)                                // Si es el último caracter...
            List()                                                            // ... devolver lista vacia
          else                                                                // En caso contrario...
            auxiliar(nodoRaiz, listaCaracteresAux.tail)                       // ... continuar con el siguiente caracter
        case NodoInterno(nodoHijoI, nodoHijoD, _, _) =>                       // CASO NODO INTERNO
          if (obtenerCaracteres(nodoHijoI).contains(listaCaracteresAux.head)) // Si el caracter esta a la izquierda...
            0 :: auxiliar(nodoHijoI, listaCaracteresAux)                      // ... añadir un 0 y concatenar
          else                                                                // En caso contrario...
            1 :: auxiliar(nodoHijoD, listaCaracteresAux)                      // ... añadir un 1 y concatenar
      }
    }

    auxiliar(nodoRaiz, listaCaracteres)                                       // Comenzar desde la raiz con la lista completa
  }


  /*
  FUNCIONES DE CODIFICACIÓN (PUNTO 3.2 DEL GUIÓN)
  MÉTODO EFICIENTE CON TABLAS
   */

  type TablaCodigo = List[(Char, List[Int])]

  /**
    * Método para codificar un texto con una tabla para no tener que recorrer el árbol de Huffman completo
    *
    * @param tabla    Una tabla con los códigos de los caracteres
    * @param caracter El caracter a buscar en la tabla
    * @return Una lista de enteros, representando el caracter codificado
    */
  def codificarConTabla(tabla: TablaCodigo)(caracter: Char): List[Int] = {
    /*
    Buscar en la tabla el código asociado al caracter pasado como argumento
    Quedarse con el primero de la lista filtrada, y de él, quedarse con el código de 0's y 1's
     */
    tabla.filter(registro => registro._1 == caracter).head._2
  }

  /**
    * Método para convertir un árbol de Huffman en una tabla de códigos
    *
    * @param arbolCodificacion Un árbol de codificación de Huffman
    * @return Una tabla de códigos de caracteres
    */
  def convertirArbolTabla(arbolCodificacion: Nodo): TablaCodigo = {
    def auxiliar(nodo: Nodo, listaEnteros: List[Int]): TablaCodigo = {
      nodo match {
        // Si es NodoHoja, devolver una tabla con el caracter y su lista de enteros
        case NodoHoja(caracter, _) => List((caracter, listaEnteros))
        // En caso contrario (NodoInterno), continuar por la izquierda y la derecha añadiendo 0 o 1, respectivamente
        case NodoInterno(izda, dcha, _, _) => auxiliar(izda, listaEnteros :+ 0) ::: auxiliar(dcha, listaEnteros :+ 1)
      }
    }

    auxiliar(arbolCodificacion, List()) // Comenzar desde el arbol original con la lista vacía
  }

  /**
    * Método para codificación rápida de un texto, haciendo uso de una tabla de códigos de caracteres
    *
    * @param nodoRaiz        El nodo Huffman con el que codificar
    * @param listaCaracteres La lista de caracteres a codificar
    * @return Una lista de 0's y 1's, representando el mensaje codificado
    */
  def codificacionRapida(nodoRaiz: Nodo)(listaCaracteres: List[Char]): List[Int] = {
    // Obtener una tabla del código Huffman
    val tablaCodigo = convertirArbolTabla(nodoRaiz)
    /*
    Para cada caracter de la lista:
      - Codificar dicho caracter usando la tabla
    Una vez terminado, aplanar la lista de listas para que se convierta en una única lista de enteros
     */
    (for (caracter <- listaCaracteres) yield codificarConTabla(tablaCodigo)(caracter)).flatten
  }


  /*
  OTRAS FUNCIONES ADICIONALES
   */

  /**
    * Funcion para leer los datos de un fichero de texto y convertitlo a un String
    */
  def leerArchivo(nombreArchivo: String): String = {
    Source.fromFile(nombreArchivo).getLines().mkString
  }

  /**
    * Método para convertir una cadena de caracteres en una lista de caracteres
    *
    * @param cadena La cadena a convertir
    * @return Una lista de caracteres
    */
  def stringToCharList(cadena: String): List[Char] = cadena.toList

}
