public class Deposito {

    private ProductoBase[][] productos;
    private String nombre;

    public Deposito(String nombre) {
        this.nombre = nombre;
    }

    public void crearDeposito(int filas, int columnas) {
        productos = new ProductoBase[filas][columnas];
    }

    public String mostrarDeposito() {
        StringBuilder deposito = new StringBuilder();
        for (int i = 0; i < productos.length; i++) {
            for (int j = 0; j < productos[i].length; j++) {
                if (productos[i][j] != null) {
                    deposito.append(productos[i][j].getNombre() + "[" + i + "]" + "[" + j + "]" + productos[i][j].getCantidad() + "\n");
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
        if (fila < 0 || fila >= productos.length || col < 0 || col >= productos[0].length) {
            System.out.println("Ubicación inexistente en el depósito " + nombre);
            return;
        }

        if (productos[fila][col] != null) {
            System.out.println("Ya existe un producto en esa ubicación.");
            return;
        }

        if (producto.getCantidad() < 0) {
            System.out.println("No se puede agregar una cantidad negativa.");
            return;
        }

        productos[fila][col] = producto;
        System.out.println("Producto agregado correctamente en el depósito " + nombre);
        System.out.println(producto.toString());
    }

    public boolean modificarCantidad(String nombre, int cantidad, int operacion) {
        ProductoBase aux = getProducto(nombre);
        if (aux == null) {
            System.out.println("Producto no existe");
            return false;
        }


        if (operacion == 1) {
            aux.setCantidad(aux.getCantidad() + cantidad);
            System.out.println("Nueva cantidad: " + aux.getCantidad() + "\n" + "Valor agragado:" + cantidad * aux.getPrecio() + "\n" + "Valor total del espacio: " + aux.getCantidad() * aux.getPrecio());

            return true;
        } else if (operacion == 0 && aux.getCantidad() >= cantidad) {
            aux.setCantidad(aux.getCantidad() - cantidad);
            System.out.println("Nueva cantidad: " + aux.getCantidad() + "\n" + "Valor reducido: " + cantidad * aux.getPrecio()+ "\n" + "Valor total del espacio: " + aux.getCantidad() * aux.getPrecio());
            return true;
        }else{
            System.out.println("El stock no alcanza, disponibles: " + aux.getCantidad());
        }
        return false;
    }

    public ProductoBase getProducto(String nombre) {
        for (int i = 0; i < productos.length; i++) {
            for (int j = 0; j < productos[i].length; j++) {
                if (productos[i][j].getNombre().equals(nombre)) {
                    return productos[i][j];

                }
            }
        }
        return null;

    }

    public void generarAlertas() {
        System.out.println("\n--- ALERTAS DEL DEPÓSITO " + nombre + " ---");
        for (int i = 0; i < productos.length; i++) {
            for (int j = 0; j < productos[0].length; j++) {
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
