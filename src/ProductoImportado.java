import java.time.LocalDate;

public class ProductoImportado extends ProductoBase {

    public ProductoImportado(String nombre, int cantidad, LocalDate fecha, double precio) {
        super(nombre, cantidad, fecha, ((0.05 * precio) + precio));
    }   

    

    @Override
    public String toString() {
        return "ProductoImportado{" +
                "nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", fecha='" + fecha + '\'' +
                ", precio=" + precio +
                '}';
    }
}