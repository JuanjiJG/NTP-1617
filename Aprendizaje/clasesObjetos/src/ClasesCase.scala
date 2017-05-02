// "nombre" y "heroe" son datos miembro val por defecto
case class Personaje(nombre:String, heroe: Boolean)

object ClasesCase extends App {
  val personaje1 = Personaje("Gollum", false)
  val personaje2 = Personaje("KORJI", true)

  // Gracias al uso de case puedo usar equals (==)
  val comparacion = personaje1 == personaje2
  println(comparacion)

  // Tambien puedo usar toString
  println(personaje1)

  // Puedo hacer una copia modificando algunos datos miembro
  val personaje3 = personaje1.copy("VARTY")

  // Uso de unapply
  val resultado = Personaje.unapply(personaje1)
  println(resultado)
}
