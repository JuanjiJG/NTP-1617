/**
  * Clase Coche con datos miembro
  * @param marca
  * @param enUso
  */
class Coche(val marca:String, var enUso:Boolean = false) {
  def reservar(r:Boolean):Unit = {
    enUso = r
  }

  override def toString = s"$marca - $enUso"
}

val c1 = new Coche("Toyota", true)
c1.reservar(false)
println(c1)

class Renault(val color:String, enUso:Boolean = false)
      extends Coche("Renault", enUso) {
  override def toString = s"$marca - $enUso - $color"
}

val c2 = new Renault("Rojo")
println(c2)
