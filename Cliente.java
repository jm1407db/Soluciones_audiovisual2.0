public class Cliente {
    //Atributos
    private String NombreCliente;
    private String ApellidoCliente;
    private String TelefonoCliente;
    private String DireccionCliente;
    private String cedulaCliente;
    private double Valortotalcliente;
    private Combo Combo;
    //Constructor

    public Cliente(String nombreCliente, String apellidoCliente, String telefonoCliente, String direccionCliente, String cedulaCliente) {
        NombreCliente = nombreCliente;
        ApellidoCliente = apellidoCliente;
        TelefonoCliente = telefonoCliente;
        DireccionCliente = direccionCliente;
        this.cedulaCliente= cedulaCliente;
        // el combo se inicializa en null ya que aun no sabemos si el usuario va a comprar un combo, al estar en null es como si estuviera vacio o no existiera
        Combo = null;
        Valortotalcliente= 0;
    }
    //getters y setters
    
    public String getCedulaCliente() {
        return cedulaCliente;
    }
    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }
    public String getNombreCliente() {
        return NombreCliente;
    }
    public void setNombreCliente(String nombreCliente) {
        NombreCliente = nombreCliente;
    }
    public String getApellidoCliente() {
        return ApellidoCliente;
    }
    public void setApellidoCliente(String apellidoCliente) {
        ApellidoCliente = apellidoCliente;
    }
    public String getTelefonoCliente() {
        return TelefonoCliente;
    }
    public void setTelefonoCliente(String telefonoCliente) {
        TelefonoCliente = telefonoCliente;
    }
    public String getDireccionCliente() {
        return DireccionCliente;
    }
    public void setDireccionCliente(String direccionCliente) {
        DireccionCliente = direccionCliente;
    }
    public Combo getCombo() {
        return Combo;
    }
    public void setCombo(Combo combo) {
        Combo = combo;
    }
    //To string que permite mostrar los atributos del objeto cliente
    public String toString() {
        if (this.Combo!=null) {
            return "Cliente [NombreCliente=" + NombreCliente + ", ApellidoCliente=" + ApellidoCliente + ", TelefonoCliente="
                + TelefonoCliente + ", DireccionCliente=" + DireccionCliente + ", \n Combo=" + Combo.toString() + "]";
        }
        return "Cliente [NombreCliente=" + NombreCliente + ", ApellidoCliente=" + ApellidoCliente + ", TelefonoCliente="
                + TelefonoCliente + ", DireccionCliente=" + DireccionCliente +  "]";
    }

    public double getValortotalcliente() {
        return Valortotalcliente;
    }

    public void setValortotalcliente(double valortotalcliente) {
        Valortotalcliente = valortotalcliente;
    }
    
}
