abstract class Coche {
  val fechaCompra:Int
  val automatico:Boolean = true
  def color:String
}

class Mini(val fechaCompra:Int, val color:String)
          extends Coche

val c2:Coche = new Mini(2015, "Rojo")

// Aclaración sobre la clase de ayer

// Una clase en Scala puede verse como un
// constructor y se va a ejecutar lo que
// tiene dentro
class Ejemplo(nombre:String) {
  def mostrar():Unit = {
    println("En la clase Ejemplo")
  }
  println("En el cuerpo de la clase")
  println("Nombre: " + nombre)
}

val c3 = new Ejemplo("Pepe")

// Esto no se puede hacer porque "nombre"
// realmente no es un dato miembro,
// sino un parámetro
// println(c3.nombre)
// Lo puedo hacer si le pongo val al principio

abstract class Listener {
  def trigger
}

// Dos formas de implementar una clase abstracta

// 1.- Creando una completa paso a paso
class miGestor extends Listener {
  def trigger:Unit = {
    println(s"Activación en tiempo ${new java.util.Date}")
  }
}

val gestor = new miGestor
gestor.trigger

// 2.- Directamente al instanciarla con new
// Es como crearlas "en tiempo de ejecución"
val miListener = new Listener {
  def trigger:Unit = {
    println(s"Activación en tiempo ${new java.util.Date}")
  }
}

miListener.trigger

val otroListener = new Listener {
  def trigger:Unit = {
    println(s"Activación en otroListener en tiempo ${new java.util.Date}")
  }
}

otroListener.trigger