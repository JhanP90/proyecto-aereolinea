import java.util.ArrayList;
import java.util.List;

public class Vuelo {
    private String id;
    private String origen;
    private String destino;
    private String fechaSalida;
    private String fechaLlegada;
    private int capacidad;
    private double precioPasaje;
    private String matriculaAvion;
    private String estado;
    private List<String> pasajeros;

    public Vuelo(String id, String origen, String destino, String fechaSalida,
                 String fechaLlegada, int capacidad, double precioPasaje, String matriculaAvion) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.capacidad = capacidad;
        this.precioPasaje = precioPasaje;
        this.matriculaAvion = matriculaAvion;
        this.estado = "PROGRAMADO";
        this.pasajeros = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getOrigen() { return origen; }
    public String getDestino() { return destino; }
    public String getFechaSalida() { return fechaSalida; }
    public String getFechaLlegada() { return fechaLlegada; }
    public int getCapacidad() { return capacidad; }
    public double getPrecioPasaje() { return precioPasaje; }
    public String getMatriculaAvion() { return matriculaAvion; }
    public String getEstado() { return estado; }
    public List<String> getPasajeros() { return pasajeros; }

    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }
    public void setEstado(String estado) { this.estado = estado; }
    public void setPrecioPasaje(double precioPasaje) { this.precioPasaje = precioPasaje; }

    @Override
    public String toString() {
        return id + " | " + origen + "->" + destino + " | " + fechaSalida + " | Asientos: " + capacidad;
    }
}
