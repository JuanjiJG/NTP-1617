/**
  * Created by juanjo on 3/04/17.
  */
object MarcadorPosicion extends App{
  val multiplicarPor2 = (x:Int) => x*2

  // Uso del marcador de posición
  val multiplicarPor2b: Int => Int = _*2

  def combinacion(x:Int, y:Int, f:(Int, Int) => Int) = f(x,y)

  val resultado = combinacion(2, 3, (x,y) => x*y)
  val resultado2 = combinacion(2, 3, _*_)

  def operacionSeguraString(cadena: String,
                            operacion: String => String) = {
    if (cadena == null) cadena
    else operacion(cadena)
  }

  def invertir(cadena: String) = cadena.reverse

  operacionSeguraString("Hola", invertir)
  operacionSeguraString("Hola", _.reverse)
}
