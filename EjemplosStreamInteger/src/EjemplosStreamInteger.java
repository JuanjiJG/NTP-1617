import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by mgomez on 20/2/17.
 */
public class EjemplosStreamInteger {

    // Dato miembro para almacenar valores
    // Dato miembro para almacenar los valores
    private Integer valores[];

    // Constructor de la clase
    public EjemplosStreamInteger(int numeroValores) {
        // Se reserva espacio para el array
        valores = new Integer[numeroValores];

        // Se generan valores aleatorios entre 0 y 100
        // para rellenar el array
        Random generador = new Random();
        for (int i = 0; i < numeroValores; i++) {
            valores[i] = generador.nextInt(101);
        }
    }

    public List<Integer> ordenarValores() {
        Stream<Integer> flujo = Arrays.stream(this.valores);
        return flujo.sorted().collect(Collectors.toList());
    }

    public List<Integer> filtarValoresMayoresQueCuatro() {
        Stream<Integer> flujo = Arrays.stream(this.valores).filter(x -> x > 4);
        return flujo.sorted().collect(Collectors.toList());
    }

    // Main para prueba
    public static void main(String args[]) {
        // Se crea objeto de la clase
        EjemplosStreamInteger objeto = new EjemplosStreamInteger(10);
        System.out.println(objeto.ordenarValores());
        System.out.println(objeto.filtarValoresMayoresQueCuatro());
    }
}
