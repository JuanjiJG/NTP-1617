// Match es una sentencia muy potente
val x = 10
val y = 3

val maximo =  x > y match {
  case true => x
  case false => y
}

var error = 500

/*
¿Qué devuelve esto? Es String,
porque es lo que los cases devuelven
 */
val mensaje = error match {
  case 200 => "OK"
  case 400 => {
    println("Error de ejecución")
    "Error 400: ..."
  }
  case 500 => {
    println("Error sintáctico")
    "Error 500: ..."
  }
}

val dia = "lunes"
val laborable = dia match {
  case "lunes" | "martes" | "miércoles" | "jueves" | "viernes" => "laborable"
  case "sabado" | "domingo" => "festivo"
}

// Caso default
// Forma 1
val mensaje1 = "cualquiercosa"
val estado = mensaje1 match {
  case "OK" => 200
  case otro => {
    println(s"Recibido: $otro")
    -1
  }
}

// Forma 2
// Nótese el uso de "_" como placeholder
/*
val mensaje1 = "cualquier cosa"
val estado = mensaje1 match {
  case "OK" => 200
  case _ => {
    println(s"Recibido: $mensaje1")
    -1
  }
}
 */