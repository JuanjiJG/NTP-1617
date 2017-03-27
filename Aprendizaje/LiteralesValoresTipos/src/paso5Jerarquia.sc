val x = 3

x.isInstanceOf[Any]
// En Scala 2.12 funciona esto:
// x.isInstanceOf[AnyVal]

class NumeroComplejo(val x:Double, val y:Double)

val objeto1 = new NumeroComplejo(2.3, 4.5)

objeto1.isInstanceOf[AnyRef]

// Tipo Unit como ausencia de datos
val nada = ()
println("Hola, mundo")

val t:Char = 65
val tEntero = t.asInstanceOf[Int]
