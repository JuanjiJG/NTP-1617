/**
  * Created by juanjo on 21/03/17.
  */
import scala.io.Source

object ProcesamientoLineas {
  def imprimirLineas(nombreArchivo: String): Unit = {
    val lineas: Seq[String] = Source.fromFile(nombreArchivo).getLines().toList

    for (linea <- lineas)
      println(linea.length + " | " + linea)
  }

  def calcularAnchoTamLinea(linea: String) = linea.length.toString.length

  def imprimirLineasV2(nombreArchivo: String): Unit = {
    val lineas = Source.fromFile(nombreArchivo).getLines().toList

    var maximoAnchoTam = 0
    for (linea <- lineas) {
      maximoAnchoTam = maximoAnchoTam.max(calcularAnchoTamLinea(linea))
    }

    // maximoAnchoTam contiene el maximo espacio para escribir el
    // tamaño de cada linea
    for (linea <- lineas) {
      val tamLinea = calcularAnchoTamLinea(linea)
      val relleno = " " * (maximoAnchoTam - tamLinea)
      println(relleno + linea.length + " | " + linea)
    }
  }

  def imprimirLineasV3(nombreArchivo: String): Unit = {
    val lineas = Source.fromFile(nombreArchivo).getLines().toList

    val lineaMasLarga = lineas.reduceLeft((a, b) => if(a.length > b.length) a else b)

    val maximoAnchoTam = calcularAnchoTamLinea(lineaMasLarga)

    // maximoAnchoTam contiene el maximo espacio para escribir el
    // tamaño de cada linea
    for (linea <- lineas) {
      val tamLinea = calcularAnchoTamLinea(linea)
      val relleno = " " * (maximoAnchoTam - tamLinea)
      println(relleno + linea.length + " | " + linea)
    }
  }

  def main(args: Array[String]): Unit = {
    if (args.length > 0) {
      imprimirLineasV3(args(0))
    }
    else {
      Console.err.println("Introduzca el nombre del archivo")
    }
  }
}
