import scala.collection.immutable.Seq

/**
  * Created by juanjo on 28/03/17.
  */
object MetodosGenericos extends App {
  def eliminarPrimero[A](lista: List[A]) = lista.tail

  var resultado1: Seq[Int] = eliminarPrimero(List(1,2,3))
  var resultado2: Seq[Double] = eliminarPrimero(List(3.5, 8.3, 2.0))
  var resultado3: Seq[String] = eliminarPrimero(List("Hola", "Adios"))
}
