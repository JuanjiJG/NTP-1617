/**
  * Created by juanjo on 28/03/17.
  */
object Factorial extends App{
  // Las funciones recursivas no infieren el tipo,
  // así que es necesario indicarlo
  def factorial(x: Int): Int = {
    if (x == 0) 1
    else x*factorial(x-1)
  }

  val fact15 = factorial(15)
  println(fact15)

  // Tail recursion: la última operación que se ejecuta es la llamada recursiva
  // En el caso del factorial, NO es "tail recursion"
  // ¿Cómo conseguimos eso? Añadiendo @annotation.tailrec antes de la cabecera del método
  @annotation.tailrec
  def factorialTR(x: Int, acum: Int = 1): Int = {
    if (x == 0 || x == 1) acum
    else factorialTR(x-1, x*acum)
  }

  // Con el uso del valor por defecto, nos ahorramos poner el segundo argumento
  val fact15TR = factorialTR(15)
  println(fact15TR)

  // ¿Cómo recuperamos el estado natural de esta función?
  // Con funciones anidadas
  def factorialTR2(x: BigInt): BigInt = {
    @annotation.tailrec
    def auxiliar(x: BigInt, acum: BigInt): BigInt = {
      if (x == 0 || x == 1) acum
      else auxiliar(x-1, x*acum)
    }

    auxiliar(x, 1)
  }

  val fact30TR2 = factorialTR2(30)
  println(fact30TR2)
}
