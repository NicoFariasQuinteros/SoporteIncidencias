import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static void menuPrincipal(){
        String opcion;
        Scanner opcion_menu = new Scanner(System.in);
        
        do {
            System.out.println("******* Menu *******");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Registro Empleados");
            System.out.println("2. Registrar Cliente");
            System.out.println("3. Registrar Incidente");
            System.out.println("4. Listado de Técnicos");
            System.out.println("5. Salir");
            System.out.print("Opcion seleccionada: \n\n");
            opcion = opcion_menu.nextLine();
           
            switch (opcion) {
                case "1":
                    subMenuEmpleados();
                    if (!opcion_menu.hasNextLine()) {
                    opcion_menu.nextLine();
                   }
                    break;
                case "2":
                    Cliente cli1 = Cliente.altaCliente();
                    ConexionDB.altaClienteDB(cli1);
                    break;
                case "3":
                    SoporteServicio sop1 = SoporteServicio.altaSoporte();
                    ConexionDB.altaSoporteDB(sop1);
                    break;
                case "4":
                    
                    ConexionDB.listarTecnicos();
                    break;
                default:
                    System.out.println("Opción no valida o inexistente");
                
            }
        } while (!opcion.equals("5"));
        opcion_menu.close();
    }
    public static void subMenuEmpleados() {

        String opciones_empleados = "0";
        
        
        try (Scanner opcion_menu_empleados = new Scanner(System.in)){
        	do {
                System.out.println("");
                System.out.println("1. Registrar empleado");
                System.out.println("2. Ver lista de empleados");
                System.out.println("3. Buscar empleado por CUIT");
                System.out.println("4. Registrar técnico");
                System.out.println("5. Eliminar empleado");
                System.out.println("6. Actualizar empleado");

                System.out.println("7. volver");
                System.out.print("Indique la opcion: ");
                opciones_empleados = opcion_menu_empleados.nextLine();
                
                switch (opciones_empleados) {
                    case "1":
                        Empleado emp1 = Empleado.altaEmpleado();
                        ConexionDB.altaEmpleadoDB(emp1);
                        break;
                    case "2":
                        ConexionDB.listarEmpleado();
                        break;
                    case "3":
                        System.out.print("Ingrese el CUIT del empleado a buscar: ");
                        String cuitBusqueda = opcion_menu_empleados.nextLine();
                        //System.out.println(cuitBusqueda);
                        ConexionDB.buscarEmpleadoPorCuit(cuitBusqueda);
                        break;
                    case "4":
                        Tecnico tec1 = Tecnico.altaTecnico();
                        ConexionDB.altaTecnicoDB(tec1);
                        break;
                    case "5":
                        System.out.print("Ingrese el CUIT del empleado a buscar: ");
                        String cuit = opcion_menu_empleados.nextLine();
                        int id = ConexionDB.buscarEmpleadoPorCuit(cuit);
                        ConexionDB.eliminarEmpleado(id);  
                        break;
                    case "6":
                        System.out.print("Ingrese el CUIT del empleado a buscar: ");
                        String cuitE = opcion_menu_empleados.nextLine();
                        int idE = ConexionDB.buscarEmpleadoPorCuit(cuitE);
                        Empleado emp2 = Empleado.altaEmpleado();
                        emp2.setIdEmpleado(idE);
                        ConexionDB.actualizarEmpleado(emp2);  
                        break;
                    case "7":
                        break;
                    default:
                    System.out.println("Opción no valida o inexistente");
                    }
                
                   } while (!opciones_empleados.equals("7")) ;
                   if (!opcion_menu_empleados.hasNextLine()) {
                    opcion_menu_empleados.nextLine();
                   }
                   opcion_menu_empleados.close();
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, ingrese un número correspondiente a una opción.");
                }
            
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