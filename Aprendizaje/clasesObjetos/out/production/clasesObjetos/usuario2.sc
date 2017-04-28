// Clase con datos y métodos
class Usuario {
  val nombre:String = "administrador"
  def prompt:String = s"$nombre>"
  override def toString = s"toString de esta clase: Usuario ($nombre)"
  println("En clase Usuario")
}

// Cuando esto se ejecute
// se mostrará su toString
val usuario = new Usuario

println(usuario)
println(usuario.prompt)
