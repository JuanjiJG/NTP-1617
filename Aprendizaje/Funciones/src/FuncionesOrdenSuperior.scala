/**
  * Created by juanjo on 3/04/17.
  */
object FuncionesOrdenSuperior extends App {
  /**
    * Operación segura con cadenas para comprobar
    * si la cadena es nula.
    *
    * @param cadena
    * @param operacion
    * @return
    */
  def operacionSeguraString(cadena: String,
                            operacion: String => String) = {
    if (cadena == null) cadena
    else operacion(cadena)
  }

  def invertir(cadena: String) = cadena.reverse

  def aMayuscula(cadena: String) = cadena.toUpperCase

  val resultado1 = operacionSeguraString("Hola", invertir)
  val resultado2 = operacionSeguraString("Hola", aMayuscula)
  val cadenaNula:String = null
  val resultado3 = operacionSeguraString(cadenaNula, invertir)

  // Operaciones básicas
  def mas5(x: Double) = x+5
  def cuadrado(x: Double) = x*x

  def aComponer(f: Double => Double, g: Double => Double): Double => Double = {
    x => f(g(x))
  }

  val x: Double = 5
  val operacionCompuesta:(Double) => Double = aComponer(mas5, cuadrado)
  val resultado = operacionCompuesta(x)

  // Más elegante
  val resultadoCompuesto = aComponer(mas5,cuadrado)(5)
}
