import listado.Empleado;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import listado.Listado;
import listado.Division;
import listado.Departamento;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Clase contenedora de las pruebas para validar el trabajo realizado para la Práctica 1.
 *
 * @author Juan José Jiménez García
 */
public class ListadoTest {
    private static Listado listado;

    /**
     * Codigo a ejecutar antes de realizar las llamadas a los métodos
     * de la clase; incluso antes de la propia instanciación de la
     * clase. Por eso el método debe ser estático.
     */
    @BeforeClass
    public static void inicializacion() {
        System.out.println("Metodo de inicialización del conjunto de pruebas...");
        // Se genera el listado de empleados
        try {
            listado = new Listado("./data/datos.txt");
        } catch (IOException e) {
            System.out.println("Error en lectura de archivo de datos.");
        }
        ;

        // Una vez disponibles los empleados se leen las listas
        // de asignaciones de empleados a cada grupo de las diferentes
        // divisiones y departamentos considerados
        try {
            listado.cargarArchivoAsignacionDivision("./data/asignacionDIVNA.txt");
            listado.cargarArchivoAsignacionDivision("./data/asignacionDIVID.txt");
            listado.cargarArchivoAsignacionDivision("./data/asignacionDIVSW.txt");
            listado.cargarArchivoAsignacionDivision("./data/asignacionDIVHW.txt");
            listado.cargarArchivoAsignacionDivision("./data/asignacionDIVSER.txt");
            listado.cargarArchivoAsignacionDepartamento("./data/asignacionDEPNA.txt");
            listado.cargarArchivoAsignacionDepartamento("./data/asignacionDEPSB.txt");
            listado.cargarArchivoAsignacionDepartamento("./data/asignacionDEPSM.txt");
            listado.cargarArchivoAsignacionDepartamento("./data/asignacionDEPSA.txt");
        } catch (IOException e) {
            System.out.println("Error en lectura de archivos de asignación.");
        }
        System.out.println();
    }

    /**
     * Test para comprobar que se ha leido de forma correcta la
     * información de los empleados (al menos que el listado contiene
     * datos de 1000 empleados)
     *
     * @throws Exception
     */
    @Test
    public void testConstruccionListado() throws Exception {
        assert (listado.obtenerNumeroEmpleados() == 1000);
    }

    /**
     * Test del procedimiento de asignacion de divisiones procesando
     * los archivos de asignacion. Tambien implica la prueba de
     * busqueda de empleados sin departamento asignado en alguna división
     *
     * @throws Exception
     */
    @Test
    public void testCargarArchivosAsignacion() throws Exception {
        // Se obtienen los empleados no asignados a un departamento de cada División
        // y se comprueba su valor.
        assert (listado.buscarEmpleadosSinDepartamento(Division.DIVNA).size() == 49);
        assert (listado.buscarEmpleadosSinDepartamento(Division.DIVID).size() == 54);
        assert (listado.buscarEmpleadosSinDepartamento(Division.DIVSW).size() == 42);
        assert (listado.buscarEmpleadosSinDepartamento(Division.DIVHW).size() == 44);
        assert (listado.buscarEmpleadosSinDepartamento(Division.DIVSER).size() == 49);
    }

    /**
     * Prueba para el procedimiento de conteo de departamentos para cada una
     * de las divisiones
     */
    @Test
    public void testObtenerContadoresDepartamentos() {
        // Se obtienen los contadores para la división SER
        Map<Departamento, Long> contadores = listado.obtenerContadoresDepartamento(
                Division.DIVSER);
        contadores.keySet().stream().forEach(key -> System.out.println(
                key.toString() + " - " + contadores.get(key)));
        // Se comprueba que los valores son DEPNA = 49, DEPSB = 48, DEPSM = 53, DEPSA = 41
        Long contadoresReferencia[] = {49L, 48L, 53L, 41L};
        Long contadoresCalculados[] = new Long[4];
        assertArrayEquals(contadores.values().toArray(contadoresCalculados),
                contadoresReferencia);
    }

    /**
     * Prueba del procedimiento general de obtencion de contadores
     * para todas las divisiones y departamentos
     *
     * @throws Exception
     */
    @Test
    public void testObtenerContadoresDivisionDepartamento() throws Exception {
        // Se obtienen los contadores para todos las divisiones y sus departamentos
        Map<Division, Map<Departamento, Long>> contadores =
                listado.obtenerContadoresDivisionDepartamento();

        // Se comprueban los valores obtenenidos con los valores por referencia
        Long contadoresReferenciaNA[] = {49L, 53L, 53L, 58L};
        Long contadoresReferenciaID[] = {54L, 49L, 42L, 43L};
        Long contadoresReferenciaHW[] = {44L, 43L, 67L, 62L};
        Long contadoresReferenciaSW[] = {42L, 52L, 45L, 53L};
        Long contadoresReferenciaSER[] = {49L, 48L, 53L, 41L};

        // Se comprueban los resultado del metodo con los de referencia
        Long contadoresCalculados[] = new Long[4];
        assertArrayEquals(contadores.get(Division.DIVNA).values().
                toArray(contadoresCalculados), contadoresReferenciaNA);
        assertArrayEquals(contadores.get(Division.DIVID).values().
                toArray(contadoresCalculados), contadoresReferenciaID);
        assertArrayEquals(contadores.get(Division.DIVHW).values().
                toArray(contadoresCalculados), contadoresReferenciaHW);
        assertArrayEquals(contadores.get(Division.DIVSW).values().
                toArray(contadoresCalculados), contadoresReferenciaSW);
        assertArrayEquals(contadores.get(Division.DIVSER).values().
                toArray(contadoresCalculados), contadoresReferenciaSER);
    }

    /**
     * Test para comprobar la obtención de DNIs repetidos.
     * Se comprueba tanto el método booleano como el auxiliar que devuelve el Map.
     */
    @Test
    public void testComprobarDnisRepetidos() {
        // Obtenemos el booleano que nos indica si hay DNIs repetidos
        boolean hayDnisRepetidos = listado.hayDnisRepetidos();
        // Esperamos que NO haya DNIs repetidos
        assert(!hayDnisRepetidos);

        // Obtenemos el Map que nos da una lista de DNIs repetidos
        Map<String, List<Empleado>> mapDnisRepetidos = listado.obtenerDnisRepetidos();
        assertEquals(mapDnisRepetidos.size(), 0);
    }

    /**
     * Test para comprobar la obtención de correos repetidos.
     * Se comprueba tanto el método booleano como el auxiliar que devuelve el Map.
     */
    @Test
    public void testComprobarCorreosRepetidos() {
        // Obtenemos el booleano que nos indica si hay correos repetidos
        boolean hayCorreosrepetidos = listado.hayCorreosRepetidos();
        // Esperamos que SI haya correos repetidos
        assert(hayCorreosrepetidos);

        // Obtenemos el Map que nos da una lista de correos repetidos
        Map<String, List<Empleado>> mapCorreosRepetidos = listado.obtenerCorreosRepetidos();
        assertEquals(mapCorreosRepetidos.size(), 8);
    }

    /**
     * Test para comprobar el método buscarEmpleadosSinDivision
     */
    @Test
    public void testBuscarEmpleadosSinDivision() {
        List<Empleado> empleados = listado.buscarEmpleadosSinDivision();
        assertEquals(empleados.size(), 213);
    }

    /**
     * Test para comprobar el método buscarEmpleadosConDivisionSinDepartamento
     */
    @Test
    public void testBuscarEmpleadosConDivisionSinDepartamento() {
        List<Empleado> empleados = listado.buscarEmpleadosConDivisionSinDepartamento();
        assertEquals(empleados.size(), 189);
    }
}