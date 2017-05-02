object Saludo {
  println("En objeto: Saludo")
  def saludar = "Hola"
}

object ejemploObjeto1 extends App {
  println(Saludo.saludar)
  println(Saludo.saludar)
}