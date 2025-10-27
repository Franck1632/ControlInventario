import java.time.LocalDate;

public class ProductoNacional extends ProductoBase {

    public ProductoNacional(String nombre, int cantidad, LocalDate fecha , double precio) {
        super(nombre, cantidad, fecha , precio);
    }
    
    @Override
    public String toString() {
        return "ProductoNacional{" +
                "nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", fecha='" + fecha + '\'' +
                ", precio=" + precio +
                '}';
    }
}
