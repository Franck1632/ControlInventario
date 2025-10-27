import java.time.LocalDate;
import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Deposito depositoA = new Deposito("A");
        Deposito depositoB = new Deposito("B");
        Deposito depositoC = new Deposito("C");
        String deposito = "";
        do {
            System.out.println("Sistema de Inventario Multidepósito Iniciado");
            System.out.println("Ingrese el nombre del deposito (A,B,C), o X para salir:");
            deposito = new Scanner(System.in).nextLine();

            switch (deposito) {
                case "A":
                    menuOperaciones(depositoA);
                    break;

                case "B":
                    menuOperaciones(depositoB);
                    break;
                case "C":
                    menuOperaciones(depositoC);
                    break;
            }
        } while (!deposito.equalsIgnoreCase("x"));

    }

    public static boolean asignarTamañoDeposito(Deposito deposito) {
        System.out.println("Creando deposito: " + deposito.getNombre());
        System.out.println("Ingrese la cantidad de filas:");
        int filas = scanner.nextInt();
        System.out.println("Ingrese la cantidad de columnas:");
        int columnas = scanner.nextInt();
        deposito.crearDeposito(filas, columnas);
        return true;
    }

    public static void menuOperaciones(Deposito deposito) {
        if (deposito.getProductos() == null) {
            asignarTamañoDeposito(deposito);
        }
        int opcionA;
        do {
            System.out.println("\nIngrese que acción desea realizar:");
            System.out.println("1. Agregar productos");
            System.out.println("2. Ver productos");
            System.out.println("3. Alterar stock de productos");
            System.out.println("4. Ver Stock del depósito");
            System.out.println("0. Salir al menú principal\n");
            opcionA = scanner.nextInt();
            scanner.nextLine();

            switch (opcionA) {
                case 1:
                    scanner.nextLine(); // LIMPIA BUFFER

                    System.out.println("Ingrese el nombre del producto:");
                    String nombre = scanner.nextLine();

                    System.out.println("Ingrese la cantidad:");
                    int cantidad = scanner.nextInt();

                    System.out.println("Ingrese el precio:");
                    int precio = scanner.nextInt();

                    System.out.println("Ingrese la fila (0-" + (deposito.getProductos().length - 1) + "):");
                    int fila = scanner.nextInt();

                    System.out.println("Ingrese la columna (0-" + (deposito.getProductos()[0].length - 1) + "):");
                    int columna = scanner.nextInt();

                    System.out.println("Ingrese qué tipo de producto desea agregar:");
                    System.out.println("1. Nacional");
                    System.out.println("2. Importado");
                    String tipo = scanner.next();

                    switch (tipo) {
                        case "1":
                            ProductoNacional prodN = new ProductoNacional(nombre, cantidad, LocalDate.now(), precio);
                            deposito.agregarProducto(fila, columna, prodN);
                            break;
                        case "2":
                            ProductoImportado prodI = new ProductoImportado(nombre, cantidad, LocalDate.now(),
                                    precio);
                            deposito.agregarProducto(fila, columna, prodI);
                            break;
                        default:
                            System.out.println("Opción no válida");
                            break;

                    }
                    break;

                case 2:
                    System.out.println("========== DEPÓSITO " + deposito.getNombre() + " ==========");
                    System.out.println(deposito.mostrarDeposito());
                    deposito.generarAlertas();
                    break;

                case 3:
                    System.out.println("Ingrese el nombre del producto:");
                    String nombreAux = scanner.nextLine();
                    System.out.print("Para sumar cantidad ingrese 1, para restar cantidad ingrese 0: ");
                    int operacion = scanner.nextInt();
                    System.out.println("Ingrese la cantidad a sumar o restar:");
                    int cantidadAux = scanner.nextInt();
                    deposito.modificarCantidad(nombreAux, cantidadAux, operacion);
                    break;

                case 4:
                    deposito.mostrarCantidadDeposito();
                    break;
                case 0:
                    System.out.println("Regresando al menú principal...");
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcionA != 0);
    }

}
