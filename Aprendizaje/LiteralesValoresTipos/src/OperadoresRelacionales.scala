/**
  * Created by juanjo on 27/03/17.
  */
object OperadoresRelacionales extends App {
  // Como extiende a App, es como si ya fuera un main el cuerpo de este object

  // Operadores relacionales:
  // - Versión doble (&&): ejecución lazy (se detiene la comprobación en cuanto se puede evaluar)
  // - Versión simple (&)

  val a = 9
  val b = 7

  lazy val condicion1 = {
    if (a > b) {
      println("Comprobación de condición 1: a > b")
      true
    }
    else {
      println("Comprobación de condición 1: a <= b")
      false
    }
  }

  lazy val condicion2 = {
    if ((a+b) % 2 == 0) {
      println("Comprobación de condición 2: Par")
      true
    }
    else {
      println("Comprobación de condición 2: Impar")
      false
    }
  }

  val resultado1:Boolean = (condicion1 || condicion2)
  val resultado2:Boolean = (condicion1 | condicion2)
}
