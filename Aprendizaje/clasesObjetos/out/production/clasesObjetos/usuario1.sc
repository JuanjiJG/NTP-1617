// La clase más sencilla
class Usuario

// Creación de objetos de la clase
// Puedo usar los paréntesis o no
// (Constructor por defecto de la clase
// no tiene argumentos)
val usuario = new Usuario

// El método toString mostrará la dirección
// de memoria donde estará almacenado

// Any es el equivalente en Scala
// a Object en Java

// Las clases que hacemos son herencia de
// AnyRef
val esAnyRef = usuario.isInstanceOf[AnyRef]
