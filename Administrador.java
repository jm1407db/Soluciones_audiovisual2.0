import java.util.ArrayList;
public class Administrador {
    //Atributo de contraseña para el ingreso al menu de administrador
    private String contraseña;
    //Atributo para mostrar la sumatoria de las ventas del dia
    private double gananciasdia;
    // se crea un atributo que es un array donde se van a guardar los combos
    Combo[]combos;
    // se crear un atributo que es un array donde se van a guarda los servicios adicionales
    ServicioAdicional[]servicios;
    //se crea un atributo como array dinamico para guardar los clientes
    ArrayList<Cliente>ListadeClientes;
    //constructor que se inicia apenas se crea un objeto tipo administrador
    public Administrador(){
        //se le asigna un array al atributo que creamos de lista de clientes y lo inicializamos 
        this.ListadeClientes= new ArrayList<Cliente>();
        this.contraseña="12345";
        this. gananciasdia=0;
        //se le asigna un array al atributo de combos y se iniciliza el array con un tamaño de 3
        this.combos= new Combo[3];
        this.servicios= new ServicioAdicional[9];
        //se crean tres objetos de tipo combo y se guardan en el array combos
        this.combos[0]= new Combo("Bronce", 700000,"Incluye :Dos cabinas activas 15 pulgadas, 4 luces led, 2 luces roboticas, Tripodes para estructura de luces,\n" + //
                        "                                             Estructura tipo Truss 2m, Switcheras o control DMX, Máquina de humo, Micrófono, Mixer o consola, Controlador DJ, PC Portátil");
        this.combos[1]= new Combo("Plata", 950000, "Incluye Dos cabinas activas 15 pulgadas, 2 Bajos Activos pulgadas,6 luces led,1 laser,2 cabezas robóticas,2 luces tipo spider robóticas,\n" + //
                        "                                             Estructura tipo Truss 3m, Tripodes para estructura de luces,2 Switcheras o Interfaz DMX,Máquina de humo,Micrófono\n" + //
                        "                                             Mixer o consola, Controlador DJ,PC Portátil.");
        this.combos[2]= new Combo("Oro", 1400000, "Dos cabinas activas 15 pulgadas, 2 Bajos Activos 18, 6 luces led,1 laser,2 cabezas robóticas,2 luces tipo spider robóticas,\n" + //
                        "                                            Estructura tipo Truss 3m,Tripodes para estructura de luces,2 Switcheras o Interfaz DMX,Máquina de humo,Micrófono,Mixer o consola\n" + //
                        "                                            Controlador DJ, PC Portátil");   
        // se crean los servicios predeterminados
        this.servicios[0]= new ServicioAdicional("sonido para conferencias", 200000, "servicio de sonido para conferencias");
        this.servicios[1]= new ServicioAdicional("servicio de luces", 300000, "servicio de luces");
        this.servicios[2]= new ServicioAdicional("servicio de microfono", 100000, "servicio de microfono");
        this.servicios[3]= new ServicioAdicional("servicio de consola", 120000, "servicio de consola");
        this.servicios[4]= new ServicioAdicional("servicio de video beam", 150000, "servicio de video beam 5000 lumens + telon");
        this.servicios[5]= new ServicioAdicional("servicio de bola de espejos", 100000, "servicio de bola de espejos");
        this.servicios[6]= new ServicioAdicional("servicio de Ventury de papel+cañon Co2", 120000, "servicio de Ventury de papel+cañon Co2 (tres disparos)");
        this.servicios[7]= new ServicioAdicional("servicio de lanzallamas", 60000, "servicio de lanzallamas");
        this.servicios[8]= new ServicioAdicional("servicio de DJ", 200000, "el servicio de DJ (el valor corresponde a una hora de servicio)");
    }
    //metodo para verificar la contraseña de un administrador
    public boolean VerificarAdmin(String contraseña){
        if (contraseña.equalsIgnoreCase(this.contraseña)) {
            return true;
        }
        return false;
    }
    //metodo que muestra todos los datos de los clientes
    public String MostrarDatosClientes(){
        String DatosClientes="";
        if(ListadeClientes.size()>0){
            for (int i = 0; i < ListadeClientes.size(); i++) {
                DatosClientes+="Cliente N"+(i+1)+" ="+ListadeClientes.get(i).toString()+"\n";
            }
        return DatosClientes;
        }
        return"No hay ningun cliente";
    }
    //metodo para cambiar el precio de un combo
    public String CambiarPrecioCombo(byte MenuCambiarPreciosCombos,double NuevoPrecioCombo){
        switch (MenuCambiarPreciosCombos) {
            case 1:
                combos[0].setCostoCombo(NuevoPrecioCombo);
                break;
            case 2:
                combos[1].setCostoCombo(NuevoPrecioCombo);
                break;
            case 3:
                combos[2].setCostoCombo(NuevoPrecioCombo);
                break;
        }
        return "Precio del combo cambiado";
    }
    //metodo para cambiar el precio de un servicio
    public String CambiarPrecioServicio(byte MenuCambiarPreciosServicios,double NuevoPrecioServicio){
        switch (MenuCambiarPreciosServicios) {
            case 1:
                servicios[0].setCostoServicio(NuevoPrecioServicio);
                break;
             case 2:
                servicios[1].setCostoServicio(NuevoPrecioServicio);
                break;
             case 3:
                servicios[2].setCostoServicio(NuevoPrecioServicio);
                break;
             case 4:
                servicios[3].setCostoServicio(NuevoPrecioServicio);
                break;
             case 5:
                servicios[4].setCostoServicio(NuevoPrecioServicio);
                break;
             case 6:
                servicios[5].setCostoServicio(NuevoPrecioServicio);
                break;
             case 7:
                servicios[6].setCostoServicio(NuevoPrecioServicio);
                break;
             case 8:
                servicios[7].setCostoServicio(NuevoPrecioServicio);
                break;
             case 9:
                servicios[8].setCostoServicio(NuevoPrecioServicio);
                break;
        }
        return "Precio del servicio cambiado";
    }
    //metodo que muestra la cuenta total hasta el momento
    public String MostrarTotalCliente(String CedulaCliente){
        for (int i = 0; i < ListadeClientes.size(); i++) {
                    if (this.ListadeClientes.get(i).getCedulaCliente().equals(CedulaCliente)) {
                        return"La cuenta hasta total hasta el momento del cliente (!Sin descuentos aplicados!) es de: $"+ListadeClientes.get(i).getValortotalcliente();
                    }
        }
        return "";
    }
    //metodo para mostrar los precios en el menu de combos y actualizarlo en caso de cambio por parte del admin
    public String MostrarPreciosCombos(){
        return"El valor del combo bronce es de $"+combos[0].getCostoCombo()+"\n"+"\n"+"El valor del combo plata es de $"+combos[1].getCostoCombo()+"\n"+"\n"+"El valor del combo oro es de $"+combos[2].getCostoCombo();
    }
    public String MostrarPreciosServicios(){
        String Mostrarservicios="";
        for (int i = 0; i < servicios.length; i++) {
            Mostrarservicios+="el costo del servicio "+(i+1)+" es $"+servicios[i].getCostoServicio()+"\n";
        }
        return Mostrarservicios;
    }
    //metodo para crear un nuevo cliente y enviarle un mensaje de cliente creado
    public String CrearCliente(String nombreCliente, String ApellidoCliente,String TelefonoCliente,String DireccionCliente, String cedulaCliente){
        ListadeClientes.add(new Cliente(nombreCliente, ApellidoCliente, TelefonoCliente, DireccionCliente,cedulaCliente));
        return"Miembro creado";
    }
    //metodo que hace el proceso de descuento y muestra el costo total
    public String Mostrarfactura(String CedulaCliente, byte contadorcombos){
        for (int i = 0; i < ListadeClientes.size(); i++) {
                    if (this.ListadeClientes.get(i).getCedulaCliente().equals(CedulaCliente)) {
                        if (contadorcombos>0) {
                            if (ListadeClientes.get(i).getCombo()==combos[0]) {
                                ListadeClientes.get(i).setValortotalcliente(ListadeClientes.get(i).getValortotalcliente()-(ListadeClientes.get(i).getValortotalcliente()*0.05));
                                this.gananciasdia+=ListadeClientes.get(i).getValortotalcliente();
                                return"Accedio al combo bronce se le aplico un 5% \n" + "El costo total de su compra es de $"+ListadeClientes.get(i).getValortotalcliente()+"\n"+
                                "El combo "+ListadeClientes.get(i).getCombo().getDescripcion()+"\n" +
                                "La compra quedo a nombre de "+ListadeClientes.get(i).getNombreCliente()+" "+ListadeClientes.get(i).getApellidoCliente()+"\n"+
                                "En la direccion: "+ListadeClientes.get(i).getDireccionCliente()+"\n Gracias por su compra, vuelva pronto";
                            }else if (ListadeClientes.get(i).getCombo()==combos[1]) {
                                ListadeClientes.get(i).setValortotalcliente(ListadeClientes.get(i).getValortotalcliente()-(ListadeClientes.get(i).getValortotalcliente()*0.10));
                                this.gananciasdia+=ListadeClientes.get(i).getValortotalcliente();
                                return"Accedio al combo plata se le aplico un 10% de descuento al total \n" + "El costo total de su compra es de $"+ListadeClientes.get(i).getValortotalcliente()+"\n"+
                                "El combo "+ListadeClientes.get(i).getCombo().getDescripcion()+"\n" +
                                "La compra quedo a nombre de "+ListadeClientes.get(i).getNombreCliente()+" "+ListadeClientes.get(i).getApellidoCliente()+"\n"+
                                "En la direccion: "+ListadeClientes.get(i).getDireccionCliente()+"\n Gracias por su compra, vuelva pronto";
                            }else if (ListadeClientes.get(i).getCombo()==combos[2]) {
                                ListadeClientes.get(i).setValortotalcliente(ListadeClientes.get(i).getValortotalcliente()-(ListadeClientes.get(i).getValortotalcliente()*0.15));
                                this.gananciasdia+=ListadeClientes.get(i).getValortotalcliente();
                                return"Accedio al combo oro se le aplico un 15% de descuento al total \n" + "El costo total de su compra es de $"+ListadeClientes.get(i).getValortotalcliente()+"\n"+
                                "El combo "+ListadeClientes.get(i).getCombo().getDescripcion()+"\n" +
                                "La compra quedo a nombre de "+ListadeClientes.get(i).getNombreCliente()+" "+ListadeClientes.get(i).getApellidoCliente()+"\n"+
                                "En la direccion: "+ListadeClientes.get(i).getDireccionCliente()+"\n Gracias por su compra, vuelva pronto";
                            }
                       }else{
                            this.gananciasdia+=ListadeClientes.get(i).getValortotalcliente();
                            return"No ha accedido a ningun combo, no se aplicaran descuentos \n" + "El costo total de su compra es de $"+ListadeClientes.get(i).getValortotalcliente()+"\n"+
                                "La compra quedo a nombre de "+ListadeClientes.get(i).getNombreCliente()+" "+ListadeClientes.get(i).getApellidoCliente()+"\n"+
                                "En la direccion: "+ListadeClientes.get(i).getDireccionCliente()+"\n Gracias por su compra vuelva pronto";
                       }
                    }
        }
        return "";
    }
    //Metodo para adquirir servicio
    public String AdquirirServicio(byte menuServicios, String CedulaCliente){
        switch (menuServicios) {
            case 1:
                for (int i = 0; i < ListadeClientes.size(); i++) {
                    if (this.ListadeClientes.get(i).getCedulaCliente().equals(CedulaCliente)) {
                        this.ListadeClientes.get(i).setValortotalcliente(ListadeClientes.get(i).getValortotalcliente()+servicios[0].getCostoServicio());
                        return"servicio de sonido para conferencias adquirido";
                    }
                }
                break;
            case 2:
                for (int i = 0; i < ListadeClientes.size(); i++) {
                    if (this.ListadeClientes.get(i).getCedulaCliente().equals(CedulaCliente)) {
                        this.ListadeClientes.get(i).setValortotalcliente(ListadeClientes.get(i).getValortotalcliente()+servicios[1].getCostoServicio());
                        return"servicio de luces adquirido";
                    }
                }
                break;
            case 3:
                for (int i = 0; i < ListadeClientes.size(); i++) {
                    if (this.ListadeClientes.get(i).getCedulaCliente().equals(CedulaCliente)) {
                        this.ListadeClientes.get(i).setValortotalcliente(ListadeClientes.get(i).getValortotalcliente()+servicios[2].getCostoServicio());
                        return"servicio de microfono adquirido";
                    }
                }
                break;
            case 4:
                for (int i = 0; i < ListadeClientes.size(); i++) {
                    if (this.ListadeClientes.get(i).getCedulaCliente().equals(CedulaCliente)) {
                        this.ListadeClientes.get(i).setValortotalcliente(ListadeClientes.get(i).getValortotalcliente()+servicios[3].getCostoServicio());
                        return"servicio de consola de audio adquirido";
                    }
                }
                break;
            case 5:
                for (int i = 0; i < ListadeClientes.size(); i++) {
                    if (this.ListadeClientes.get(i).getCedulaCliente().equals(CedulaCliente)) {
                        this.ListadeClientes.get(i).setValortotalcliente(ListadeClientes.get(i).getValortotalcliente()+servicios[4].getCostoServicio());
                        return"servicio de video beam 5000 lumens + telon adquirido";
                    }
                }
                break;
            case 6:
                for (int i = 0; i < ListadeClientes.size(); i++) {
                    if (this.ListadeClientes.get(i).getCedulaCliente().equals(CedulaCliente)) {
                        this.ListadeClientes.get(i).setValortotalcliente(ListadeClientes.get(i).getValortotalcliente()+servicios[5].getCostoServicio());
                        return"servicio de bola de espejos adquirido";
                    }
                }
                break;
            case 7:
                for (int i = 0; i < ListadeClientes.size(); i++) {
                    if (this.ListadeClientes.get(i).getCedulaCliente().equals(CedulaCliente)) {
                        this.ListadeClientes.get(i).setValortotalcliente(ListadeClientes.get(i).getValortotalcliente()+servicios[6].getCostoServicio());
                        return"servicio de Ventury de papel+cañon Co2 (tres disparos) adquirido";
                    }
                }
                break;
            case 8:
                for (int i = 0; i < ListadeClientes.size(); i++) {
                    if (this.ListadeClientes.get(i).getCedulaCliente().equals(CedulaCliente)) {
                        this.ListadeClientes.get(i).setValortotalcliente(ListadeClientes.get(i).getValortotalcliente()+servicios[7].getCostoServicio());
                        return"servicio de Lanzallamas adquirido";
                    }
                }
                break;
            case 9:
                for (int i = 0; i < ListadeClientes.size(); i++) {
                    if (this.ListadeClientes.get(i).getCedulaCliente().equals(CedulaCliente)) {
                        this.ListadeClientes.get(i).setValortotalcliente(ListadeClientes.get(i).getValortotalcliente()+servicios[8].getCostoServicio());
                        return"servicio de Ventury de Dj adquirido";
                    }
                }
                break;
        }
        return"";
    }
    // metodo que permite al usuario adquirir combos y agregar ese combo al atributo del cliente correspondiente 
    public String AdquirirCombo(Byte Menucombos,String CedulaCliente){
        switch (Menucombos) {
            case 1:
                //el for recorre el array ListadeCliente y busca el usuario que concuerde con la cedula 
                // y al encontrar el usuario con el for le asigna el combo que eligio
                for (int i = 0; i < ListadeClientes.size(); i++) {
                    if (this.ListadeClientes.get(i).getCedulaCliente().equals(CedulaCliente)) {
                        this.ListadeClientes.get(i).setCombo(combos[0]);
                        this.ListadeClientes.get(i).setValortotalcliente(ListadeClientes.get(i).getValortotalcliente()+combos[0].getCostoCombo());
                        return"Combo de bronce seleccionado";
                    }
                }
                break;
            case 2:
                for (int i = 0; i < ListadeClientes.size(); i++) {
                    if (this.ListadeClientes.get(i).getCedulaCliente().equals(CedulaCliente)) {
                        this.ListadeClientes.get(i).setCombo(combos[1]);
                        this.ListadeClientes.get(i).setValortotalcliente(ListadeClientes.get(i).getValortotalcliente()+combos[1].getCostoCombo());
                        return"Combo de plata seleccionado";
                    }
                }
                break;
            case 3:
                for (int i = 0; i < ListadeClientes.size(); i++) {
                    if (this.ListadeClientes.get(i).getCedulaCliente().equals(CedulaCliente)) {
                        this.ListadeClientes.get(i).setCombo(combos[2]);
                        this.ListadeClientes.get(i).setValortotalcliente(ListadeClientes.get(i).getValortotalcliente()+combos[2].getCostoCombo());
                        return"Combo de oro seleccionado";
                    }
                }
                break;
            
        }
        return"";
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public String getcontraseña() {
        return contraseña;
    }
    public void setgananciasdia(double gananciasdia) {
        this.gananciasdia = gananciasdia;
    }
    public double getgananciasdia() {
        return gananciasdia;
    }
}