class ClaseParametrizada[A](elemento:A)
      extends Traversable[A] {
  override def foreach[B](f:A=>B)=f(elemento)
}

val obj1 = new ClaseParametrizada("cadena")
obj1.foreach(println)
val cabeza:String=obj1.head

val obj2 = new ClaseParametrizada(8.4)
obj2.foreach(println)
val cabeza2:Double = obj2.head