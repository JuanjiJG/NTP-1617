4

'a'

"Hola, mundo"

(x:Int, y:Int) => x+y

// Valores: val
val y = 8

// Variables: var
var x = 23.7

// Todo tiene tipo asociado
3.getClass.getName
8.3.getClass.getName
'c'.getClass.getName
"Hola, Pepe".getClass.getName
true.getClass.getName

var f = (x:Int, y:Int) => x+y
f(2, 3)
f.getClass.getName
f.apply(2, 3)
f = (x:Int, y:Int) => x*y

// Concepto de inmutabilidad
val array:Array[Int] = new Array(10)
array.length
array(1) = 3

// array = new Array(3)

class NumeroComplejo(val x:Double, val y:Double)
val nc1 = new NumeroComplejo(2.3, 4.7)
println("x: " + nc1.x + " y: " + nc1.y)
nc1.x = 3.4
