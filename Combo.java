public class Combo {
    //Atributos
    private String nombre;
    private double costoCombo;
    private String descripcion;
    //Constructor
    public Combo(String nombre, double costoCombo, String descripcion) {
        this.nombre = nombre;
        this.costoCombo = costoCombo;
        this.descripcion = descripcion;
    }
    //getters y setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getCostoCombo() {
        return costoCombo;
    }
    public void setCostoCombo(double costoCombo) {
        this.costoCombo = costoCombo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    // to string que permite mostrar los atributos del objeto combo
    public String toString() {
        return "Combo [nombre=" + nombre + ", costoCombo=" + costoCombo + ", descripcion=" + descripcion + "]";
    }
    
}
