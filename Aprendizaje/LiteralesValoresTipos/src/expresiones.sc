// Las expresiones generan resultados
20+10

// Inicializaciones de variables con expresiones
val x1 = 30*15

/*
Nota: si queremos escribir varias cosas en
la misma linea, necesitamos el signo ;
 */
val cantidad1 = {
  val x = 50*20; x+10
}

{val a=1; {val b=a*2; {val c=b+4; c}}}

/*
Como es una sentencia y no una expresión,
no devuelve nada, sino Unit
 */
if (47%3 > 0) println("No es múltiplo de 3")

val x = 10
val y = 3
val maximo = if(x > y) x else y

// Promover el resultado hacia el tipo AnyVal
val maxX = if(x > y) true

