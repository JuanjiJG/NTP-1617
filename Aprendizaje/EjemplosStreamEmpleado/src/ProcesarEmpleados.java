import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ProcesarEmpleados {

    // Se crea un array de empleados para trabajar con distintos ejemplos
    private Empleado[] empleados = {
            new Empleado("Juan", "Lopez", 5000, "IT"),
            new Empleado("Antonio", "Garcia", 7600, "IT"),
            new Empleado("Mateo", "Insausti", 3587.5, "Ventas"),
            new Empleado("Joaquín", "Fernandez", 4700.77, "Marketing"),
            new Empleado("Lucas", "Martinez", 6200, "IT"),
            new Empleado("Pedro", "Garcia", 3200, "Ventas"),
            new Empleado("Fernado", "Gonzalez", 4236.4, "Marketing")
    };

    // Se crea una lista para facilitar la creacion de flujos
    private List<Empleado> lista = Arrays.asList(empleados);

    public void listarEmpleados() {
        this.lista.stream().forEach(System.out::println);
    }

    public List<Empleado> filtrarCondicion() {
        Predicate<Empleado> condicion = empleado ->
                (empleado.obtenerSueldo() >= 4000 &&
                        empleado.obtenerSueldo() < 6000);

        return lista.stream().
                filter(condicion).
                collect(Collectors.toList());
    }

    public Empleado buscarPrimero() {
        Predicate<Empleado> condicion = empleado ->
                (empleado.obtenerSueldo() >= 4000 &&
                        empleado.obtenerSueldo() < 6000);

        // Procesamiento "lazy": terminará cuando encuentre el primero que cumpla la condición.
        // No hay necesidad de recorrer todos los elementos de la colección si ya has terminado.
        // Las operaciones intermedias no se ejecutan, solo cuando ponemos operaciones terminales.
        return lista.stream().filter(condicion).findFirst().get();
    }

    public List<Empleado> ordenarConCriterio() {
        // Tratar de forma abstracta un método de una clase
        Function<Empleado, String> obtenerNombre = Empleado::obtenerNombre;
        Function<Empleado, String> obtenerPrimerApellido = Empleado::obtenerPrimerApellido;

        Comparator<Empleado> empleadoComparator = Comparator.
                comparing(obtenerPrimerApellido).
                thenComparing(obtenerNombre);

        return lista.stream().sorted(empleadoComparator).collect(Collectors.toList());
    }

    public List<String> listarPrimerApellido() {
        return lista.stream().map(x -> x.obtenerPrimerApellido()).distinct().
                collect(Collectors.toList());
    }

    /**
     * Función para listar empleados por su departamento
     * Modo imperativo
     */
    public Map<String, List<Empleado>> listarPorDepartamentosImperativo() {
        // Puede ser HashMap o TreeMap
        // TreeMap mantiene el resultado ordenado
        // HashMap es más eficiente por usar una tabla hash
        Map<String, List<Empleado>> agrupamiento = new TreeMap<>();
        String departamento;
        List<Empleado> listaEmpleados;

        // Iteración sobre la lista de empleados
        for (int i = 0; i < lista.size(); i++) {
            // Obtener el departamento
            departamento = lista.get(i).obtenerDepartamento();

            // Comprobar si ya existe entrada en el diccionario
            // para ese departamento
            listaEmpleados = agrupamiento.get(departamento);

            // Si no existe la lista, crear una entrada para ese departamento
            if (listaEmpleados == null) {
                listaEmpleados = new LinkedList<>();
                agrupamiento.put(departamento, listaEmpleados);
            }

            // Agregar el empleado a la lista
            listaEmpleados.add(lista.get(i));
        }

        // Mostrar la colección generada
        Iterator<String> claves = agrupamiento.keySet().iterator();
        String clave;

        while (claves.hasNext()) {
            clave = claves.next();

            // Mostrar el nº de empleados
            System.out.println(clave + " : " + agrupamiento.get(clave).size());

            // Listar los empleados del departamento
            listaEmpleados = agrupamiento.get(clave);

            for (int i = 0; i < listaEmpleados.size(); i++) {
                System.out.println(listaEmpleados.get(i));
            }
        }

        return agrupamiento;
    }

    /**
     * Función para listar empleados por su departamento
     * Modo funcional
     */
    public Map<String, List<Empleado>> listarPorDepartamentosFuncional() {
        Map<String, List<Empleado>> agrupamiento = this.lista.stream().collect(Collectors.groupingBy(Empleado::obtenerDepartamento));

        // Mostra información por pantalla
        agrupamiento.forEach((departamento, empleados) -> {
            System.out.println(departamento);
            empleados.forEach(System.out::println);
        });

        return agrupamiento;
    }

    /**
     * Método para listar el nº de empleados por departamento
     */
    public Map<String, Long> contarPorDepartamentos() {
        TreeMap<String, Long> grupos = this.lista.stream().collect(
                Collectors.groupingBy(Empleado::obtenerDepartamento,
                        TreeMap::new,
                        Collectors.counting()
                )
        );

        return grupos;
    }

    /**
     * Sumar sueldos de todos los empleados
     */
    public double sumarSueldos() {
        return lista.stream().mapToDouble(Empleado::obtenerSueldo).sum();
    }

    /**
     * Método main para pruebas
     *
     * @param args
     */
    public static void main(String[] args) {
        ProcesarEmpleados objeto = new ProcesarEmpleados();

        System.out.println("----- Listar a todos los empleados -----");
        objeto.listarEmpleados();

        System.out.println("----- Listar a quienes tiene sueldo entre 4000 y 6000 -----");
        List<Empleado> listaFiltrada = objeto.filtrarCondicion();
        listaFiltrada.stream().forEach(System.out::println);

        System.out.println("----- Ordenar con criterio -----");
        List<Empleado> listaOrdenada = objeto.ordenarConCriterio();
        listaOrdenada.stream().forEach(System.out::println);

        System.out.println("----- Listar los primeros apellidos -----");
        List<String> listaApellidos = objeto.listarPrimerApellido();
        listaApellidos.stream().forEach(System.out::println);
    }
}
