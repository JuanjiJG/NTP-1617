val respuesta = null

val mensaje = respuesta match {
  case s if s != null => println(s"Recibido: %s")
  case s => println("Error: cadena nula")
}

val x:Int = 12345

val y:Any = x

val respuesta1 = y match {
  case z:String => s"$z - String"
  case z:Double => f"$z%.2f - Double"
  case z:Float => f"$z%.2f - Float"
  case z:Long => s"${z} - Long"
  case z:Int => s"${z} - Int"
}