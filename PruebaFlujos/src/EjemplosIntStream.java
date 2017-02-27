import java.util.OptionalInt;
import java.util.Random;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

/**
 * Created by mgomez on 20/2/17.
 */
public class EjemplosIntStream {

    // Dato miembro para almacenar los valores
    private int valores[];

    // Constructor de la clase
    public EjemplosIntStream(int numeroValores) {
        // Se reserva espacio para el array
        valores = new int[numeroValores];

        // Se generan valores aleatorios entre 0 y 100
        // para rellenar el array
        Random generador = new Random();
        for (int i = 0; i < numeroValores; i++) {
            valores[i] = generador.nextInt(101);
        }
    }

    // Listado de valores funcional
    public void listadoValoresFuncional() {
        // Primer paso: crear flujo
        IntStream flujo = IntStream.of(this.valores);

        // Especificar la operación a realizar a cada elemento
        IntConsumer operacion = valor -> System.out.printf("%d ", valor);

        // Desencadeno la iteración sobre el flujo
        flujo.forEach(operacion);
        System.out.println();
    }

    // Ejemplo mejor encadenando funciones
    public void listadoValoresFuncional2() {
        IntStream.of(this.valores).forEach(valor -> System.out.printf("%d ", valor));
        System.out.println();
    }

    /**
     * Obtener la suma de todos los elementos con aproximación funcional
     *
     * @return La suma de todos los elementos de la colección "valores"
     */
    public long obtenerSumaFuncional() {
        // Generar flujo
        return IntStream.of(this.valores).sum();
    }

    public long obtenerSumaFuncionalReduce() {
        // Obtener flujo
        return IntStream.of(this.valores).reduce(0, (x, y) -> x + y);
    }

    public long obtenerSumaFuncionalCuadrados() {
        // Obtener flujo
        return IntStream.of(this.valores).reduce(0, (x, y) -> x + (y * y));
        // Otra forma
        // return IntStream.of(this.valores).map(x -> x*x).sum();
    }

    public int obtenerMinimoReduce() {
        // Obtener flujo
        return IntStream.of(this.valores).reduce(Integer.MAX_VALUE, (x, y) -> (x < y) ? x : y);
    }

    public int obtenerMinimo() {
        // Obtener flujo
        // Se usa OptionalInt para el caso de que la lista NO TENGA VALORES
        OptionalInt min = IntStream.of(this.valores).min();
        return min.orElse(-1);
    }

    /**
     * Método para obtener el máximo: si no hay valor se genera una excepción
     *
     * @return El valor máximo de la colección de valores
     */
    public int obtenerMaximo() {
        return IntStream.of(this.valores).max().getAsInt();
    }

    /**
     * Método para obtener la media: si no hay valor se genera una excepción
     *
     * @return El valor medio de la colección de valores
     */
    public double obtenerMedia() {
        return IntStream.of(this.valores).average().getAsDouble();
    }

    /**
     * Método para listar los valores pares de la colección
     */
    public void listarPares() {
        IntStream flujoPares = IntStream.of(this.valores).filter(x -> x % 2 == 0);

        // IntPredicate condicionPar = (x -> x % 2 == 0);
        // IntStream.of(this.valores).filter(condicionPar);

        // Si se llama una vez al flujo, se vacía y ya no sirve para más cosas.
        // Hay que volver a crearlo.
        // Estas dos operaciones siguientes no pueden hacerse seguidas por ese motivo.
        // flujoPares.forEach(x -> System.out.printf("%d ", x));
        flujoPares.forEach(System.out::println);
    }

    public int[] obtenerPares() {
        return IntStream.of(this.valores).filter(x -> x % 2 == 0).toArray();
    }

    /**
     * Método para obtener la lista de valores pares sin que haya repetidos
     *
     * @return Una colección ordenada de enteros pares, sin repeticiones
     */
    public int[] obtenerParesSinRepetidos() {
        // Para ganar eficiencia, hay que hacer primero las operaciones que eliminan elementos.
        return IntStream.of(this.valores).filter(x -> x % 2 == 0).distinct().sorted().toArray();
    }

    public int[] filtrarPredicados() {
        IntPredicate par = x -> x % 2 == 0;
        IntPredicate mayor5 = x -> x > 5;

        // Podemos componer un predicado con los hechos anterioremente
        IntPredicate total = par.and(mayor5);

        return IntStream.of(this.valores).filter(total).toArray();
    }

    public int[] filtradoGeneral(IntPredicate condicion) {
        return IntStream.of(this.valores).filter(condicion).toArray();
    }

    public void ordenarParesMultiplicados(double factor) {
        IntStream flujo1 = IntStream.of(this.valores).filter(x -> x % 2 == 0);
        DoubleStream flujo2 = flujo1.mapToDouble(x -> x * factor);
        flujo2.sorted().forEach(System.out::println);
    }

    // Main para prueba
    public static void main(String args[]) {
        // Se crea objeto de la clase
        EjemplosIntStream objeto = new EjemplosIntStream(10);
        objeto.listadoValoresFuncional();
        objeto.listadoValoresFuncional2();
        System.out.println(objeto.obtenerSumaFuncionalCuadrados());
        System.out.println(objeto.obtenerMinimoReduce());
        System.out.println(objeto.obtenerMinimo());
        System.out.println(objeto.obtenerMaximo());
        System.out.println(objeto.obtenerMedia());
        System.out.println();
        objeto.listarPares();
        System.out.println();
        objeto.ordenarParesMultiplicados(2);
    }
}
