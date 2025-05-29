public class ServicioAdicional {
    //Atributos
    private String nombre;
    private double CostoServicio;
    private String descripcion;
    //constructor
    public ServicioAdicional(String nombre, double costoServicio, String descripcion) {
        this.nombre = nombre;
        CostoServicio = costoServicio;
        this.descripcion = descripcion;
    }
    //getters y setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getCostoServicio() {
        return CostoServicio;
    }
    public void setCostoServicio(double costoServicio) {
        CostoServicio = costoServicio;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    //to string para mostrar los atributos de un objeto ServicioAdicional
    public String toString() {
        return "ServicioAdicional [nombre=" + nombre + ", CostoServicio=" + CostoServicio + ", descripcion="
                + descripcion + "]";
    }
    
}
