/**
  * Created by juanjo on 4/04/17.
  */
object Ejercicio2 extends App {
  // Implementación de la sucesión de Fibonacci
  def fibonacci(n: Int): Int = {
    // Caso base
    if (n == 0 || n == 1) n
    // Caso inductivo
    else fibonacci(n-1)+fibonacci(n-2)
  }

  val resultadoFibonacci = fibonacci(9)
  println(resultadoFibonacci)

  def fibonacciTailRecursion(n: Int): Int = {
    @annotation.tailrec
    def auxiliar(n: Int, act: Int, sig: Int): Int = {
      // Caso base
      if (n == 0) act
      // Caso inductivo
      else auxiliar(n-1, sig, act+sig)
    }

    // Llamada inicial
    auxiliar(n, 0, 1)
  }
}
