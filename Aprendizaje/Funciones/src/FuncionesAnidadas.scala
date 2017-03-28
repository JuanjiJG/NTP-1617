/**
  * Created by juanjo on 28/03/17.
  */
object FuncionesAnidadas {
  /**
    * Función para calcular el máximo de tres valores
    *
    * @param x el primer valor
    * @param y el segundo valor
    * @param z el tercer valor
    * @return un entero que representa el máximo de tres valores
    */
  def max(x:Int, y:Int, z:Int) = {
    // Función auxiliar para dos valores
    def max(x:Int, y:Int) = if (x > y) x else y

    max(x, max(y, z))
  }
}
