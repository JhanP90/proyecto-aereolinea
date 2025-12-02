public class Avion {
    private String matricula;
    private String modelo;
    private String marca;
    private int capacidadMaxima;
    private int anoFabricacion;
    private String estado;

    public Avion(String matricula, String modelo, String marca,
                 int capacidadMaxima, int anoFabricacion) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.marca = marca;
        this.capacidadMaxima = capacidadMaxima;
        this.anoFabricacion = anoFabricacion;
        this.estado = "OPERATIVO";
    }

    public String getMatricula() { return matricula; }
    public String getModelo() { return modelo; }
    public String getMarca() { return marca; }
    public int getCapacidadMaxima() { return capacidadMaxima; }
    public int getAnoFabricacion() { return anoFabricacion; }
    public String getEstado() { return estado; }

    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return matricula + " | " + marca + " " + modelo + " | Cap: " + capacidadMaxima + " | " + estado;
    }
}
