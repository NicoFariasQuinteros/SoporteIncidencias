import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static void menuPrincipal(){
        int opcion;
        Scanner opcion_menu = new Scanner(System.in);

        do {
            System.out.println("******* Menu *******");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Registro Empleados");
            System.out.println("2. Registrar Cliente");
            System.out.println("3. Registrar Incidente");
            System.out.println("4. Listado de Técnicos");
            System.out.println("5. Salir");
            System.out.print("Opcion seleccionada: ");
            opcion = opcion_menu.nextInt();
            switch (opcion) {
                case 1:
                    subMenuEmpleados();
                    break;
                case 2:
                    Cliente cli1 = Cliente.altaCliente();
                    ConexionDB.altaClienteDB(cli1);
                case 3:
                    SoporteServicio sop1 = SoporteServicio.altaSoporte();
                    ConexionDB.altaSoporteDB(sop1);
                case 4:
                    //*******Instancia un cliente nvo
                    //lista de los soportes para que el cliente elija
                    ConexionDB.listarSoporte();

            }
        } while (opcion > 5 || opcion < 1);
    }

    public static void subMenuEmpleados() {

        int opciones_empleados = 0;
        Scanner opcion_menu_empleados = new Scanner(System.in);
        boolean bandera = false;
        do {
            do {
                try {
                    System.out.println("");
                    System.out.println("1. Registrar empleado");
                    System.out.println("2. Ver lista de empleados");
                    System.out.println("3. Registrar técnico");
                    System.out.println("4. Regresar menu principal");
                    System.out.print("Indique la opcion: ");
                    opciones_empleados = opcion_menu_empleados.nextInt();
                } catch (InputMismatchException e) {
                    bandera = true;
                    opcion_menu_empleados.nextLine();
                    System.out.println("Opcion no valida o inexistente");
                    System.out.println("Por favor ingrese una opcion nuevamente");
                }
            }while(bandera == true);
            switch (opciones_empleados) {
                case 1:
                    Empleado emp1 = Empleado.altaEmpleado();
                    ConexionDB.altaEmpleadoDB(emp1);
                    break;
                case 2:
                    ConexionDB.listarEmpleado();
                    break;
                case 3:
                    Tecnico tec1 = Tecnico.altaTecnico();
                    break;
                case 4:
                    menuPrincipal();
                    break;
                default:
                    System.out.println("Opción no valida o inexistente");
            }
        } while (opciones_empleados != 4) ;
    }
}

//**hacer un menu con opciones para: ABM cliente -- Repotar  Incidente--listar técnicos - salir
//en un bucle que me permita seguier ejecutando hasta que seleccione salir/terminar
//cada llamado funciona bien por separado, cuando se ejecuta todo junto sa un error en Scanner
//veamos si se soluciona con el menu

//*******Instancia un empleado nvo
/*Empleado emp1 = Empleado.altaEmpleado();
ConexionDB.altaEmpleadoDB(emp1);*/


//*******Instancia un soporte nvo //
/*SoporteServicio sop1 = SoporteServicio.altaSoporte();
ConexionDB.altaSoporteDB(sop1);*/


//*******Instancia un tecnico nvo
//*******LISTA LOS EMPLEADOS


//*******BUSCA EMPELADO POR CUIT
//ConexionDB.buscarEmpleado();


//  ConexionDB.altaTecnicoDB(tec1);

/*//*******Instancia un incidente nvo
Incidente inc1 = Incidente.altaIncidente();
ConexionDB.altaIncidenteDB(inc1);*/