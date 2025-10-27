import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deposito depositoA = new Deposito("A");
        Deposito depositoB = new Deposito("B");
        Deposito depositoC = new Deposito("C");

        System.out.println("Sistema de Inventario Multidepósito Iniciado");
        System.out.println("Ingrese el nombre del deposito:");
        String deposito = new Scanner(System.in).nextLine();
        switch (deposito) {
            case "A":
                int opcionA;
                do {
                    System.out.println("\nIngrese que acción desea realizar:");
                    System.out.println("1. Agregar productos");
                    System.out.println("2. Ver productos");
                    System.out.println("3. Retirar productos");
                    System.out.println("4. Ver Stock del depósito");
                    System.out.println("0. Salir al menú principal");
                    opcionA = scanner.nextInt();

                    switch (opcionA) {
                        case 1:
                            while (!depositoA.estaLleno()) {
                                scanner.nextLine(); // LIMPIA BUFFER

                                System.out.println("Ingrese el nombre del producto:");
                                String nombre = scanner.nextLine();

                                System.out.println("Ingrese la cantidad:");
                                int cantidad = scanner.nextInt();

                                System.out.println("Ingrese la fecha:");
                                String fecha = scanner.next();

                                System.out.println("Ingrese la fila (0-2):");
                                int fila = scanner.nextInt();

                                System.out.println("Ingrese la columna (0-2):");
                                int columna = scanner.nextInt();

                                System.out.println("Ingrese qué tipo de producto desea agregar:");
                                System.out.println("1. Nacional");
                                System.out.println("2. Importado");
                                String tipo = scanner.next();

                                switch (tipo) {
                                    case "1":
                                        ProductoNacional prodN = new ProductoNacional(nombre, cantidad, fecha, 0);
                                        depositoA.agregarProducto(fila, columna, prodN);
                                        break;
                                    case "2":
                                        ProductoImportado prodI = new ProductoImportado(nombre, cantidad, fecha, 0);
                                        depositoA.agregarProducto(fila, columna, prodI);
                                        break;
                                    default:
                                        System.out.println("Opción no válida");
                                        break;
                                }
                            }
                            System.out.println(">>> El depósito está lleno, regresando al menú...");
                            break;

                        case 2:
                            depositoA.mostrarDeposito();
                            break;

                        case 3:
                            break;

                        case 4:
                            depositoA.mostrarCantidadDeposito();
                            break;

                        case 0:
                            System.out.println("Regresando al menú principal...");
                            break;

                        default:
                            System.out.println("Opción no válida");
                            break;
                    }
                } while (opcionA != 0); // ← AQUI REGRESA AL MENU SIEMPRE
                break;

            case "B":

                break;
            case "C":

                break;
            default:
                System.out.println("El deposito no existe");
                break;
        }
    }
}
