//// Si la definicion de la clase incluye un "final",
//// ya ninguna podría heredar de A
//// Si ponemos sealed, la definicion de la clase debe estar en el mismo archivo
//// para poder hacer herencia
//sealed class A2(final val datoFinal:Int, val datoNormal:Int) {
//  final override def toString():String = {
//    println(s"datoFinal: $datoFinal - datoNormal: $datoNormal")
//  }
//}
//
//class B1(val dato1:Int, val dato2:Int) extends A2(dato1, dato2) {
//  // Esto no funciona porque toString es "final"
//  // override def toString:String = "asdasd"
//}
//
//val obj1:A2 = new B1(23, 15)
//
//class EjemploFinal {
//
//}
