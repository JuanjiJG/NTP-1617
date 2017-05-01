import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class BusquedaBinariaSuite extends FunSuite {

  // Se importa la clase donde estan definidas las funciones a probar
  import Main.busquedaBinariaGenerica

  // Prueba 1: Si la lista está vacía, debe devolver falso
  test("Búsqueda binaria: La lista está vacía, debe devolver falso") {
    var lista1: Array[Int] = Array()
    assert(!busquedaBinariaGenerica(lista1, 1, (x: Int, y: Int) => (x < y)))
  }

  // Prueba 2: No se encuentra en una lista impar, debe devolver falso
  test("Búsqueda binaria: No se encuentra en una lista impar, debe devolver falso") {
    var lista2: Array[Int] = Array(0, 2, 4, 6, 8, 10, 12, 14, 16)
    assert(!busquedaBinariaGenerica(lista2, 9, (x: Int, y: Int) => (x < y)))
  }

  // Prueba 3: No se encuentra en una lista par, debe devolver falso
  test("Búsqueda binaria: No se encuentra en una lista par, debe devolver falso") {
    var lista3: Array[Int] = Array(0, 2, 4, 6, 8, 10, 12, 14, 16, 18)
    assert(!busquedaBinariaGenerica(lista3, 9, (x: Int, y: Int) => (x < y)))
  }

  // Prueba 4: Se encuentra el primero en la lista, debe devolver verdadero
  test("Búsqueda binaria: Se encuentra el primero en la lista, debe devolver verdadero") {
    var lista4: Array[Int] = Array(0, 2, 4, 6, 8, 10, 12, 14, 16)
    assert(busquedaBinariaGenerica(lista4, 0, (x: Int, y: Int) => (x < y)))
  }

  // Prueba 5: Se encuentra el último en la lista, debe devolver verdadero
  test("Búsqueda binaria: Se encuentra el último en la lista, debe devolver verdadero") {
    var lista5: Array[Int] = Array(0, 2, 4, 6, 8, 10, 12, 14, 16)
    assert(busquedaBinariaGenerica(lista5, 16, (x: Int, y: Int) => (x < y)))
  }

  // Prueba 6: Se encuentra en el medio en la lista, debe devolver verdadero
  test("Búsqueda binaria: Se encuentra en el medio en la lista, debe devolver verdadero") {
    var lista6: Array[Int] = Array(0, 2, 4, 6, 8, 10, 12, 14, 16)
    assert(busquedaBinariaGenerica(lista6, 8, (x: Int, y: Int) => (x < y)))
  }

  // Prueba 7: Usando tipo Char, debe encontrar el carácter y devolver verdadero
  test("Búsqueda binaria: Buscar un carácter en una lista de caracteres") {
    var lista7: Array[Char] = Array('a', 'd', 'f', 'h', 'm', 'o', 'r')
    assert(busquedaBinariaGenerica(lista7, 'h', (x: Char, y: Char) => (x < y)))
  }
}
