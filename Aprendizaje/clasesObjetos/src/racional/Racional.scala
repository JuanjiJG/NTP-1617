package racional

/**
  * Created by juanjo on 2/05/17.
  */
class Racional(n:Int, d:Int) {
  // Creación de guarda o condición para crear objetos
  require(d != 0)

  private val mcd = maximoComunDivisor(n, d)

  val numerador:Int = n/mcd
  val denominador:Int = d/mcd

  // Constructor auxiliar. Todos han de llamarse siempre "this"
  def this(n:Int) = this(n,1)

  override def toString = numerador + "/" + denominador

  def menorQue(otro:Racional) = {
    numerador * otro.denominador < denominador * otro.numerador
  }

  // Calcular MCD para simplificar la fracción
  private def maximoComunDivisor(a:Int, b:Int):Int = {
    if (b == 0) a
    else maximoComunDivisor(b, a%b)
  }
}

object EjemploUso extends App {
  val obj1 = new Racional(2,3)
  //Este segundo objeto no se puede hacer porque no cumple un requisito
  // val obj2 = new Racional(5,0)
  val obj3 = new Racional(5)
  val obj4 = new Racional(8,16)
  println(obj4)
}