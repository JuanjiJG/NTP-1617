// Conveniencia: nomenclatura Java
// camelCase: componerValores
// Mayuscula sólo para clases

// Curiosidad: Scala permite usar símbolos especiales como variables
val $3 = 23
var æ:Int = 3
var `b.a`:Int = 10

val var1:Byte = 3

Byte.MaxValue
Byte.MinValue

Short.MaxValue
Short.MinValue

Long.MaxValue
Long.MinValue

Int.MaxValue
Int.MinValue

Float.MaxValue
Float.MinValue
Float.MinPositiveValue

Double.MaxValue
Double.MinValue
Double.MinPositiveValue

// Conversiones de ensanchamiento
var var2:Short = 3
var var3:Double = var2

var2 = var3.toByte

val var5 = 0xff1956
val var6 = 10l
