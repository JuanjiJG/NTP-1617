import java.security.SecureRandom;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by juanjo on 7/03/17.
 */
public class NumerosAleatorios {
    public static void main(String args[]) {
        // Generador de números aleatorios
        SecureRandom generador = new SecureRandom();

        // Especificar el número de muestras
        long muestras = 100_000_000;

        // Generar las muestras
        // Con boxed hacemos que los números sean tratados como
        // Integer, como el dato primitivo (clases wrapper).
        // Como quiero generar un stream de Integer, lo puedo forzar con "boxed".
        Stream<Integer> flujoMuestras = generador.ints(muestras, 1, 7).boxed();

        // Organizar los datos en un mapa con entradas de tipo <Integer, Long>
        Map<Integer, Long> mapaFinal = flujoMuestras.collect(Collectors.
                groupingBy(Function.identity(),
                        Collectors.counting())
        );

        mapaFinal.forEach((valor, contador) -> {
            System.out.println(valor + " - " + contador + " - " + (contador*(1.0)/muestras));
        });
    }
}
