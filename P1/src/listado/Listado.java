package listado;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Clase contenedora de los métodos de procesamiento de
 * los archivos y funcionalidad principal de la práctica
 *
 * @author Juan José Jiménez García
 */
public class Listado {
    /**
     * Dato miembro para almacenar a los empleados como diccionario
     * con pares tipo (clave - valor) con el siguiente contenido:
     * <dni - Empleado>
     */
    private Map<String, Empleado> lista;

    /**
     * Constructor de la clase Listado
     *
     * @param nombreArchivo Ruta del fichero de empleados que se quiere procesar
     * @throws IOException
     * @author Juan José Jiménez García
     */
    public Listado(String nombreArchivo) throws IOException {
        this.lista = new HashMap<String, Empleado>();
        Stream<String> lineas = Files.lines(Paths.get(nombreArchivo));
        lineas.map(linea -> {
            // Me produce un flujo de objetos de la clase Empleado.
            // Delego en el método crearEmpleado la creación de los empleados.
            return crearEmpleado(linea);
        }).collect(Collectors.toMap(empleado -> empleado.getDni(), Function.identity()));
    }

    public Empleado crearEmpleado(String linea) {
        Pattern patron = Pattern.compile(",");
        List<String> infos = patron.splitAsStream(linea).collect(Collectors.toList());

        return new Empleado(infos.get(0), infos.get(1), infos.get(2), infos.get(3));
    }
}
