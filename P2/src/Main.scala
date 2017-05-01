/**
  * Objeto singleton para probar la funcionalidad del triangulo
  * de Pascal
  */
object Main {

  /**
    * Metodo main: en realidad no es necesario porque el desarrollo
    * deberia guiarse por los tests de prueba
    *
    * @param args
    */
  def main(args: Array[String]) {
    println("=================== Triángulo de Pascal ===================")

    // Se muestran 10 filas del trinagulo de Pascal
    for (row <- 0 to 10) {
      // Se muestran 10 10 columnas
      for (col <- 0 to row)
        print(calcularValorTrianguloPascal(col, row) + " ")

      // Salto de linea final para mejorar la presentacion
      println()
    }

    // Se muestra el valor que debe ocupar la columna 5 en la fila 10
    println(calcularValorTrianguloPascal(10, 15))
    println(calcularValorTrianguloPascal(0, 0))
  }

  /**
    * Ejercicio 1: funcion para generar el triangulo de Pascal
    *
    * @param columna la columna del valor que queremos calcular
    * @param fila    la fila del valor que queremos calcular
    * @return el valor de la fila y columna dadas en el triángulo de Pascal
    */
  def calcularValorTrianguloPascal(columna: Int, fila: Int): Int = {
    /*
    Hay dos casos base:
      - La columna 0 siempre vale 1
      - La columna X de la fila X siempre vale 1
    En caso contrario, hay que calcularlo:
      - Se suma el valor del triángulo de Pascal de la fila anterior y las columnas
        que están encima del valor que queremos calcular (columna-1 y columna).
      - Hay una restricción: La columna nunca puede ser mayor a la fila en la que está
        (esto significa que en la fila 3 no hay una columna 4).
     */
    if (columna == 0 || columna == fila) 1
    else if (columna < fila)
      calcularValorTrianguloPascal(columna - 1, fila - 1) +
        calcularValorTrianguloPascal(columna, fila - 1)
    else
      -1
  }

  /**
    * Ejercicio 2: funcion para chequear el balance de parentesis
    *
    * @param cadena cadena a analizar
    * @return valor booleano con el resultado de la operacion
    */
  def chequearBalance(cadena: List[Char]): Boolean = {
    // Para este método usaremos una función auxilar con un contador pasado como argumento
    def auxiliar(cadena: List[Char], contador: Int): Int = {
      /*
      Caso base: cadena vacía
      En caso contrario:
        - Coger el primer carácter y comprobar si es o no un paréntesis:
          - Si es de apertura, se incrementa en 1 el contador
          - Si es de cierre, se decrementa en 1 el contador
          - Si es otro carácter, no hacer nada
        - Si hemos obtenido un recuento inferior a 0, significa que la cadena
          NO ESTÁ BALANCEADA, se devuelve su valor
        - En caso contrario,
          volver a llamar a la función pasándole la cadena
          menos el primer carácter (tail).
       */
      if (cadena.isEmpty) contador
      else {
        val recuento = cadena.head match {
          case ')' => contador - 1
          case '(' => contador + 1
          case _ => contador
        }
        if (recuento < 0) recuento
        else auxiliar(cadena.tail, recuento)
      }
    }

    // Comenzamos el proceso pasando la cadena y el contador a 0
    // Si devuelve 0, significa que está balanceado (true)
    auxiliar(cadena, 0) == 0
  }

  /**
    * Ejercicio 3: funcion para determinar las posibles formas de devolver el
    * cambio de una determinada cantidad con un conjunto de monedas
    *
    * @param cantidad la cantidad para la que queremos calcular combinaciones de cambio
    * @param monedas  una lista de los distintos tipos de monedas que tenemos
    * @return contador de numero de vueltas posibles
    */
  def contarCambiosPosibles(cantidad: Int, monedas: List[Int]): Int = {
    /*
    Hay 3 casos base:
      - La lista de monedas está vacía -> Devolver 0 (no hay combinación posible de monedas)
      - Calcular cambio para una cantidad negativa -> Devolver 0 (no hay combinación posible de monedas)
      - Calcular cambio para una cantidad de 0 -> Devolver 1 (solo hay una combinación: no dar nada)
    En caso contrario:
      - Llamar a la función recursiva dos veces y sumar sus resultados
        cambios(cantidad - monedas.head, monedas) + cambios(cantidad, monedas.tail)
    Importante:
      Los casos base se han de llamar en ese orden,
      porque podría darse el caso de cantidad == 0 y no tener monedas.
     */
    if (monedas.isEmpty || cantidad < 0) 0
    else if (cantidad == 0) 1
    else
      contarCambiosPosibles(cantidad - monedas.head, monedas) + contarCambiosPosibles(cantidad, monedas.tail)
  }

  /**
    * Ejercicio 4: función para realizar una búsqueda binaria genérica (es
    * decir, que esté parametrizada y podamos comparar cualquier tipo de objeto).
    *
    * Hay que indicar la función de comparación para el objeto que se vaya a usar,
    * ya que el lenguaje de programación no puede saberlo.
    *
    * @param lista    la lista en la que vamos a buscar, de cualquier tipo
    * @param elemento el elemento que queremos encontrar, de cualquier tipo
    * @param comparar la función de comparación que nos permite
    * @return booleano que indica si el elemento está en la lista
    */
  def busquedaBinariaGenerica[T](lista: Array[T], elemento: T, comparar: (T, T) => Boolean): Boolean = {
    @annotation.tailrec
    def iterar(indiceIzquierdo: Int, indiceDerecho: Int): Boolean = {
      // En primer lugar comprobamos los índices
      // Si el izquierdo es mayor que el derecho, parar
      if (indiceIzquierdo > indiceDerecho) return false

      // Definir índice medio
      val indiceMedio = (indiceIzquierdo + indiceDerecho) / 2

      if (lista(indiceMedio) == elemento) return true
      else if(comparar(lista(indiceMedio), elemento)) return iterar(indiceMedio + 1, indiceDerecho)
      else return iterar(indiceIzquierdo, indiceMedio - 1)
    }

    // Desencadenamos la ejecución
    iterar(0, lista.length - 1)
  }
}
