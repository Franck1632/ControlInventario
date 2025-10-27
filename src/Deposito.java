public class Deposito {

    private ProductoBase[][] productos = new ProductoBase[3][3];
    private String nombre;

    public Deposito(String nombre) {
        this.nombre = nombre;
    }

    public String mostrarDeposito() {
        StringBuilder deposito = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (productos[i][j] != null) {
                    deposito.append(productos[i][j].getNombre() + "\n");
                }
            }
        }
        return deposito.toString();
    }

    public void mostrarCantidadDeposito() {
        int total = 0;
        for (int i = 0; i < productos.length; i++) {
            for (int j = 0; j < productos[i].length; j++) {
                if (productos[i][j] != null) {
                    total += productos[i][j].getCantidad();
                }
            }
        }
        System.out.println("Cantidad total en el depósito: " + total);
    }

    public void agregarProducto(int fila, int col, ProductoBase producto) {
        if (fila < 0 || fila >= 3 || col < 0 || col >= 3) {
            System.out.println("Ubicación inexistente en el depósito " + nombre);
            return;
        }

        if (productos[fila][col] != null) {
            System.out.println("Ya existe un producto en esa ubicación. Retíralo primero.");
            return;
        }

        if (producto.getCantidad() < 0) {
            System.out.println("No se puede agregar una cantidad negativa.");
            return;
        }

        productos[fila][col] = producto;
        System.out.println("Producto agregado correctamente en el depósito " + nombre);
    }

    public boolean estaLleno() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (productos[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public void generarAlertas() {
        System.out.println("\n--- ALERTAS DEL DEPÓSITO " + nombre + " ---");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (productos[i][j] == null) {
                    System.out.println("Ubicación vacía en fila " + i + ", columna " + j);
                }
            }
        }
    }

    public ProductoBase[][] getProductos() {
        return productos;
    }

    public void setProductos(ProductoBase[][] productos) {
        this.productos = productos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
