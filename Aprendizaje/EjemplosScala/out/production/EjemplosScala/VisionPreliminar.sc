1+7

println("Hola, mundo")

// Esto es como null
()

// Diferencia entre val y var
// Usando val, vemos que no se genera un "res0"
// Es una sentencia
val mensaje = "Hola, mundo"

// Esto no se puede hacer
// mensaje = "Adios, Pepe"

// Con var si podemos redefinir
var saludo = "Hola, Pepe"
saludo = "Adios, Pepe"

// Definición de funciones
def max(x: Int, y: Int): Int = {
  if (x > y) x
  else y
}

def max2(x: Int, y: Int) = if (x > y) x else y
max2(8, 10)

def mostrarSaludo = "Hola, mundo"

// Esto no es correcto
// mostrarSaludo()

// Esto sí funciona
mostrarSaludo

// Estructuras de control en Scala

// Estructura while (sentencia)
var i: Int = 10

while(i > 0) {
  println("Valor de i: " + i)
  i = i-1
}

i = 10
do {
  println("Valor de i en do-while: " + i)
  i = i-1
} while(i >= 0)

// Expresion for for-comprehension
val x = 1 to 10
val y = 1 until 10
val z = 1 to 10 by 2
val w = 10 to 1 by -2

for (1 <- 1 to 10) {
  println("Valor de i: " + i)
}

// Con yield generamos un valor
for (i <- 1 to 10) yield i
for (i <- 1 to 10) yield {s"Valor de i: $i"}

for (i <- 1 to 2) yield {
  println("Valor de i: " + i)
  i
}

// Esto puede que no funcione en versiones
// anteriores de Scala
for (i <- 1 to 5;
     j <- 2 to 4) {
  println("(" + i + ", " + j + ")")
}

// Usando el convenio de Scala, evitamos el punto y coma
// cuando utilicemos varios generadores
for {i <- 1 to 5
     j <- 2 to 4} {
  println("(" + i + ", " + j + ")")
}

// Parametrización
// La variable de referencia es inmutable
// Sus componentes SI son mutables
val saludos = new Array[String](3)

saludos(0) = "Hola, "
saludos(1) = "mundo "
saludos(2) = "cruel."

for (i <- 0 until saludos.length) {
  println(saludos(i))
}

// Creación de listas
// En algunas clases no necesitamos new para crear objetos
// Esto se logra con el uso del patrón factoría
val lista1 = List(1, 2, 3, 4)
val lista2 = List(5, 6)

// Concatenación: operador :::
val lista12 = lista1:::lista2

// Agregar elemento al principio
// val lista3 = 1:::lista1

// Programación funcional incorporada
// en la clase (no flujo previo)
val mayor2 = lista1.filter(x => x > 2)

val cuantosMayor2 = lista1.count(x => x > 2)

// Conjunto de operaciones muy amplio
lista1.drop(2)
lista1.dropRight(2)
println(lista1)

val resultado = lista1.exists(x => x%2 == 0)

lista1.length
lista1.head
lista1.tail

lista1.foreach(x => println(x))

val tupla1 = (1, "lunes", true)

// Los elementos se acceden con
// ._indice (empezando en 1)
tupla1._1
tupla1._3

val tupla2 = (1, 28.9)
tupla2.swap

println(tupla1)

val ciudades = Set("Granada", "Almería", "Jaen")

ciudades += "Málaga"

println(ciudades)

import scala.collection.mutable.Set
val asignaturas = Set("Fisica", "Matemáticas")

import scala.collection.mutable.HashSet
val conjunto = HashSet("Granada", "Malaga", "Almeria")

// Por defecto los mapas son inmutables
val dias = Map(1 -> "Lunes", 2 -> "Martes")

println(dias)