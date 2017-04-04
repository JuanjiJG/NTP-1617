/**
  * Created by juanjo on 3/04/17.
  */
object FuncionesParcialmenteAplicadasCurrying extends App {
  def divisible(x:Int, y:Int) = x%y == 0

  // Uso de marcador de posición para función aplicada
  // parcialmente
  val f = divisible _

  val resultado = f(29,3)

  // Podemos crear versiones específicas de una función ya existente
  val divisiblePor3 = divisible(_:Int, 3)
  val resultado2 = divisiblePor3(21)

  // Más natural con dos listas de argumentos
  def divisiblePor(x:Int)(y:Int) = x%y == 0

  val divisiblePor2 = divisiblePor(_:Int)(2)
}
