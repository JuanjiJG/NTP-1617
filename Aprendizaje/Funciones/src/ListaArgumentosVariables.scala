/**
  * Created by juanjo on 28/03/17.
  */
object ListaArgumentosVariables extends App {
  def sumar(numero: Int *): Int = {
    var total = 0
    for (i <- numero) total += i
    total
  }

  var resultado = sumar(1)
  resultado = sumar(2,3)
  resultado = sumar(4,5,6,7,8)

  // Funciones con varias listas de argumentos
  def max(x: Int)(y: Int) = if (x > y) x else y

  // Usando el símbolo _ puedo dejarlo como temporal
  // y luego podria hacer f(1) y me daría como resultado 3
  val f = max(3)_
}
