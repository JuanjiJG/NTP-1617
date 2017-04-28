// Vamos a hacer una jerarquía de clases

// Clase A
class A {
  def mensaje = "(A) Saludo desde " + getClass.getName

  override def toString = getClass.getName
}

// Clase B
class B extends A

// Clase C
class C extends B {
  override def mensaje = "Saludo desde C -> " +
    super.mensaje
}

val objA = new A
val objB = new B
val objC = new C

objA.mensaje
objB.mensaje
objC.mensaje

val lista1 = List(new A, new B, new C)
val lista2 = List(new A, new B, new C, 4)

// Polimorfismo
val refA: A = new A
val refB: A = new B
val refC: A = new C

// No puedo hacer esto
// val refB:B = new A