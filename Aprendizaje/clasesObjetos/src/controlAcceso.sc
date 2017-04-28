class Usuario(private var password:String) {
  def actualizarPassword(p:String):Unit = {
    password = p
  }

  def validar(p:String) = p == password
}

val usuario = new Usuario("1234")
val eValido = usuario.validar("4567")
usuario.actualizarPassword("4567")
val esValido2 = usuario.validar("4567")

// Esto no es accesible fuera de la clase
// usuario.password

