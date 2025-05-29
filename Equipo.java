public class Equipo {
    //Atributos
    private String nombreEquipo;
    private Double costoEquipo;
    private int cantidadDeEquipos;
    //Constructor
    public Equipo(String nombreEquipo, Double costoEquipo, int cantidadDeEquipos) {
        this.nombreEquipo = nombreEquipo;
        this.costoEquipo = costoEquipo;
        this.cantidadDeEquipos = cantidadDeEquipos;
    }
    //Getters y setters
    public String getNombreEquipo() {
        return nombreEquipo;
    }
    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }
    public Double getCostoEquipo() {
        return costoEquipo;
    }
    public void setCostoEquipo(Double costoEquipo) {
        this.costoEquipo = costoEquipo;
    }
    public int getCantidadDeEquipos() {
        return cantidadDeEquipos;
    }
    public void setCantidadDeEquipos(int cantidadDeEquipos) {
        this.cantidadDeEquipos = cantidadDeEquipos;
    }
    // to string que permite ver los atributos de un objeto de clase Equipo
    public String toString() {
        return "Equipo [nombreEquipo=" + nombreEquipo + ", costoEquipo=" + costoEquipo + ", cantidadDeEquipos="
                + cantidadDeEquipos + "]";
    }
    
    
}
