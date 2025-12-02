import java.util.Random;

public class GestionAerolinea {
    private ListaEnlazada<Pasajero> pasajeros;      // Estructura: Lista Enlazada
    private ListaEnlazada<Vuelo> vuelos;            // Estructura: Lista Enlazada
    private ListaEnlazada<Avion> aviones;           // Estructura: Lista Enlazada
    private Cola<Reserva> reservasEnEspera;         // Estructura: Cola (para espera)
    private ListaEnlazada<Reserva> reservasConfirmadas; // Estructura: Lista Enlazada
    private Pila<String> historialOperaciones;      // Estructura: Pila (para auditoría)
    private Random random;

    public GestionAerolinea() {
        this.pasajeros = new ListaEnlazada<>();
        this.vuelos = new ListaEnlazada<>();
        this.aviones = new ListaEnlazada<>();
        this.reservasEnEspera = new Cola<>();
        this.reservasConfirmadas = new ListaEnlazada<>();
        this.historialOperaciones = new Pila<>();
        this.random = new Random();
    }

    private String generarId(String prefijo) {
        return prefijo + (100000 + random.nextInt(900000));
    }

    // PASAJEROS
    public boolean registrarPasajero(String nombre, String apellido, String cedula,
                                     String email, String telefono, String nacionalidad, int edad) {
        String idPasajero = generarId("PAX");
        Pasajero nuevoPasajero = new Pasajero(idPasajero, nombre, apellido, cedula,
                email, telefono, nacionalidad, edad);
        pasajeros.agregar(nuevoPasajero);
        String operacion = "REGISTRAR PASAJERO: " + idPasajero;
        historialOperaciones.apilar(operacion);
        System.out.println("OK - Pasajero registrado. ID: " + idPasajero);
        return true;
    }

    public Pasajero obtenerPasajero(String idPasajero) {
        for (int i = 0; i < pasajeros.getTamaño(); i++) {
            Pasajero p = pasajeros.obtener(i);
            if (p.getId().equals(idPasajero)) {
                return p;
            }
        }
        return null;
    }

    public void listarPasajeros() {
        if (pasajeros.estaVacio()) {
            System.out.println("No hay pasajeros registrados");
            return;
        }
        System.out.println("\n===== LISTA DE PASAJEROS =====");
        for (int i = 0; i < pasajeros.getTamaño(); i++) {
            Pasajero p = pasajeros.obtener(i);
            System.out.println((i + 1) + ". " + p.getNombre() + " " + p.getApellido() +
                    " | ID: " + p.getId() + " | Cedula: " + p.getCedula());
        }
    }

    // AVIONES
    public boolean registrarAvion(String modelo, String marca, int capacidadMaxima, int anoFabricacion) {
        String matricula = generarId("MAT").substring(0, 8);
        Avion nuevoAvion = new Avion(matricula, modelo, marca, capacidadMaxima, anoFabricacion);
        aviones.agregar(nuevoAvion);
        String operacion = "REGISTRAR AVION: " + matricula;
        historialOperaciones.apilar(operacion);
        System.out.println("OK - Avion registrado. Matricula: " + matricula);
        return true;
    }

    public Avion obtenerAvion(String matricula) {
        for (int i = 0; i < aviones.getTamaño(); i++) {
            Avion a = aviones.obtener(i);
            if (a.getMatricula().equals(matricula)) {
                return a;
            }
        }
        return null;
    }

    public void listarAviones() {
        if (aviones.estaVacio()) {
            System.out.println("No hay aviones registrados");
            return;
        }
        System.out.println("\n===== LISTA DE AVIONES =====");
        for (int i = 0; i < aviones.getTamaño(); i++) {
            Avion a = aviones.obtener(i);
            System.out.println((i + 1) + ". " + a.getMarca() + " " + a.getModelo() +
                    " | Matricula: " + a.getMatricula() + " | Capacidad: " + a.getCapacidadMaxima() +
                    " | Estado: " + a.getEstado());
        }
    }

    // VUELOS
    public boolean registrarVuelo(String origen, String destino, String fechaSalida,
                                  String fechaLlegada, int capacidad, double precioPasaje,
                                  String matriculaAvion) {
        Avion avion = obtenerAvion(matriculaAvion);
        if (avion == null) {
            System.out.println("Error - Avion no encontrado");
            return false;
        }

        String idVuelo = generarId("VUE");
        Vuelo nuevoVuelo = new Vuelo(idVuelo, origen, destino, fechaSalida,
                fechaLlegada, capacidad, precioPasaje, matriculaAvion);
        vuelos.agregar(nuevoVuelo);
        String operacion = "REGISTRAR VUELO: " + idVuelo;
        historialOperaciones.apilar(operacion);
        System.out.println("OK - Vuelo registrado. ID: " + idVuelo);
        return true;
    }

    public Vuelo obtenerVuelo(String idVuelo) {
        for (int i = 0; i < vuelos.getTamaño(); i++) {
            Vuelo v = vuelos.obtener(i);
            if (v.getId().equals(idVuelo)) {
                return v;
            }
        }
        return null;
    }

    public void listarVuelos() {
        if (vuelos.estaVacio()) {
            System.out.println("No hay vuelos registrados");
            return;
        }
        System.out.println("\n===== LISTA DE VUELOS =====");
        for (int i = 0; i < vuelos.getTamaño(); i++) {
            Vuelo v = vuelos.obtener(i);
            System.out.println((i + 1) + ". " + v.getOrigen() + " -> " + v.getDestino() +
                    " | ID: " + v.getId() + " | Salida: " + v.getFechaSalida() +
                    " | Asientos: " + v.getCapacidad());
        }
    }

    // RESERVAS
    public boolean hacerReserva(String idPasajero, String idVuelo) {
        Pasajero pasajero = obtenerPasajero(idPasajero);
        Vuelo vuelo = obtenerVuelo(idVuelo);

        if (pasajero == null || vuelo == null) {
            System.out.println("Error - Pasajero o vuelo no encontrado");
            return false;
        }

        if (vuelo.getCapacidad() <= 0) {
            System.out.println("Error - No hay asientos disponibles");
            return false;
        }

        String idReserva = generarId("RES");
        Reserva nuevaReserva = new Reserva(idReserva, idPasajero, idVuelo);
        reservasConfirmadas.agregar(nuevaReserva);
        vuelo.setCapacidad(vuelo.getCapacidad() - 1);
        String operacion = "HACER RESERVA: " + idReserva;
        historialOperaciones.apilar(operacion);
        System.out.println("OK - Reserva confirmada. ID: " + idReserva);
        return true;
    }

    public void listarReservas() {
        if (reservasConfirmadas.estaVacio()) {
            System.out.println("No hay reservas registradas");
            return;
        }
        System.out.println("\n===== LISTA DE RESERVAS =====");
        for (int i = 0; i < reservasConfirmadas.getTamaño(); i++) {
            Reserva r = reservasConfirmadas.obtener(i);
            System.out.println((i + 1) + ". ID: " + r.getId() + " | Pasajero: " + r.getIdPasajero() +
                    " | Vuelo: " + r.getIdVuelo() + " | Estado: " + r.getEstado());
        }
    }

    public void cancelarReserva(String idReserva) {
        for (int i = 0; i < reservasConfirmadas.getTamaño(); i++) {
            Reserva r = reservasConfirmadas.obtener(i);
            if (r.getId().equals(idReserva)) {
                Vuelo vuelo = obtenerVuelo(r.getIdVuelo());
                if (vuelo != null) {
                    vuelo.setCapacidad(vuelo.getCapacidad() + 1);
                }
                r.setEstado("CANCELADA");
                String operacion = "CANCELAR RESERVA: " + idReserva;
                historialOperaciones.apilar(operacion);
                System.out.println("OK - Reserva cancelada");
                return;
            }
        }
        System.out.println("Error - Reserva no encontrada");
    }
}
