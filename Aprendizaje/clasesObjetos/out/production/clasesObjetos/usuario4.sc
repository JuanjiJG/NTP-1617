// Clase con datos miembro como parámetros
class Usuario(val nombre:String) {
  def prompt = s"$nombre>"

  override def toString = s"Usuario ($nombre)"
}

val usuario = new Usuario("Pepe")

val usuarios = List(new Usuario("Pepe"),
                    new Usuario("Luis"),
                    new Usuario("Andrés"))

val longitudes = usuarios map (_.nombre.size)
val longitudes1 = usuarios map (objeto => objeto.nombre.size)

val conD = usuarios.filter(_.nombre contains "d")
val promptContD = conD map (_.prompt)
