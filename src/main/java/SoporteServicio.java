import java.time.LocalDate;
import java.util.Scanner;
import javax.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) //define private a todos los atributos
@Entity
@Table(name="soporte")
public class SoporteServicio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idSoporte;
	String codSoporte;
	String tipoSoporte;//hard soft etc
	String desSoporte;
	final LocalDate altaSoporte=LocalDate.now();
	String tmpRespSoporte;
	String complejidadSoporte;
	String estadoSoporte;//activo / inactivo

	//@OneToMany(mappedBy = "soporte")
    //private List<Incidente> incidentes;
		
public static SoporteServicio altaSoporte(){
	
	///AGREGAR VALIDACION DE INGRESO DE DATOS COMO EN EMPLEADOS
	
	try (Scanner entrada1 = new Scanner(System.in)) {
		System.out.println("");
		System.out.println("*****INGRESE LOS SIGUIENTES DATOS DEL SOPORTE/SERVICIO*****");
		System.out.println("**************RESPETANDO LAS INDICACIONES**************");
		System.out.println("CODIGO (10 caract max): ");
		String codSoporte = entrada1.nextLine();
		System.out.println("TIPO SOFT/HARD: ");
		String tipo = entrada1.nextLine();
		System.out.println("DESCRIPCION: ");
		String descripcion = entrada1.nextLine();
		System.out.println("COMPLEJIDAD ALTA/MEDIA/BAJA: ");
		String complejidad = entrada1.nextLine();
		System.out.println("TIEMPO DE RESOLUCION en horas: ");
		String tiempoReso = entrada1.nextLine();
		System.out.println("ESTADO DISPONIBLE/NO DISPONIBLE: ");
		String estado = entrada1.nextLine();
		
		//-----------ESTA LINEA HAY QUE ELIMINAR, SOLO ESTÁ PARA CONTROL EN DESARROLLO
		SoporteServicio sop1 = new SoporteServicio(codSoporte,tipo,descripcion,tiempoReso,complejidad,estado);
			
		//System.out.println(sop1.toString());

		entrada1.close();
		return sop1;
	}
}

public SoporteServicio(String codSoporte2, String tipo, String descripcion, String tiempoReso, String complejidad,
		String estado) {
	codSoporte = codSoporte2;
	tipoSoporte = tipo;
	desSoporte = descripcion;
	tmpRespSoporte = tiempoReso;
	complejidadSoporte = complejidad;
	estadoSoporte = estado;
}


}