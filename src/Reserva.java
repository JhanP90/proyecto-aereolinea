public class Reserva {
    private String id;
    private String idPasajero;
    private String idVuelo;
    private String estado;

    public Reserva(String id, String idPasajero, String idVuelo) {
        this.id = id;
        this.idPasajero = idPasajero;
        this.idVuelo = idVuelo;
        this.estado = "CONFIRMADA";
    }

    public String getId() { return id; }
    public String getIdPasajero() { return idPasajero; }
    public String getIdVuelo() { return idVuelo; }
    public String getEstado() { return estado; }

    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return id + " | Pasajero: " + idPasajero + " | Vuelo: " + idVuelo + " | " + estado;
    }
}
