import java.util.Scanner;

public class Run{
    public static void main(String[] args) {
        //Creacion del scanner que se usara para la entrada de datos del usuario
        Scanner input= new Scanner(System.in);
        // aqui se crea un objeto administrador ya que este es el que hace todas las funciones tanto del menu de cliente como el de administrador
        Administrador admin= new Administrador();
        System.out.println("Bienvenido al menu de Discovery eventos");
        // aqui se le pregunta al usuario si es cliente o admin esto para dirigirlo al menu correspondiente
        System.out.println("oprime (1) si quieres ir al menu de cliente y (2) si quieres ir al menu de administrador");
        byte AdminOusuario= input.nextByte();
        switch (AdminOusuario) {
            case 1:
                    //Se le piden todos los datos del usuario para crear un objeto cliente
                    System.out.println("Primero necesitamos saber tu datos");
                    input.nextLine();
                    System.out.println("A continuacion escriba su nombre");
                    String NombreCliente=input.nextLine();
                    System.out.println("Escribe su apellido");
                    String ApellidoCliente=input.nextLine();
                    System.out.println("Escribe su numero de telefono");
                    String TelefonoCliente=input.nextLine();
                    System.out.println("Escribe su numero de cedula");
                    String CedulaCliente=input.nextLine();
                    System.out.println("A continuacion escriba la direccion donde se realizara el servicio");
                    String direccion=input.nextLine();
                    // Atravez del metodo que creamos en administrador creamor un nuevo cliente con todos sus datos
                    System.out.println( admin.CrearCliente(NombreCliente,ApellidoCliente,TelefonoCliente,direccion,CedulaCliente));
                    //esta variable se encarga de que el usuario no compre mas de un combo
                    byte contadorcombos=0;
                    //esta variable se encarga de que la opcion que elija el usuario en la pregunta de "si quiere regresar al menu del cliente" exista para el do while
                    byte menuRegreso;
                    // el do permite al usuario regresar al menu de cliente en caso de que quiera hacer otra accion
                    do { 
                        //Se le indica al usuario las opciones que tiene en cuanto a servicios del menu de clientes
                        System.out.println("""
                                Bienvenido al menu de clientes
                                °Si quieres acceder al menu de combos presiona(1)
                                °Si quieres acceder al menu de servicios adicionales(2)
                                °si quieres acceder a el costo de su compra hasta el momento presione(3)
                                """);
                        byte menuCliente=input.nextByte();
                        switch (menuCliente) {
                            case 1: /* las siguientes dos variables estan por fuera ya que estas se necesitan que existan fuera del do while para que este pueda comparar si el usuario 
                                    volver al menu de combos.
                                    En cuanto a la variavle de menuCombos esta esta fuera del do while ya que es necesario para enviarle la eleccion del usuario de combo con el fin de que 
                                    seleccionar el combo a travez del metodo AdquirirCombo
                                    */
                                    byte ConfirmacionEleccion;
                                    byte menuCombos;
                                    if (contadorcombos==0) {
                                    //el do esta con el proposito de regresar al usuario en caso de duda en la eleccion del combo
                                        do{ 
                                            System.out.println("""
                                            Bienvenido al menu de combos aqui podra encontrar variedad de combos segun su necesidad
                                            (!Solo se puede seleccionar un combo por Cliente)
                                            Presione (1) Combo Bronce (30 a 60 personas): Descuento del 5% del total.
                                                        Incluye :Dos cabinas activas 15 pulgadas, 4 luces led, 2 luces roboticas, Tripodes para estructura de luces,
                                                        Estructura tipo Truss 2m, Switcheras o control DMX, Máquina de humo, Micrófono, Mixer o consola, Controlador DJ, PC Portátil

                                            Presione (2) Combo Plata (80 a 150 personas): Descuento del 10% del total, su precio es de $950.000. 
                                                        Dos cabinas activas 15 pulgadas, 2 Bajos Activos pulgadas,6 luces led,1 laser,2 cabezas robóticas,2 luces tipo spider robóticas,
                                                        Estructura tipo Truss 3m, Tripodes para estructura de luces,2 Switcheras o Interfaz DMX,Máquina de humo,Micrófono
                                                        Mixer o consola, Controlador DJ,PC Portátil.

                                            Presione (3) Combo Oro (150 a 200): Descuento del 15% del total, su precio es de $1.400.000'
                                                        Dos cabinas activas 15 pulgadas, 2 Bajos Activos 18, 6 luces led,1 laser,2 cabezas robóticas,2 luces tipo spider robóticas,
                                                        Estructura tipo Truss 3m,Tripodes para estructura de luces,2 Switcheras o Interfaz DMX,Máquina de humo,Micrófono,Mixer o consola
                                                        Controlador DJ, PC Portátil
                                            """);
                                            // este print muestra los precios atravez de un metodo que los regresa, este metodo fue creado con el fin de que en caso de que el administrador
                                            // cambie los precios estos se muestren actualizados en el menu
                                            System.out.println(admin.MostrarPrecios());
                                            menuCombos=input.nextByte();
                                            //Aqui le pregunta al usuario si esta seguro de la eleccion y en caso de que no este seguro con el Do while lo regresa al menu de combos
                                            System.out.println("Esta seguro de la eleccion de combo(1) o prefiere regresar al menu de combos(2)");
                                            ConfirmacionEleccion=input.nextByte();
                                        }while (ConfirmacionEleccion!=1); 
                                        System.out.println(admin.AdquirirCombo(menuCombos,CedulaCliente));
                                        contadorcombos++;
                                    } else{
                                        System.out.println("ya ha seleccionado un combo");
                                    }
                            break;
                        }
                        //pregunta que se hara al final de cada accion del menu de clientes para dejar a eleccion del usuario si quiere hacer otra accion y regresar al menu o finalizar la compra
                        System.out.println("Si quieres finalizar la compra presiona(1) si quieres regresar al menu de cliente presiona(2)");
                        menuRegreso=input.nextByte();
                        }while (menuRegreso!=1);
                break;
        }
    }
}