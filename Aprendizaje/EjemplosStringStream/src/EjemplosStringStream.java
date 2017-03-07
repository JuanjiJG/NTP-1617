import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mgomez on 21/2/17.
 */
public class EjemplosStringStream {
    // Dato miembro para almacenar las cadenas de caracteres con las que probar
    private String[] cadenas = {"Rojo", "Naranja", "Amarillo", "Verde", "Azul", "Indigo", "Violeta"};

    public List<String> pasarMayusculas() {
        // Si solo hay un argumento, podemos simplificar las expresiones Lambda
        List<String> listaCadenas = Arrays.stream(this.cadenas).map(String::toUpperCase).collect(Collectors.toList());

        return Arrays.stream(this.cadenas).
                map(x -> x.toUpperCase()).
                collect(Collectors.toList());
    }

    public List<String> filtrarOrdenar() {
        return Arrays.stream(this.cadenas).
                filter(cadena -> cadena.compareToIgnoreCase("m") > 0).
                sorted(String.CASE_INSENSITIVE_ORDER).
                collect(Collectors.toList());
    }

    public List<String> filtrarOrdenarInvertido() {
        return Arrays.stream(this.cadenas).
                filter(cadena -> cadena.compareToIgnoreCase("m") > 0).
                sorted(String.CASE_INSENSITIVE_ORDER.reversed()).
                collect(Collectors.toList());
    }

    /**
     * Método main para pruebas
     *
     * @param args
     */
    public static void main(String args[]) {
        // Prueba del metodo de paso a mayusculas
        // Se crea objeto de la clase
        EjemplosStringStream objeto = new EjemplosStringStream();

        // Ejemplo de pasar a mayusculas
        System.out.println(objeto.pasarMayusculas());

        // Ejemplo de filtrado y ordenado
        List<String> cadenasProcesadas = objeto.filtrarOrdenar();
        cadenasProcesadas.stream().forEach(System.out::println);

        System.out.println("---Ahora invertidas---");
        // Ejemplo de filtrado y ordenado inverso
        List<String> cadenasProcesadasInvertidas = objeto.filtrarOrdenarInvertido();
        cadenasProcesadas.stream().forEach(System.out::println);
    }
}
