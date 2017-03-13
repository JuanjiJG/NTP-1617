package listado;

/**
 * Clase para el tipo de dato Empleado
 *
 * @author Juan José Jiménez García
 */
public class Empleado {
    private String dni;
    private String nombre;
    private String apellidos;
    private String email;
    private Division division;
    private Departamento departamento;

    /**
     * Constructor de la clase Empleado
     * Crea un objeto de tipo Empleado con sus datos básicos.
     * Asigna la división y departamento NA al empleado.
     *
     * @param dni
     * @param nombre
     * @param apellidos
     * @param email
     * @author Juan José Jiménez García
     */
    public Empleado(String dni, String nombre, String apellidos, String email) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.division = Division.DIVNA;
        this.departamento = Departamento.DEPNA;
    }

    /**
     * Método para obtener el DNI del empleado
     *
     * @return El DNI del empleado
     * @author Juan José Jiménez García
     */
    public String getDni() {
        return this.dni;
    }

    /**
     * Método para
     * @param dni
     * @author Juan José Jiménez García
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     *
     * @return
     * @author Juan José Jiménez García
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     *
     * @param nombre
     * @author Juan José Jiménez García
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     * @author Juan José Jiménez García
     */
    public String getApellidos() {
        return this.apellidos;
    }

    /**
     *
     * @param apellidos
     * @author Juan José Jiménez García
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     *
     * @return
     * @author Juan José Jiménez García
     */
    public String getEmail() {
        return this.email;
    }

    /**
     *
     * @param email
     * @author Juan José Jiménez García
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     * @author Juan José Jiménez García
     */
    public Division getDivision() {
        return this.division;
    }

    /**
     *
     * @param division
     * @author Juan José Jiménez García
     */
    public void setDivision(Division division) {
        this.division = division;
    }

    /**
     *
     * @return
     * @author Juan José Jiménez García
     */
    public Departamento getDepartamento() {
        return this.departamento;
    }

    /**
     *
     * @param departamento
     * @author Juan José Jiménez García
     */
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
