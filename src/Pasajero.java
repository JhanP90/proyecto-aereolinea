public class Pasajero {
    private String id;
    private String nombre;
    private String apellido;
    private String cedula;
    private String email;
    private String telefono;
    private String nacionalidad;
    private int edad;

    public Pasajero(String id, String nombre, String apellido, String cedula,
                    String email, String telefono, String nacionalidad, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.email = email;
        this.telefono = telefono;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getCedula() { return cedula; }
    public String getEmail() { return email; }
    public String getTelefono() { return telefono; }
    public String getNacionalidad() { return nacionalidad; }
    public int getEdad() { return edad; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public void setEmail(String email) { this.email = email; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    @Override
    public String toString() {
        return id + " | " + nombre + " " + apellido + " | " + cedula;
    }
}
