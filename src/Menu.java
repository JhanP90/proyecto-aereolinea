import java.util.Scanner;

public class Menu {
    private GestionAerolinea gestion;
    private Scanner scanner;

    public Menu() {
        this.gestion = new GestionAerolinea();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        boolean ejecutando = true;
        System.out.println("====== SISTEMA DE AEROLINEA ======");
        
        while (ejecutando) {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Registrar pasajero");
            System.out.println("2. Registrar avion");
            System.out.println("3. Registrar vuelo");
            System.out.println("4. Hacer reserva");
            System.out.println("5. Listar pasajeros");
            System.out.println("6. Listar aviones");
            System.out.println("7. Listar vuelos");
            System.out.println("8. Listar reservas");
            System.out.println("9. Cancelar reserva");
            System.out.println("10. Salir");
            System.out.println("==========================");
            System.out.print("Opcion: ");
            
            try {
                int opcion = Integer.parseInt(scanner.nextLine());
                
                switch (opcion) {
                    case 1:
                        registrarPasajero();
                        break;
                    case 2:
                        registrarAvion();
                        break;
                    case 3:
                        registrarVuelo();
                        break;
                    case 4:
                        hacerReserva();
                        break;
                    case 5:
                        gestion.listarPasajeros();
                        break;
                    case 6:
                        gestion.listarAviones();
                        break;
                    case 7:
                        gestion.listarVuelos();
                        break;
                    case 8:
                        gestion.listarReservas();
                        break;
                    case 9:
                        cancelarReserva();
                        break;
                    case 10:
                        ejecutando = false;
                        System.out.println("Hasta luego!");
                        break;
                    default:
                        System.out.println("Opcion invalida");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: ingrese un numero");
            }
        }
    }

    private void registrarPasajero() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Cedula: ");
        String cedula = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Telefono: ");
        String telefono = scanner.nextLine();
        System.out.print("Nacionalidad: ");
        String nacionalidad = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = Integer.parseInt(scanner.nextLine());
        
        gestion.registrarPasajero(nombre, apellido, cedula, email, telefono, nacionalidad, edad);
    }

    private void registrarAvion() {
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Capacidad: ");
        int capacidad = Integer.parseInt(scanner.nextLine());
        System.out.print("Ano fabricacion: ");
        int ano = Integer.parseInt(scanner.nextLine());
        
        gestion.registrarAvion(modelo, marca, capacidad, ano);
    }

    private void registrarVuelo() {
        System.out.print("Origen: ");
        String origen = scanner.nextLine();
        System.out.print("Destino: ");
        String destino = scanner.nextLine();
        System.out.print("Fecha salida (ej: 2025-01-15 10:30): ");
        String fechaSalida = scanner.nextLine();
        System.out.print("Fecha llegada (ej: 2025-01-15 14:30): ");
        String fechaLlegada = scanner.nextLine();
        System.out.print("Capacidad: ");
        int capacidad = Integer.parseInt(scanner.nextLine());
        System.out.print("Precio pasaje: ");
        double precio = Double.parseDouble(scanner.nextLine());
        System.out.print("Matricula avion: ");
        String matricula = scanner.nextLine();
        
        gestion.registrarVuelo(origen, destino, fechaSalida, fechaLlegada, capacidad, precio, matricula);
    }

    private void hacerReserva() {
        System.out.print("ID pasajero: ");
        String idPasajero = scanner.nextLine();
        System.out.print("ID vuelo: ");
        String idVuelo = scanner.nextLine();
        
        gestion.hacerReserva(idPasajero, idVuelo);
    }

    private void cancelarReserva() {
        System.out.print("ID reserva a cancelar: ");
        String idReserva = scanner.nextLine();
        
        gestion.cancelarReserva(idReserva);
    }
}
