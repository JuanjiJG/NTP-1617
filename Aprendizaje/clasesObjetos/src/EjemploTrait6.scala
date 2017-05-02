class PersonajePelicula(val nombre:String) {
  def sufijo = ""
  override def toString = s"$nombre$sufijo"
}

trait Elfo {self:PersonajePelicula =>
  override def sufijo = "-(elfo)"
}

trait Mago {self:PersonajePelicula =>
  override def sufijo = "-(mago)"
}

trait Aprendiz {self:PersonajePelicula =>
  override def toString = super.toString + "-(L)"
}

object EjemploTrait6 extends App {
  val obj1 = new PersonajePelicula("Harry Potter") with Mago
  val obj2 = new PersonajePelicula("Dobby") with Elfo
  val obj3 = new PersonajePelicula("Luna Lovegood") with Mago with Aprendiz
  println(obj1)
  println(obj2)
  println(obj3)
}