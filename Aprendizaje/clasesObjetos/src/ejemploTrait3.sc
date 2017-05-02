class A1 {
  def mostrar = "Clase A1"
}

trait B1 {self:A1 =>
  override def toString = "B: " + mostrar
}

// Esto no sirve porque B1 solo sirve para A1
// y no mantiene ninguna relación con C
// class C extends B1

// Esto ya si sirve
class C  extends A1 with B1

val obj = new C

// Puedo añadir el trait cuando estoy instanciando
// Puedo ir instanciando objetos con funcionalidades
// diferentes
// "Stackable trait"
val a = new A1 with B1