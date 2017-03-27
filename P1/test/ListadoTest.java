import listado.Departamento;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import listado.Listado;
import listado.Division;

import java.io.IOException;
import java.util.Map;

/**
 * Práctica 1 NTP
 */
public class ListadoTest {
    private static Listado listado;

    /**
     * Codigo a ejecutar antes de realizar las llamadas a los métodos
     * de la clase; incluso antes de la propia instanciación de la
     * clase. Por eso el método debe ser estatico
     */
    @BeforeClass
    public static void inicializacion() {
        System.out.println("Metodo inicializacion conjunto pruebas");
        // Se genera el listado de empleados
        try {
            listado = new Listado("./data/datos.txt");
        }catch(IOException e){
            System.out.println("Error en lectura de archivo de datos");
        };

        // Una vez disponibles los empleados se leen las listas
        // de asignaciones de empleados a cada grupo de las diferentes
        // asignaturas consideradas
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
            System.out.println("Error en lectura de archivos de asignacion");
        }
        System.out.println();
    }

    /**
     * Test para comprobar que se ha leido de forma correcta la
     * informacion de los empleados (al menos que el listado contiene
     * datos de 100 empleados)
     * @throws Exception
     */
    @Test
    public void testConstruccionListado() throws Exception{
        assert(listado.obtenerNumeroEmpleados() == 1000);
        System.out.println(listado.toString());
    }

    /**
     * Test del procedimiento de asignacion de grupos procesando
     * los archivos de asignacion. Tambien implica la prueba de
     * busqueda de empleados sin grupo asignado en alguna asignatura
     * @throws Exception
     */
    @Test
    public void testCargarArchivosAsignacion() throws Exception {
        // Se obtienen los empleados no asignados a cada asignatura
        // y se comprueba su valor
        assert(listado.buscarEmpleadosSinDepartamento(Division.DIVNA).size() == 49);
        assert(listado.buscarEmpleadosSinDepartamento(Division.DIVID).size() == 54);
        assert(listado.buscarEmpleadosSinDepartamento(Division.DIVSW).size() == 42);
        assert(listado.buscarEmpleadosSinDepartamento(Division.DIVHW).size() == 44);
        assert(listado.buscarEmpleadosSinDepartamento(Division.DIVSER).size() == 49);
    }

    /**
     * Prueba para el procedimiento de conteo de grupos para cada una
     * de las asignaturas
     */
    @Test
    public void testObtenerContadoresDepartamentos(){
        // Se obtienen los contadores para la asignatura ES
        Map<Departamento, Long> contadores = listado.obtenerContadoresDepartamento(
                Division.DIVNA);
        contadores.keySet().stream().forEach(key -> System.out.println(
                key.toString() + " - " + contadores.get(key)));
        // Se comprueba que los valores son DEPNA = 49, DEPSB = 48, DEPSM = 53, DEPSA = 41
        Long contadoresReferencia[]={48L,49L,41L,53L};
        Long contadoresCalculados[]=new Long[4];
        assertArrayEquals(contadores.values().toArray(contadoresCalculados),
                          contadoresReferencia);
    }

    /**
     * Prueba del procedimiento general de obtencion de contadores
     * para todas las asignaturas
     * @throws Exception
     */
    @Test
    public void testObtenerContadoresDivisionDepartamento() throws Exception {
        // Se obtienen los contadores para todos los grupos
        Map<Division, Map<Departamento, Long>> contadores =
                listado.obtenerContadoresDivisionDepartamento();

        // Se comprueban los valores obtenenidos con los valores por referencia
        Long contadoresReferenciaNA[]={58L,49L,53L,53L};
        Long contadoresReferenciaID[]={43L,54L,49L,42L};
        Long contadoresReferenciaHW[]={62L,44L,43L,67L};
        Long contadoresReferenciaSW[]={53L,42L,52L,45L};
        Long contadoresReferenciaSER[]={41L,49L,48L,53L};

        // Se comprueban los resultado del metodo con los de referencia
        Long contadoresCalculados[]=new Long[4];
        System.out.println(contadores.toString());
        assertArrayEquals(contadores.get(Division.DIVNA).values().
                toArray(contadoresCalculados),contadoresReferenciaNA);
        assertArrayEquals(contadores.get(Division.DIVID).values().
                toArray(contadoresCalculados),contadoresReferenciaID);
        assertArrayEquals(contadores.get(Division.DIVHW).values().
                toArray(contadoresCalculados),contadoresReferenciaHW);
        assertArrayEquals(contadores.get(Division.DIVSW).values().
                toArray(contadoresCalculados),contadoresReferenciaSW);
        assertArrayEquals(contadores.get(Division.DIVSER).values().
                toArray(contadoresCalculados),contadoresReferenciaSER);
    }

    // Aqui habria que completar los casos de prueba para el resto de
    // metodos a ofrecer por la clase Listado
}