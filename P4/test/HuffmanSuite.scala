import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {

  // Se importan las funciones necesarias
  import CodigoHuffman._

  /**
    * Prueba inicial. Comprobar si se genera el mismo árbol que el ejemplo inicial del guión
    */
  test("Se genera el árbol de ejemplo") {
    val arbolEjemploOriginal = NodoInterno(
      NodoHoja('A', 8),
      NodoInterno(
        NodoInterno(
          NodoInterno(
            NodoHoja('H', 1),
            NodoHoja('D', 1),
            List('H', 'D'), 2),
          NodoInterno(
            NodoHoja('G', 1),
            NodoHoja('C', 1),
            List('G', 'C'), 2),
          List('H', 'D', 'G', 'C'), 4),
        NodoInterno(
          NodoInterno(
            NodoHoja('E', 1),
            NodoHoja('F', 1),
            List('E', 'F'), 2),
          NodoHoja('B', 3),
          List('E', 'F', 'B'), 5),
        List('H', 'D', 'G', 'C', 'E', 'F', 'B'), 9),
      List('A', 'H', 'D', 'G', 'C', 'E', 'F', 'B'), 17)

    val listaCharsEjemplo = stringToCharList("AAAAAAAABBBCDEFGH")

    val arbolCodificacion = crearArbolDeCodificacion(listaCharsEjemplo)

    // Comprobamos que ambos árboles son iguales
    assert(arbolEjemploOriginal == arbolCodificacion, "Fallo: los árboles de codificación no coinciden")
  }

  /**
    * Prueba sobre el idioma francés
    */
  test("Probando sobre el idioma francés") {
    // Codigo Huffman para el lenguaje frances, obtenido a partir de la pagina
    // web http://fr.wikipedia.org/wiki/Fr%C3%A9quence_d%27apparition_des_lettres_en_fran%C3%A7ais
    val codigoHuffmanFrances: Nodo = NodoInterno(
      NodoInterno(
        NodoInterno(
          NodoHoja('s', 121895),
          NodoInterno(
            NodoHoja('d', 56269),
            NodoInterno(
              NodoInterno(
                NodoInterno(
                  NodoHoja('x', 5928),
                  NodoHoja('j', 8351),
                  List('x', 'j'), 14279),
                NodoHoja('f', 16351),
                List('x', 'j', 'f'), 30630),
              NodoInterno(
                NodoInterno(
                  NodoInterno(
                    NodoInterno(
                      NodoHoja('z', 2093),
                      NodoInterno(
                        NodoHoja('k', 745),
                        NodoHoja('w', 1747),
                        List('k', 'w'), 2492),
                      List('z', 'k', 'w'), 4585),
                    NodoHoja('y', 4725),
                    List('z', 'k', 'w', 'y'), 9310),
                  NodoHoja('h', 11298),
                  List('z', 'k', 'w', 'y', 'h'), 20608),
                NodoHoja('q', 20889),
                List('z', 'k', 'w', 'y', 'h', 'q'), 41497),
              List('x', 'j', 'f', 'z', 'k', 'w', 'y', 'h', 'q'), 72127),
            List('d', 'x', 'j', 'f', 'z', 'k', 'w', 'y', 'h', 'q'), 128396),
          List('s', 'd', 'x', 'j', 'f', 'z', 'k', 'w', 'y', 'h', 'q'), 250291),
        NodoInterno(
          NodoInterno(
            NodoHoja('o', 82762),
            NodoHoja('l', 83668),
            List('o', 'l'), 166430),
          NodoInterno(
            NodoInterno(
              NodoHoja('m', 45521),
              NodoHoja('p', 46335),
              List('m', 'p'), 91856),
            NodoHoja('u', 96785),
            List('m', 'p', 'u'),
            188641),
          List('o', 'l', 'm', 'p', 'u'), 355071),
        List('s', 'd', 'x', 'j', 'f', 'z', 'k', 'w', 'y', 'h', 'q', 'o', 'l', 'm', 'p', 'u'), 605362),
      NodoInterno(
        NodoInterno(
          NodoInterno(
            NodoHoja('r', 100500),
            NodoInterno(
              NodoHoja('c', 50003),
              NodoInterno(
                NodoHoja('v', 24975),
                NodoInterno(
                  NodoHoja('g', 13288),
                  NodoHoja('b', 13822),
                  List('g', 'b'), 27110),
                List('v', 'g', 'b'), 52085),
              List('c', 'v', 'g', 'b'), 102088),
            List('r', 'c', 'v', 'g', 'b'), 202588),
          NodoInterno(
            NodoHoja('n', 108812),
            NodoHoja('t', 111103),
            List('n', 't'), 219915),
          List('r', 'c', 'v', 'g', 'b', 'n', 't'), 422503),
        NodoInterno(
          NodoHoja('e', 225947),
          NodoInterno(
            NodoHoja('i', 115465),
            NodoHoja('a', 117110),
            List('i', 'a'), 232575),
          List('e', 'i', 'a'), 458522),
        List('r', 'c', 'v', 'g', 'b', 'n', 't', 'e', 'i', 'a'), 881025),
      List('s', 'd', 'x', 'j', 'f', 'z', 'k', 'w', 'y', 'h', 'q', 'o', 'l', 'm', 'p', 'u', 'r', 'c', 'v', 'g', 'b', 'n', 't', 'e', 'i', 'a'), 1486387)

    // Mensaje secreto a decodificar
    val mensajeSecretoFrances: List[Int] = List(0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0,
      0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 1, 1,
      0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1)

    // Mensaje en francés ya decodificado
    val mensajeDecodificado = decodificar(codigoHuffmanFrances, mensajeSecretoFrances)

    // Probamos a codificar con la tabla para probar que obtenemos el mismo mensaje codificado
    val mensajeCodificadoConTabla = codificacionRapida(codigoHuffmanFrances)(mensajeDecodificado)

    // Probamos que el mensaje decodificado es el esperado, tal y como se indica en el guion
    assert(mensajeDecodificado.mkString == "huffmanestcool", "Error: no coincide el mensaje decodificado con el esperado")

    // Probamos que la codificación con tabla funciona bien
    assert(mensajeSecretoFrances == mensajeCodificadoConTabla, "Error: la codificación con tabla no produce el mismo resultado que el mensaje secreto")
  }

  /**
    * Prueba sobre el idioma español
    */
  test("Probando sobre el idioma español") {
    // Obtener arbol de codificacion del libro La Regenta
    val arbolCodificacionRegenta = crearArbolDeCodificacion(stringToCharList(leerArchivo("data/regenta.txt")))

    // Se decodifica este mensaje secreto
    val mensajeSecretoEsp = List(0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1,
      0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0,
      1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0,
      0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1,
      1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0,
      0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1,
      1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1)

    // Mensaje en español ya decodificado
    val mensajeDecodificado = decodificar(arbolCodificacionRegenta, mensajeSecretoEsp)

    // Probamos que el mensaje decodificado es el esperado, tal y como se indica en el guion
    assert(mensajeDecodificado.mkString == "La regenta de Benito Perez Galdos", "Error: no coincide el mensaje decodificado con el esperado")
  }
}
