import java.time.LocalDate;

public abstract class ProductoBase {
    protected String nombre;
    protected int cantidad;
    protected LocalDate fecha;
    protected double precio;



    public ProductoBase(String nombre, int cantidad, LocalDate fecha, double precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
