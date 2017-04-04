/**
  * Created by juanjo on 3/04/17.
  */
object Ejercicio1 extends App{
  // Hacer una función recursiva que calcule el sumatorio de dos números
  def identidad(x: Int): Int = x

  def sumatorioEnteros(a:Int, b:Int): Int = {
    // Caso base
    if (a > b) 0
    // Caso inductivo
    else a+sumatorioEnteros(a+1, b)
  }

  def sumatorioAlCuadrado(a:Int, b:Int): Int = {
    // Caso base
    if (a > b) 0
    // Caso inductivo
    else (a*a)+sumatorioEnteros(a+1, b)
  }

  def potenciaDeDos(a:Int): Int = {
    if (a == 0) 1
    else 2*potenciaDeDos(a-1)
  }

  println(potenciaDeDos(5))

  def sumatorioDosElevado(a:Int, b:Int): Int = {
    // Caso base
    if (a > b) 0
    // Caso inductivo
    else potenciaDeDos(a)+sumatorioDosElevado(a+1, b)
  }

  println(sumatorioDosElevado(1, 5))

  // Hacer una función genérica sumatorio
  def sumatorioGenerico(a:Int, b:Int, f:Int => Int): Int = {
    // Caso base
    if (a > b) 0
    // Caso inductivo
    else f(a)+sumatorioGenerico(a+1, b, f)
  }

  def sumatorioEnteros2(a:Int, b:Int) = sumatorioGenerico(a, b, x => x)
  def sumatorioCuadrados(a:Int, b:Int) = sumatorioGenerico(a, b, x => x*x)
  def sumatorioDosElevado2(a:Int, b:Int) = sumatorioGenerico(a, b, x => potenciaDeDos(x))

  // Actualizar el sumatorio para que sea curry
  def sumatorioCurrificado(f:Int => Int)(x:Int, y:Int): Int = {
    // Caso base
    if (x > y) 0
    // Caso inductivo
    else f(x)+sumatorioCurrificado(f)(x+1, y)
  }

  // Ahora podemos usar el operador _ y nos ahorramos indicar los argumentos que nos faltan
  def sumatorioEnteros3(a:Int, b:Int) = sumatorioCurrificado(x => x) _

  // Recordando el ejemplo de tail recursion...
  def factorialTR2(x: BigInt): BigInt = {
    @annotation.tailrec
    def auxiliar(x: BigInt, acum: BigInt): BigInt = {
      if (x == 0 || x == 1) acum
      else auxiliar(x-1, x*acum)
    }

    auxiliar(x, 1)
  }

  // Conseguir que el sumatorio currificado sea tail recursion
  // Si definimos una función dentro de otra, podemos aprovechar que la auxiliar
  // está dentro del ámbito de la otra y ya conoce ciertas variables
  def sumatorioCurrificadoTailRec(f:Int => Int)(x:Int, y:Int): Int = {
    @annotation.tailrec
    def auxiliar(x:Int, acum: Int): Int = {
      if (x > y) acum
      else auxiliar(x+1, acum + f(x))
    }

    auxiliar(x, 0)
  }
}
