// Función más sencilla
def saludo = "Hola"

saludo

def saludo1:String = "Hola"

def multiplicar(x: Int, y: Int) = x*y
val resultado = multiplicar(3,5)

def quitarBlancosIniciales(s: String): String = {
  if (s == null) return null
  s.trim()
}

val res11 = quitarBlancosIniciales(null)
val res22 = quitarBlancosIniciales("     Pepe     .")

// Procedimiento
// Es una función que no devuelve nada
def mostrar(d: Double): Unit = {
  println(f"Valor = $d%.2f")
}

mostrar(2.45678)

// Usar bloques en la llamada
mostrar(2.785*0.15+24)
