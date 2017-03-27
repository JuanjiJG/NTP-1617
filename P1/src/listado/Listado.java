package listado;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Clase Listado con toda la funcionalidad requerida para la
 * realización de la Práctica 1.
 *
 * @author Juan José Jiménez García
 */
public class Listado {
    /*
    Dato miembro para almacenar a los empleados como diccionario
    con pares tipo (clave - valor) con el siguiente contenido:
    <DNI - Empleado>
     */
    private Map<String, Empleado> lista;

    public Listado(String nombreArchivo) throws IOException {
        // Obtener todas las lineas a procesar del fichero de datos
        Stream<String> lineas = Files.lines(Paths.get(nombreArchivo));

        this.lista = new TreeMap<String, Empleado>();
        this.lista = lineas.map(linea -> {
            /*
            Me produce un flujo de objetos de la clase Empleado.
            Delego en el método crearEmpleado la creación de los empleados.
            */
            return crearEmpleado(linea);
        }).collect(Collectors.toMap(empleado -> empleado.getDni(), Function.identity()));
    }

    /**
     * Método para crear un objeto de la clase Empleado.
     *
     * @param lineaEmpleado un String con información del empleado, que será procesada
     * @return una instancia de la clase Empleado con la información dada como argumento
     */
    public Empleado crearEmpleado(String lineaEmpleado) {
        /*
        Para procesar la linea, empleamos la clase Pattern indicando el separador (,).
        En una lista se almacena cada dato procesado y luego los usamos para construir
        un objeto de tipo Empleado.
         */
        Pattern patron = Pattern.compile(",  ");
        List<String> infoEmpleado = patron.splitAsStream(lineaEmpleado).collect(Collectors.toList());

        return new Empleado(infoEmpleado.get(0), infoEmpleado.get(1), infoEmpleado.get(2), infoEmpleado.get(3));
    }

    /**
     * Método para cargar un fichero de datos de asignación de divisiones y asignarlo a los empleados.
     * Lee el fichero, identifica la división y asigna la misma a los empleados que indique.
     *
     * @param nombreArchivo la ruta del fichero de datos a procesar
     * @throws IOException
     */
    public void cargarArchivoAsignacionDivision(String nombreArchivo) throws IOException {
        /*
        Primero debemos saber qué división estamos procesando.
        De esta manera haremos correctamente la asignación de los empleados.
         */
        Stream<String> lineas = Files.lines(Paths.get(nombreArchivo));
        String division = lineas.findFirst().get();

        /*
        Ahora procedemos a realizar las asignaciones de división.
        Asociamos la división a cada empleado cuyo DNI coincida con lo encontrado en la lista.
         */
        Files.lines(Paths.get(nombreArchivo)).skip(2).forEach(linea -> this.lista.get(linea).setDivision(Division.valueOf(division)));
    }

    /**
     * Método para cargar un fichero de datos de asignación de departamentos y asignarlo a los empleados.
     * Lee el fichero, identifica el departamento y asigna el mismo a los empleados que indique.
     *
     * @param nombreArchivo la ruta del fichero de datos a procesar
     * @throws IOException
     */
    public void cargarArchivoAsignacionDepartamento(String nombreArchivo) throws IOException {
        /*
        Primero debemos saber qué departamento estamos procesando.
        De esta manera haremos correctamente la asignación de los empleados.
         */
        Stream<String> lineas = Files.lines(Paths.get(nombreArchivo));
        String departamento = lineas.findFirst().get();

        /*
        Ahora procedemos a realizar las asignaciones de departamento.
        Asociamos el departamento a cada empleado cuyo DNI coincida con lo encontrado en la lista.
         */
        Files.lines(Paths.get(nombreArchivo)).skip(2).forEach(linea -> this.lista.get(linea).setDepartamento(Departamento.valueOf(departamento)));
    }

    /**
     * Método para obtener el nº de empleados que contiene la colección.
     *
     * @return un valor numérico que indica el total de empleados que hay en la colección
     */
    public long obtenerNumeroEmpleados() {
        // Crear un flujo a partir de las entradas de la colección y contarlas
        return this.lista.entrySet().stream().count();
    }

    /**
     * Método para componer una cadena de caracteres con la información de los empleados.
     *
     * @return un String que contiene la información de todos los empleados de la colección
     */
    public String toString() {
        return this.lista.values().toString();
    }

    /**
     * Método para obtener el nº de empleados de cada departamento en cada una de las divisiones.
     *
     * @return un Map de tipo <Division, Map<Departamento, Long>> que indica el nº de empleados por Departamento en cada Division
     */
    public Map<Division, Map<Departamento, Long>> obtenerContadoresDivisionDepartamento() {
        // Creo el HashMap que voy a devolver
        Map<Division, Map<Departamento, Long>> agrupamiento = new TreeMap<>();

        // Creo un flujo con los distintos valores de Division y les asocio su contador de departamento
        Stream.of(Division.values()).
                forEach(division -> agrupamiento.put(division, obtenerContadoresDepartamento(division)));

        return agrupamiento;
    }

    /**
     * Método para obtener el nº de empleados de cada departamento en una división
     *
     * @param division la división para la que contar los empleados de cada departamento
     * @return un Map de tipo <Departamento, Long> que indica el departamento y su nº de empleados
     */
    public Map<Departamento, Long> obtenerContadoresDepartamento(Division division) {
        // Obtengo un flujo de empleados de una división
        Stream<Map.Entry<String, Empleado>> empleadosDivision = this.lista.entrySet().stream().filter(
                entrada -> entrada.getValue().getDivision() == division);

        // Creo un Map de empleados agrupándolos por departamento
        TreeMap<Departamento, Long> contadoresDepartamento = empleadosDivision.collect(
                Collectors.groupingBy(
                        entradaEmpleado -> entradaEmpleado.getValue().getDepartamento(),
                        TreeMap::new,
                        Collectors.counting()));

        return contadoresDepartamento;
    }

    /**
     * Metodo para buscar los empleados sin division asignada: es decir,
     * en el dato miembro division tendran el valor DIVNA
     */
    public List<Empleado> buscarEmpleadosSinDivision() {
        Predicate<Empleado> condicion = empleado -> (
                empleado.getDivision() == Division.DIVNA);

        return lista.values().stream().filter(condicion).collect(Collectors.toList());
    }

    /**
     * Metodo para buscar empleados con division asignada (no es DIVNA)
     * pero sin departamento: el valor del dato miembro departamento es
     * DEPNA
     */
    public List<Empleado> buscarEmpleadosConDivisionSinDepartamento() {
        Predicate<Empleado> condicion = empleado -> (
                empleado.getDivision() != Division.DIVNA &&
                empleado.getDepartamento() == Departamento.DEPNA);

        return lista.values().stream().filter(condicion).collect(Collectors.toList());
    }

    /**
     * Metodo para buscar todos los empleados no asignados a departamento
     * que pertenezcan a una determinada division
     *
     * @param divisionObjetivo division de interes
     * @return una lista de empleados sin departamento asignado
     */
    public List<Empleado> buscarEmpleadosSinDepartamento(Division divisionObjetivo) {
        Predicate<Empleado> condicion = empleado -> (
                empleado.getDivision() != divisionObjetivo &&
                        empleado.getDepartamento() == Departamento.DEPNA);

        return lista.values().stream().filter(condicion).collect(Collectors.toList());
    }

    /**
     * Metodo para determinar si hay dnis repetidos
     *
     * @return
     */
    public boolean hayDnisRepetidos() {
        return false;
    }

    /**
     * Método para obtener una lista de DNIs repetidos, junto con la
     * lista de trabajadores asociados a cada DNI repetido (en caso de
     * haberlos)
     */
    public Map<String, List<Empleado>> obtenerDnisRepetidos() {
        return null;
    }

    /**
     * Metodo para determinar si hay correos repetidos
     */
    public boolean hayCorreosRepetidos() {
        return false;
    }

    /**
     * Metodo para obtener una lista de correos repetidos, junto con la
     * lista de trabajadores asociados a cada correo repetido (en caso de
     * haberlos)
     */
    public Map<String, List<Empleado>> obtenerCorreosRepetidos() {
        return null;
    }

    // TODO - Hacer un método que indique si un empleado tiene tiene asignada división (y departamento)

    // TODO - Opcional - Hacer que los que no tienen asignado nada se asignen en los departamentos intentando lograr un equilibrio
}