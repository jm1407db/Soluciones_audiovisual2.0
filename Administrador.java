import java.util.ArrayList;

public class Administrador {
    // se crea un atributo que es un array donde se van a guardar los combos
    Combo[]combos;
    //se crea un atributo como array dinamico para guardar los clientes
    ArrayList<Cliente>ListadeClientes;
    //constructor que se inicia apenas se crea un objeto tipo administrador
    public Administrador(){
        //se le asigna un array al atributo que creamos de lista de clientes y lo inicializamos 
        this.ListadeClientes= new ArrayList<Cliente>();
        //se le asigna un array al atributo de combos y se iniciliza el array con un tamaño de 3
        this.combos= new Combo[3];
        //se crean tres objetos de tipo combo y se guardan en el array combos
        this.combos[0]= new Combo("Bronce", 700000,"Incluye :Dos cabinas activas 15 pulgadas, 4 luces led, 2 luces roboticas, Tripodes para estructura de luces,\n" + //
                        "                                             Estructura tipo Truss 2m, Switcheras o control DMX, Máquina de humo, Micrófono, Mixer o consola, Controlador DJ, PC Portátil");
        this.combos[1]= new Combo("Plata", 950000, "Incluye Dos cabinas activas 15 pulgadas, 2 Bajos Activos pulgadas,6 luces led,1 laser,2 cabezas robóticas,2 luces tipo spider robóticas,\n" + //
                        "                                             Estructura tipo Truss 3m, Tripodes para estructura de luces,2 Switcheras o Interfaz DMX,Máquina de humo,Micrófono\n" + //
                        "                                             Mixer o consola, Controlador DJ,PC Portátil.");
        this.combos[2]= new Combo("Oro", 1400000, "Dos cabinas activas 15 pulgadas, 2 Bajos Activos 18, 6 luces led,1 laser,2 cabezas robóticas,2 luces tipo spider robóticas,\n" + //
                        "                                            Estructura tipo Truss 3m,Tripodes para estructura de luces,2 Switcheras o Interfaz DMX,Máquina de humo,Micrófono,Mixer o consola\n" + //
                        "                                            Controlador DJ, PC Portátil");   
    }
    //metodo para mostrar los precios en el menu de combos y actualizarlo en caso de cambio por parte del admin
    public String MostrarPrecios(){
        return"El valor del combo bronce es de $"+combos[0].getCostoCombo()+"\n"+"\n"+"El valor del combo plata es de $"+combos[1].getCostoCombo()+"\n"+"\n"+"El valor del combo oro es de $"+combos[2].getCostoCombo();
    }
    //metodo para crear un nuevo cliente y enviarle un mensaje de cliente creado
    public String CrearCliente(String nombreCliente, String ApellidoCliente,String TelefonoCliente,String DireccionCliente, String cedulaCliente){
        ListadeClientes.add(new Cliente(nombreCliente, ApellidoCliente, TelefonoCliente, DireccionCliente,cedulaCliente));
        return"Miembro creado";
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
}
