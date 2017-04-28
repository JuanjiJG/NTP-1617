package pruebaAccesibilidad1

// Puedo definir que la clase sea privada fuera del paquete
// Las clases que haya dentro del paquete si pueden verla
private [pruebaAccesibilidad1] class Autenticacion {
  val url="http://localhost"
}

class Autenticacion {
  // Password es privado para cada instancia
  // Otra instancia de Autenticacion no podría ver el password de esta instancia
  private [this] val password = "1234"

  def validar = password.size > 0

  def comparar(otro:Autenticacion):Boolean = {
    // Esto no funciona por lo dicho anteriormente
    // password == otro.password
  }
}