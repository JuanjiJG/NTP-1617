def duplicar(x: Int) = x*2

// Esto es necesario para que
// la asignación quede clara.
val funcion: (Int) => Int = duplicar

funcion(3)

// Lo otro no funciona
// val f = duplicar

val otra = funcion

otra(5)

val funcion2 = duplicar _

def calcularMaximo(a: Int, b: Int) = if (a > b) a else b

val f2 = calcularMaximo _

f2(23, 67)