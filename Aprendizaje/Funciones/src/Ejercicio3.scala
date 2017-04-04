/**
  * Created by juanjo on 4/04/17.
  */
object Ejercicio3 extends App {
  // Definir una función recursiva que indique si una lista está ordenada
  // (pasando una función de comparación)
  def mayorQue(a: Int, b: Int): Boolean = if(a > b) true else false
  def menorQue(a: Int, b: Int): Boolean = if(a < b) true else false

  def ordenado[A](array: Array[A], comparar: (A,A) => Boolean): Boolean = {
    // Caso base
    // El primer elemento ya no está ordenado con el segundo
    if (array.length == 1) true
    else if (!comparar(array(0), array(1))) false
    else ordenado(array.tail, comparar)
  }

  val vector = Array(5,4,3,2,1)
  val resultadoOrdenado = ordenado(vector, mayorQue)

  println(resultadoOrdenado)

  // Versión del profesor
  def ordenadoProfesor[A](array: Array[A], comparar:(A,A) => Boolean): Boolean = {
    def iterar(indice: Int): Boolean = {
      // Caso base 1: no pasarse de longitud
      if (indice == array.length-2) comparar(array(indice), array(indice+1))
      // Caso base 2: si encuentro dos elementos no ordenados, devuelvo false
      else if(!comparar(array(indice), array(indice+1))) false
      else iterar(indice+1)
    }

    // Desencadenamos la ejecución
    iterar(0)
  }

  val vector2:Array[Int] = Array(1,5,20,35,57,98,123,215)
  val resultadoOrdenado2 = ordenadoProfesor(vector, mayorQue)
  println(resultadoOrdenado2)
}
