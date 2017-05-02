val d1 = new java.util.Date

import java.util.Date

val d2 = new Date

import java.util

val d3 = new util.Date

// El equivalente al * en Java es el _ en Scala
// import collection.mutable._

// Pero puedo usar corchetes
// y traerme varias de una vez
import collection.mutable.{ArrayBuffer, Queue}

val obj1 = new ArrayBuffer[String]()
obj1 + "Hola"

val obj2 = new Queue[Int]
obj2.enqueue(3,4,5)
val x = obj2.dequeue()

def generarNumeroAleatorio(): Unit = {
  import java.util.Random

  val generador = new Random
  generador.nextInt()
}

import java.util.Random
val generador:Random = new Random

// Puedo ponerle alias a las clases que importo
import collection.mutable.{Map => MutMap}

val m1 = Map(1 -> 2)
val m2 = MutMap(2 -> 3)
