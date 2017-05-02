class Multiplicador(val x:Int) {
  def producto(y:Int) = x*y
}

// Relacion clase - objeto companion para facilitar el mecanismo de creacion de objetos: factoria
object Multiplicador {
  def apply(x:Int) = new Multiplicador(x)
}
object ejemploObjeto3 extends App {
  val porTres = new Multiplicador(3)
  val red1 = porTres.producto(5)

  // Simplificar la construcción de objetos
  val porCinco = Multiplicador(5)
  val res2 = porCinco.producto(5)
}
