import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

/**
 * Clase para mostrar el uso de flujos con texto
 */
public class FlujoLineas {

    // Dato miembro para almacenar el nombre del archivo
    private String nombreArchivo;

    // Dato miembro para almacenar las lineas del archivo como
    // una lista y asi poder procesarlas posteriormente
    private List<String> lineas;

    /**
     * Constructor de la clase
     *
     * @param nombreArchivo
     */
    public FlujoLineas(String nombreArchivo) {
        // Asignamos el parámetro al dato miembro
        this.nombreArchivo = nombreArchivo;

        // Se procesa el contenido
        try {
            this.lineas = Files.lines(Paths.get(this.nombreArchivo), StandardCharsets.UTF_8).
                    map(linea -> linea.replaceAll("(?!')\\p{Punct}", "")).
                    collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("Error en la apertura de archivo");
            System.exit(-1);
        }
    }

    public Map<String, Long> obtenerContadoresPalabras() {
        // Definir patron para eliminar espacios en blanco
        Pattern patron = Pattern.compile("\\s+");

        // Procesamiento de las cadenas almacenadas en lineas
        // (cada cadena representa una linea completa)
        Stream<String> palabras = this.lineas.stream().
                flatMap(linea -> patron.splitAsStream(linea)).
                filter(palabra -> !palabra.isEmpty());

        // Ahora tenemos un flujo de cadenas
        // Queremos agruparlas de forma que todas las palabras
        // que sean iguales se agrupen y luego reducir el agrupamiento
        // al conteo de ocurrencias de la palabra
        TreeMap<String, Long> agrupamiento = palabras.collect(Collectors.
                groupingBy(String::toLowerCase,
                        TreeMap::new, Collectors.counting()));

        return agrupamiento;
    }

    /**
     * Metodo main para probar
     */
    public static void main(String[] args) throws IOException {
        // Se crea un objeto de la clase
        FlujoLineas objeto = new FlujoLineas("alicia.txt");

        // Se llama al método para creación del mapa
        Map<String, Long> mapa = objeto.obtenerContadoresPalabras();

        // Crear un flujo a partir de las entradas del mapa
        Stream<Entry<String, Long>> flujo = mapa.entrySet().stream();

        // Se crea un mapa, organizando por iniciales
        TreeMap<Character, List<Entry<String, Long>>> mapaFinal = flujo.collect(Collectors.
                groupingBy(entrada -> entrada.getKey().charAt(0),
                        TreeMap::new, Collectors.toList()));

        // Se muestra la info del mapa obtenido
        mapaFinal.forEach((letra, listaLetra) -> {
            System.out.println("\n" + letra + "----------");
            listaLetra.stream().forEach(entrada -> {
                System.out.println("\t" + entrada.getKey() + " " + entrada.getValue());
            });
        });
    }
}

