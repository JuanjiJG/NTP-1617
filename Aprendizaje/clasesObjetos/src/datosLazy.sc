class PuntoAleatorio {
  val x = {
    println("Asignacion de x: ")
    util.Random.nextInt
  }

  // Lazy evita la inicialización del dato miembro
  // La hará cuando haga alusión, mientras tanto no
  lazy val y = {
    println("Asignación de y: ")
    util.Random.nextInt
  }
}

val p1 = new PuntoAleatorio
println(s"Ubicado en ${p1.x}, ${p1.y}")

// Si vuelvo a llamar a la misma sentencia,
// ya no sale Asignacion de y porque ya la hice antes
println(s"Ubicado en ${p1.x}, ${p1.y}")
