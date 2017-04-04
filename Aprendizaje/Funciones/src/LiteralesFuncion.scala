/**
  * Created by juanjo on 3/04/17.
  */
object LiteralesFuncion {
  val multiplicarPor2 = (x:Int) => x*2

  def calcularMaximo(a:Int, b:Int) = if(a > b) a else b

  val variableFuncion:(Int, Int) => Int = calcularMaximo

  val variableFuncion2 = (a:Int, b:Int) => if(a > b) a else b
}
