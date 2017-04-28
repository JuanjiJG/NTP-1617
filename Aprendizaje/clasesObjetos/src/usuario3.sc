// Clase con argumento
class Usuario(nombreUsuario:String) {
  val nombre:String = nombreUsuario

  def prompt:String = s"$nombre>"

  override def toString = s"Usuario ($nombre)"
}

val usuario = new Usuario("Pepe")
println(usuario)
usuario.prompt