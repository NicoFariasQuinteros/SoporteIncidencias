import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ConexionDB {
    private static EntityManagerFactory entityManagerFactory;

    static {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("gestor");
        } catch (Throwable ex) {
            System.err.println("Error al inicializar la fábrica de entidades: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public static void closeEntityManager() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }
//****** cliente
public static void altaClienteDB(Cliente cli) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            // Validar que el cuit no exista antes de persistir el cliente
            // Implementa la lógica de validación aquí si es necesario

            entityManager.persist(cli);

            transaction.commit();
            System.out.println("Cliente agregado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al agregar cliente: " + e);
            if (transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            entityManager.close();
        }
    }

    /***** empleado */
	public static boolean validarCuitEmpleado(String cuitEmp) {
        EntityManager entityManager = getEntityManager();
        try {
            TypedQuery<Empleado> query = entityManager.createQuery("SELECT e FROM Empleado e WHERE e.cuitEmpleado = :cuit", Empleado.class);
            query.setParameter("cuit", cuitEmp);
            return query.getResultList() != null;
        } catch (Exception e) {
            System.out.println("Error al validar el CUIT del empleado: " + e);
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return false;
    }

	public static int buscarEmpleadoPorCuit(String cuit) {
        EntityManager entityManager = getEntityManager();
        int id=0;
        try {
            TypedQuery<Empleado> query = entityManager.createQuery("SELECT e FROM Empleado e WHERE e.cuitEmpleado = TRIM(:cuit)", Empleado.class);
            query.setParameter("cuit", cuit);
            System.out.println(cuit);

            List<Empleado> results = query.getResultList();
            if (!results.isEmpty()) {
                Empleado empleado = results.get(0);
                // Imprimir los datos del empleado
                System.out.println("Datos del Empleado con CUIT " + cuit + ":");
                System.out.println("ID: " + empleado.getIdEmpleado());
                System.out.println("Nombre: " + empleado.getNomEmpleado());
                System.out.println("Apellido: " + empleado.getApeEmpleado());
                System.out.println("Dirección: " + empleado.getDireEmpleado());
                System.out.println("Teléfono: " + empleado.getCelEmpleado());
                System.out.println("Correo: " + empleado.getMailEmpleado());
                System.out.println("Alta Empleado: " + empleado.getAltaEmpleado());
                System.out.println("Área: " + empleado.getAreaEmpleado());
                id = empleado.getIdEmpleado();
            } else {
                System.out.println("No se encontró ningún empleado con el CUIT: " + cuit);
            }
        } catch (Exception e) {
            System.out.println("Error al buscar empleado por CUIT: " + e);
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return id;
    }

    public static void altaEmpleadoDB(Empleado emp1) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(emp1);
            transaction.commit();
            System.out.println("La DB/TABLA EMPLEADO se actualizó con éxito");
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Error en el insert de la tabla Empleado: " + e);
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public static List<Empleado> listarEmpleado() {
        EntityManager entityManager = getEntityManager();
        List<Empleado> empleados = null;
        try {
            TypedQuery<Empleado> query = entityManager.createQuery("SELECT e FROM Empleado e", Empleado.class);
            empleados = query.getResultList();
            // Imprimir los empleados obtenidos
            imprimirEmpleados(empleados);
        } catch (Exception e) {
            System.out.println("Error en la consulta de empleados: " + e);
            e.printStackTrace();
        } finally {
            entityManager.close();
            Menu.menuPrincipal();
        }
        return empleados;
    }
    public static void actualizarEmpleado(Empleado empleado) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
    
        try {
            transaction.begin();
            entityManager.merge(empleado);
            transaction.commit();
            System.out.println("ACTIALIZACION EXITOSA");
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public static void eliminarEmpleado(int empleadoId) {


        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
    
        try {
            transaction.begin();
            Empleado empleado = entityManager.find(Empleado.class, empleadoId);
            if (empleado != null) {
                entityManager.remove(empleado);
                System.out.println("BORRADO EXiTOSO");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }


    public Empleado obtenerEmpleadoPorId(int empleadoId) {
        EntityManager entityManager = getEntityManager();
        Empleado empleado = null;
    
        try {
            empleado = entityManager.find(Empleado.class, empleadoId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    
        return empleado;
    }
    
/***** Tecnico */
    public static void altaTecnicoDB(Tecnico tec1) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(tec1);
            transaction.commit();
            System.out.println("La DB/TABLA TECNICO se actualizó con éxito");
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Error en el insert de la tabla Técnico: " + e);
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public static List<Tecnico> listarTecnicos() {
        EntityManager entityManager = getEntityManager();
        List<Tecnico> tecnicos = null;
        try {
            TypedQuery<Tecnico> query = entityManager.createQuery("SELECT t FROM Tecnico t", Tecnico.class);
            tecnicos = query.getResultList();
            // Imprimir los técnicos obtenidos
            imprimirTecnicos(tecnicos);
        } catch (Exception e) {
            System.out.println("Error en la consulta de técnicos: " + e);
            e.printStackTrace();
        } finally {
            entityManager.close();
            Menu.menuPrincipal();
        }
        return tecnicos;
    }

    private static void imprimirEmpleados(List<Empleado> empleados) {
        System.out.println("---------------------------------------------------------------");
        System.out.printf("| %-5s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |\n",
                "ID", "Nombre", "Apellido", "Dirección", "Teléfono", "Correo", "Alta Empleado", "Área");
        System.out.println("---------------------------------------------------------------");

        for (Empleado empleado : empleados) {
            System.out.printf("| %-5d | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |\n",
                    empleado.getIdEmpleado(), empleado.getNomEmpleado(), empleado.getApeEmpleado(),
                    empleado.getDireEmpleado(), empleado.getCelEmpleado(), empleado.getMailEmpleado(),
                    empleado.getAltaEmpleado(), empleado.getAreaEmpleado());
        }

        System.out.println("---------------------------------------------------------------");
    }

    private static void imprimirTecnicos(List<Tecnico> tecnicos) {
        System.out.println("---------------------------------------------------------------");
        System.out.printf("| %-5s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |\n",
                "ID", "Cuit Empleado", "Cod Soporte", "Titulo Técnico", "Disponibilidad", "Alta Técnico", "Estado Técnico");
        System.out.println("---------------------------------------------------------------");

        for (Tecnico tecnico : tecnicos) {
            System.out.printf("| %-5d | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |\n",
                    tecnico.getIdTecnico(), tecnico.getCuitEmpleado(), tecnico.getCodSoporte(),
                    tecnico.getTituloTecnico(), tecnico.getDispoTecnico(), tecnico.getAltaTecnico(),
                    tecnico.getEstadoTecnico());
        }

        System.out.println("---------------------------------------------------------------");
    }

	public static void altaSoporteDB(SoporteServicio sop1) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(sop1);
            transaction.commit();
            System.out.println("La DB/TABLA SOPORTE se actualizó con éxito");
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Error en el insert de la tabla SOPORTE: " + e);
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public static List<SoporteServicio> listarSoporte() {
        EntityManager entityManager = getEntityManager();
        List<SoporteServicio> soportes = null;
        try {
            TypedQuery<SoporteServicio> query = entityManager.createQuery("SELECT s FROM SoporteServicio s", SoporteServicio.class);
            soportes = query.getResultList();
            // Imprimir los soportes obtenidos
            imprimirSoportes(soportes);
        } catch (Exception e) {
            System.out.println("Error en la consulta de soportes: " + e);
            e.printStackTrace();
        } finally {
            entityManager.close();
            Menu.menuPrincipal();
        }
        return soportes;
    }

    public static void altaIncidenteDB(Incidente inc1) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(inc1);
            transaction.commit();
            System.out.println("La DB/TABLA INCIDENTE se actualizó con éxito");
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Error en el insert de la tabla Incidente: " + e);
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
	private static void imprimirSoportes(List<SoporteServicio> soportes) {
		System.out.println("---------------------------------------------------------------");
		System.out.printf("| %-5s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |\n",
				"ID", "Cod Soporte", "Tipo Soporte", "Descripción", "Alta Soporte", "Tmp Resp Soporte", "Complejidad", "Estado");
		System.out.println("---------------------------------------------------------------");
	
		for (SoporteServicio soporte : soportes) {
			System.out.printf("| %-5d | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |\n",
					soporte.getIdSoporte(), soporte.getCodSoporte(), soporte.getTipoSoporte(),
					soporte.getDesSoporte(), soporte.getAltaSoporte(), soporte.getTmpRespSoporte(),
					soporte.getComplejidadSoporte(), soporte.getEstadoSoporte());
		}
	
		System.out.println("---------------------------------------------------------------");
	}
	
	// Resto de los métodos de altaEmpleadoDB, altaTecnicoDB, etc., siguen un enfoque similar.
}


