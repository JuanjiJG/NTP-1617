/**
  * Created by juanjo on 3/04/17.
  */
object FuncionesParciales extends App {
  val gestorErrores : Int => String = {
    case 200 => "Funcionamiento correcto"
    case 400 => "Error tipo 1"
    case 500 => "Error tipo 2"
  }

  val resultado = gestorErrores(500)

  def operacionSeguraString(cadena: String,
                            operacion: String => String) = {
    if (cadena == null) cadena
    else operacion(cadena)
  }

  val resultado2 = operacionSeguraString("Hola, Pepe", {
    s => {
      val hora = System.currentTimeMillis()
      val cadenaFinal = s + "(" + hora + ")"
      cadenaFinal.toUpperCase
    }
  })
}
