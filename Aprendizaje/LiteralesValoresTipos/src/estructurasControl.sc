// Definición de rangos
val x = 1 to 6
val y = 1 until 10

// Indicación del paso
val z = 1 to 7 by 2

// Posibilidad de definir pasos negativos
val w = 10 to 1 by -1

// For comprehension
// Es una expresión que ayuda a seguir
// el paradigma de prog. funcional

// Dentro del for podemos meter expresiones
// o variables que las contengan
for(x <- y) {
  println(x)
}

// Uso de yield para poder recuperar
// el resultado de la operación
for(x <- 1 to 7) yield {
  println(x)
  x
}

// Es posible definir condiciones
val mult3 = for(i <- 1 to 1000
                if i%3 == 0
                if i > 100
                if i%7 == 0) yield i

