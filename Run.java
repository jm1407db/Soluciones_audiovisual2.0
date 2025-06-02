import javax.swing.JOptionPane;
public class Run{
    public static void main(String[] args) {
        // aqui se crea un objeto administrador ya que este es el que hace todas las funciones tanto del menu de cliente como el de administrador
        Administrador admin= new Administrador();
        JOptionPane.showMessageDialog(null,"Bienvenido al menu de Discovery eventos");
        byte AdminOusuario=0;
        boolean verificacion1=false;
        int ConfirmacionMenuinicio=0;
        // aqui se le pregunta al usuario si es cliente o admin esto para dirigirlo al menu correspondiente
        //este do es el principal por que es el que regresa al usuario al menu incial
        do{ 
            //este do regresa al usuario e caso de que no introduzca una opcion valida
            do{ 
                // el try verifica que el usuario no instroduzca datos que no concuerden con el tipo de variable en donde se guarda
                try {
                    AdminOusuario=Byte.parseByte(JOptionPane.showInputDialog("oprime (1) si quieres ir al menu de cliente y (2) si quieres ir al menu de administrador"));
                    if (AdminOusuario==1 || AdminOusuario==2) {
                        verificacion1=true;
                    }else{
                        JOptionPane.showMessageDialog(null, "Escribe un numero que este entre las opciones correctas");
                    }
                }catch (Exception e) {
                    JOptionPane.showMessageDialog( null, "Dato erroneo, Por favor ingresar un dato valido");
                }
            }while(!verificacion1);
            //switch para mover al usuario entre menus de admin y usuario
            switch (AdminOusuario) {
                case 1:
                        String NombreCliente="";
                        String ApellidoCliente="";
                        String TelefonoCliente="";
                        String CedulaCliente="";
                        String direccion="";
                        Boolean verificacion2=false;
                        //do para regresar al usuario en caso de que los datos que ingrese no esten entre las opciones o no haya nada 
                        do{ 
                            try {
                                //Se le piden todos los datos del usuario para crear un objeto cliente
                                NombreCliente =JOptionPane.showInputDialog("Primero necesitamos saber tu datos \n A continuacion escriba su nombre:");
                                ApellidoCliente=JOptionPane.showInputDialog("Escribe su apellido");
                                TelefonoCliente=JOptionPane.showInputDialog("Escribe su numero de telefono"); 
                                CedulaCliente=JOptionPane.showInputDialog("Escribe su numero de cedula");
                                direccion=JOptionPane.showInputDialog("A continuacion escriba la direccion donde se realizara el servicio");
                                if (NombreCliente==null|| NombreCliente.isEmpty()
                                ||ApellidoCliente==null||ApellidoCliente.isEmpty()
                                ||TelefonoCliente==null||TelefonoCliente.isEmpty()
                                ||CedulaCliente==null|| CedulaCliente.isEmpty()) {
                                    JOptionPane.showMessageDialog(null, "Por favor no dejar ningun dato en blanco ");
                                }else{
                                    verificacion2=true;
                                }
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog( null, "Datos erroneos, por favor ingresar datos validos");
                            }
                        }while (!verificacion2);
                        // Atravez del metodo que creamos en administrador creamor un nuevo cliente con todos sus datos
                        JOptionPane.showMessageDialog(null,( admin.CrearCliente(NombreCliente,ApellidoCliente,TelefonoCliente,direccion,CedulaCliente)));
                        //esta variable se encarga de que el usuario no compre mas de un combo
                        byte contadorcombos=0;
                        //esta variable se encarga de que la opcion que elija el usuario en la pregunta de "si quiere regresar al menu del cliente" exista para el do while
                        int menuRegreso;
                        // el do permite al usuario regresar al menu de cliente en caso de que quiera hacer otra accion
                        do {
                            boolean verificacion3=false;
                            byte menuCliente=0;
                            //Se le indica al usuario las opciones que tiene en cuanto a servicios del menu de clientes
                            do{ 
                                try {           
                                    menuCliente=Byte.parseByte(JOptionPane.showInputDialog(null,"""
                                        Bienvenido al menu de clientes
                                        °Si quieres acceder al menu de combos presiona(1)
                                        °Si quieres acceder al menu de servicios adicionales(2)
                                        °si quieres acceder a el costo de su compra hasta el momento presione(3)
                                        °si quieres finalizar compra  presione(4)
                                        """));
                                        if (menuCliente!=1 && menuCliente!=2 && menuCliente!=3 && menuCliente!=4) {
                                            JOptionPane.showMessageDialog(null, "Por favor ingrese un numero entre las opciones");
                                        }else{
                                            verificacion3=true;
                                        }
                                } catch (Exception e) {
                                        JOptionPane.showMessageDialog(null, "Dato erroneo, Ingrese un dato valido");
                                }
                            }while(!verificacion3);
                            switch (menuCliente) {
                                case 1:
                                    /* las siguientes dos variables estan por fuera ya que estas se necesitan que existan fuera del do while para que este pueda comparar si el usuario 
                                    volver al menu de combos.
                                    En cuanto a la variavle de menuCombos esta esta fuera del do while ya que es necesario para enviarle la eleccion del usuario de combo con el fin de que 
                                    seleccionar el combo a travez del metodo AdquirirCombo
                                    */
                                    boolean verificacion4=false;
                                    int ConfirmacionEleccion;
                                    byte menuCombos=0;
                                    if (contadorcombos==0) {
                                    //el do esta con el proposito de regresar al usuario en caso de duda en la eleccion del combo
                                        do{ 
                                            do{ 
                                                try {
                                                    menuCombos=Byte.parseByte(JOptionPane.showInputDialog(null,"""
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
                                                    """+admin.MostrarPreciosCombos()));
                                                    if (menuCombos!=2 && menuCombos!=3 && menuCombos!=1) {
                                                        JOptionPane.showMessageDialog(null, "Por favor ingrese un numero valido que este entre las opciones");
                                                    }else{
                                                        verificacion4=true;
                                                    }
                                                } catch (Exception e) {
                                                    JOptionPane.showMessageDialog(null, "Datos erroneo, por favor ingresar dato valido");
                                                }
                                            }while(!verificacion4);
                                            // el metodo MostrarPreciosCombod muestra los precios atravez de un metodo que los regresa, este metodo fue creado con el fin de que en caso de que el administrador
                                            // cambie los precios estos se muestren actualizados en el menu   
                                            //Aqui le pregunta al usuario si esta seguro de la eleccion y en caso de que no este seguro con el Do while lo regresa al menu de combos
                                            ConfirmacionEleccion=JOptionPane.showConfirmDialog(null, "Esta seguro de la eleccion de combo(Si) o prefiere regresar al menu de combos(No)","Confirmacion",JOptionPane.YES_NO_OPTION    );
                                            if (ConfirmacionEleccion==JOptionPane.NO_OPTION) {
                                                verificacion4=false;
                                            }
                                        }while (ConfirmacionEleccion!=JOptionPane.YES_OPTION); 
                                        JOptionPane.showMessageDialog(null,(admin.AdquirirCombo(menuCombos,CedulaCliente)));
                                        contadorcombos++;
                                    }else{
                                        JOptionPane.showMessageDialog(null,("ya ha seleccionado un combo"));
                                    }
                                break;
                                case 2:
                                    boolean verificacion5=false;
                                    byte menuServicios=0;
                                    //el do es para regresar al usuario almenu de servicios en caso de que introduzca una opcion no valida
                                    do{ 
                                        try {
                                            menuServicios=Byte.parseByte(JOptionPane.showInputDialog("""
                                            Bienvenido al menu de servicios adicionales o individuales
                                                    Presione (1) para adquirir el servicio de sonido para conferencias
                                                    Presione (2) para adquirir el servicio de luces 
                                                    Presione (3) para adquirir el servicio de microfono 
                                                    Presione (4) para adquirir el servicio de consola de audio 
                                                    Presione (5) para adquirir el servicio de video beam 5000 lumens + telon 
                                                    Presione (6) para adquirir el servicio de bola de espejos 
                                                    Presione (7) para adquirir el servicio de Ventury de papel+cañon Co2 (tres disparos) 
                                                    Presione (8) para adquirir el servicio de lanzallamas
                                                    Presione (9) para adquirir el servicio de DJ (el valor corresponde a una hora de servicio) 

                                            """+admin.MostrarPreciosServicios()));
                                            if (menuServicios!=1 && menuServicios!=2 && menuServicios!=3 && menuServicios!=4 
                                                && menuServicios!=5 && menuServicios!=6 && menuServicios!=7 && menuServicios!=8 && menuServicios!=9) {  
                                                    JOptionPane.showMessageDialog(null, "Por favor ingrese un numero que este entre las opciones"); 
                                            }else{
                                                verificacion5=true;
                                            }
                                        } catch (Exception e) {
                                            JOptionPane.showMessageDialog(null, "Dato erroneo, por favor ingresar un dato valido");
                                        }
                                    }while(!verificacion5);
                                    JOptionPane.showMessageDialog(null, admin.AdquirirServicio(menuServicios,CedulaCliente));
                                break;
                                case 3:
                                // se usa un metodo para mostrar el total del cliente hasta el momento
                                    JOptionPane.showMessageDialog(null,admin.MostrarTotalCliente(CedulaCliente));
                                break;
                                default:
                                break;
                            }
                            //pregunta que se hara al final de cada accion del menu de clientes para dejar a eleccion del usuario si quiere hacer otra accion y regresar al menu o finalizar la compra
                            menuRegreso=JOptionPane.showConfirmDialog(null, "Si quieres finalizar la compra presiona(Si) si quieres regresar al menu de cliente presiona(No)","Confirmacion de compra",JOptionPane.YES_NO_OPTION);
                            
                            }while (menuRegreso!=JOptionPane.YES_OPTION);
                        JOptionPane.showMessageDialog(null,admin.Mostrarfactura(CedulaCliente,contadorcombos));
                    break;
                    case 2:
                            int RegresarMenuContraseña=0;
                            byte MenuAdministrador=0;
                            int SalirMenuAdmin=0;
                            //do para regresar que el usuario vuelva a intentar ingresar la contraseña
                            do{ 
                                String Contraseña=JOptionPane.showInputDialog(null,"""
                                        Bienvenido al menu de Administrador
                                        Primero que todo queremos verificar si es un administrador
                                        A continuacion digite la contraseña:
                                        """);
                                if (admin.VerificarAdmin(Contraseña)) {
                                    JOptionPane.showMessageDialog(null, "Admin verificado");
                                    //do para que el usuario pueda voler al menu de admin
                                    do{ 
                                        try {
                                        MenuAdministrador=Byte.parseByte(JOptionPane.showInputDialog(null,"""
                                                Bienvenido al menu de Administrador
                                                Presiona (1) Si quieres observar la lista de clientes con sus datos
                                                Presiona (2) Si quieres cambiar el precio de un combo
                                                Presiona (3) Si quieres cambiar el precio de un servicio
                                                Presiona (4) Si quieres ver las ganancias del dia
                                                Presiona (5) para salir
                                                """));
                                        } catch (Exception e) {
                                            JOptionPane.showMessageDialog(null, "Dato erroneo, Porfavor ingresar dato valido");
                                        }
                                        switch (MenuAdministrador) {
                                            case 1:
                                                JOptionPane.showMessageDialog(null,admin.MostrarDatosClientes());
                                                break;
                                            case 2:
                                                boolean verificacion6=false;
                                                byte MenuCambiarPreciosCombos=0;
                                                double NuevoPrecioCombo=0;
                                                //do para que el usuario introduzca una valor entre las opciones
                                                do{ 
                                                    try {
                                                         MenuCambiarPreciosCombos=Byte.parseByte(JOptionPane.showInputDialog(null, admin.MostrarPreciosCombos()+"\n \n Presione 1 si quiere cambiar el  precio del combo bronce \n Presione 2 si quiere cambiar el  precio del combo plata \n Presione 3 si quiere cambiar el  precio del combo oro"));
                                                         NuevoPrecioCombo=Double.parseDouble(JOptionPane.showInputDialog(null,"Escribe el nuevo valor que le quieres poner al combo"));
                                                        if (MenuCambiarPreciosCombos!=1 && MenuCambiarPreciosCombos!=2 && MenuCambiarPreciosCombos!=3 ) {
                                                            JOptionPane.showMessageDialog(null, "Por favor ingrese un numero que este entre las opciones");
                                                        }else{
                                                            verificacion6=true;
                                                        }
                                                    } catch (Exception e) {
                                                    JOptionPane.showMessageDialog(null, "Dato erroneo por favor ingresar dato valido");
                                                    }
                                                }while(!verificacion6);
                                                JOptionPane.showMessageDialog(null, admin.CambiarPrecioCombo(MenuCambiarPreciosCombos,NuevoPrecioCombo));
                                            break;
                                            case 3:
                                                boolean verificacion7=false;
                                                byte MenuCambiarPreciosServicios=0;
                                                double NuevoPrecioServicio=0;
                                                //DO para que el usuario introduzca un valor valido entre las opciones
                                                    do{ 
                                                        try {
                                                             MenuCambiarPreciosServicios=Byte.parseByte(JOptionPane.showInputDialog(null,admin.MostrarPreciosServicios()+"\n"+"""
                                                                Presione (1) para cambiar el costo del servicio de sonido para conferencias
                                                                Presione (2) para cambiar el costo del servicio de luces 
                                                                Presione (3) para cambiar el costo del  microfono 
                                                                Presione (4) para cambiar el costo del servicio de consola de audio 
                                                                Presione (5) para cambiar el costo del servicio de video beam 5000 lumens + telon 
                                                                Presione (6) para cambiar el costo del servicio de bola de espejos 
                                                                Presione (7) para cambiar el costo del servicio de Ventury de papel+cañon Co2 (tres disparos) 
                                                                Presione (8) para cambiar el costo del servicio de lanzallamas
                                                                Presione (9) para cambiar el costo del servicio de DJ (el valor corresponde a una hora de servicio)
                                                                    """));
                                                             NuevoPrecioServicio=Double.parseDouble(JOptionPane.showInputDialog(null,"Escribe el nuevo costo del servicio"));
                                                            if (MenuCambiarPreciosServicios!=1 && MenuCambiarPreciosServicios!=2 && MenuCambiarPreciosServicios!=3 && MenuCambiarPreciosServicios!=4
                                                            && MenuCambiarPreciosServicios!=5 && MenuCambiarPreciosServicios!=6 && MenuCambiarPreciosServicios!=7 && MenuCambiarPreciosServicios!=8 
                                                            && MenuCambiarPreciosServicios!=9) {
                                                                JOptionPane.showMessageDialog(null, "Por favor ingrese un numero que este entre las opciones");
                                                            }else{
                                                                verificacion7=true;
                                                            }
                                                        } catch (Exception e) {
                                                            JOptionPane.showMessageDialog(null,"Dato erroneo, por favor ingresar dato valido");
                                                        }
                                                    }while(!verificacion7);
                                                    JOptionPane.showMessageDialog(null,admin.CambiarPrecioServicio(MenuCambiarPreciosServicios,NuevoPrecioServicio));
                                            case 4:
                                                    JOptionPane.showMessageDialog(null, "Las ganacias totales del dia son:$"+admin.getgananciasdia());
                                            break;
                                            default:
                                                break;
                                        }
                                        SalirMenuAdmin=JOptionPane.showConfirmDialog(null,"Quieres regresar al menu de Admin o quieres salir del menú", "Confirmacion", JOptionPane.YES_NO_OPTION);
                                    }while(MenuAdministrador!=5 && SalirMenuAdmin==JOptionPane.YES_OPTION);
                                }else{
                                    RegresarMenuContraseña=JOptionPane.showConfirmDialog(null,"Contraseña incorrecta quieres volvero a intentar","confirmacion",JOptionPane.YES_NO_OPTION);
                                }
                            }while(RegresarMenuContraseña!=JOptionPane.NO_OPTION && SalirMenuAdmin==JOptionPane.YES_OPTION);
                    break;
            }
            // pregunta que se le hace el usuario para usar el do con el fin de finalizar el programa
            ConfirmacionMenuinicio=JOptionPane.showConfirmDialog(null, "Quieres volver al menu de inicio(Si) o quieres cerrar caja y finalizar el programa(No)","confirmacion menu inicio",JOptionPane.YES_NO_OPTION);
        }while(ConfirmacionMenuinicio!=JOptionPane.NO_OPTION);
        JOptionPane.showMessageDialog(null, "Las ganacias totales del dia fueron "+admin.getgananciasdia()+"\n Gracias por usar el programa");
    }
}