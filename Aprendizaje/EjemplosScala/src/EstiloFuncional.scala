/**
  * Created by juanjo on 21/03/17.
  */
object EstiloFuncional {
  def imprimirArgumentos(args: Array[String]): Unit = {
    var i = 0
    while(i < args.length) {
      println(args(i))
      i += 1
    }
  }

  def imprimirArgumentosFuncional(args: Array[String]): Unit = {
    for(arg <- args) println(arg)

    args.foreach(println)
  }

  def imprimirArgumentosFuncional2(args: Array[String]): String = {
    args.mkString(" - ")
  }

  def main(args: Array[String]): Unit = {
    val cadena = imprimirArgumentosFuncional2(args)
    println(cadena)
    assert(cadena == "Hola - Pepe - 23.8 - true")
  }
}
