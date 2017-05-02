abstract class Notificacion

case class Email(direccion:String, titulo:String, cuerpo:String) extends Notificacion

case class SMS(numeroOrigen:String, mensaje:String) extends Notificacion

case class MensajeVoz(contacto:String, enlace:String) extends Notificacion

object ClasesCase2 extends App {
  def mostrarNotificacion(notificacion:Notificacion):String = {
    notificacion match {
      case Email(direccion, titulo, _) =>
        "Recibido correo de " + direccion + " con título " + titulo

      case SMS(numero, mensaje) =>
        "Recibido SMS de " + numero + " con mensaje " + mensaje

      case MensajeVoz(contacto, enlace) =>
        "Recibido mensaje de voz de " + contacto + ". Pulsa el enlace " + enlace + " para escucharlo."
    }
  }

  val mensajeSMS = SMS("12345", "HOLA VARTY :D")
  val mensajeVoz = MensajeVoz("Juanjo", "https://mensajes.com/user/juanjo/mensajes")

  println(mostrarNotificacion(mensajeSMS))
  println(mostrarNotificacion(mensajeVoz))
}
