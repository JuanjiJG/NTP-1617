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
    private String correo;
    private Division division;
    private Departamento departamento;

    /**
     * Constructor de la clase Empleado.
     * Inicializa por defecto la división y departamento del empleado a NA.
     *
     * @param dni
     * @param nombre
     * @param apellidos
     * @param correo
     */
    public Empleado(String dni, String nombre, String apellidos, String correo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.division = Division.DIVNA;
        this.departamento = Departamento.DEPNA;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", correo='" + correo + '\'' +
                ", division=" + division +
                ", departamento=" + departamento +
                "}\n";
    }
}
