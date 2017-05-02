trait UtilidadesHtml2 {
  def quitarMarca(entrada: String): String = {
    entrada.replaceAll("""</?\w[^<]*>""","").
      replaceAll("<.*>","")
  }
}

trait OperacionSeguraString {
  def eliminarEspacios(cadena:String):Option[String] = {
    Option(cadena) map(_.trim) filterNot(_.isEmpty)
  }
}

class Pagina(val contenido:String) extends UtilidadesHtml2 with OperacionSeguraString {
  def comoTextoPlano = quitarMarca(contenido)
}

object EjemploTrait extends App {
  val pagina = new Pagina("<html><body><h1>Introduccion</h1></body></html>")
  println(pagina.comoTextoPlano)
  println(pagina.eliminarEspacios("Hola a todos"))
}
