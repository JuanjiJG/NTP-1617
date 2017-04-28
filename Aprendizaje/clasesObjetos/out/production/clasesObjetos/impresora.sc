class Impresora(mensaje:String) {
  def imprimir(cadena:String):Unit = {
    println(s"$mensaje: $cadena")
  }

//  def imprimir(cadena:String):Int = {
//
//  }

  def imprimir(cadenas:Seq[String]):Unit = {
    println(mensaje, cadenas.mkString("\n"))
  }
}

val objeto = new Impresora("Samgung SCX-3400")
objeto.imprimir("Documento corto")
objeto.imprimir("linea1" :: "linea2" :: "linea3" :: Nil)

// Uso del método "apply"
class Multiplicador(factor:Int) {
  def apply(valor:Int) = valor*factor
}

val porTres = new Multiplicador(3)
porTres.apply(10)
val resultado = porTres(8)

val lista = List(1, 2, 3, 4, 5)
val valor1 = lista(1)
val valor2 = lista.apply(3)
