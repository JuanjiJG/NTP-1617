abstract class Listener {
  def trigger
}

class Listening {
  var listener:Listener = null
  def registrar(l:Listener) = {
    listener = l
  }
  def notificar():Unit = {
    listener.trigger
  }
}

val obj1 = new Listening

obj1.registrar(new Listener {
  def trigger:Unit = {
    println("Activación de elemento")
  }
})

obj1.notificar()
obj1.listener.getClass.getName