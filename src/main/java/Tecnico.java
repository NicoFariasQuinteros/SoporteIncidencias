import java.time.LocalDate;
import java.util.Scanner;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tecnico")
public class Tecnico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTecnico;
	private String cuitEmpleado;
	private String codSoporte;
	private String tituloTecnico;
	private String dispoTecnico;//disponibilidad del tecnico, hs turno , etc
	private final LocalDate altaTecnico = LocalDate.now();
	private String estadoTecnico;

	//@OneToMany(mappedBy = "tecnico")
    //private List<Incidente> incidentes;


public static Tecnico altaTecnico(){
		try (Scanner entrada = new Scanner(System.in)) {
			System.out.println();
			boolean valida= true;
			String cuitEmp="";
			
			System.out.println("*****INGRESE LOS SIGUIENTES DATOS DEL TECNICO*****");
			System.out.println("***********RESPETANDO LAS INDICACIONES*************");		

			while (valida) {
				System.out.println("CUIT de OPERADOR: ");
				cuitEmp = entrada.nextLine();	
			
				boolean existeEmpleado= ConexionDB.validarCuitEmpleado(cuitEmp);
				if (!existeEmpleado) {
					System.out.println("El OPERADOR no está dado de alta");
				    valida = true;
			       }
				else
					valida = false;
			}
			
			System.out.println("CODIGO deL Soporte/Servicio (10 caract. max.): ");
			String codSopo = entrada.nextLine();
			System.out.println("TITULO/PROFESION/OFICIO: ");
			String titulo = entrada.nextLine();
			System.out.println("DISPONIBILIDAD 	horaria (FULL TIME/PART TIME): ");
			String disponibilidad = entrada.nextLine();
			System.out.println("ESTADO activo/inactivo: ");
			String estado = entrada.nextLine();
			
			
			Tecnico tec1 = new Tecnico(cuitEmp,codSopo,titulo,disponibilidad,estado);
				
			//System.out.println(tec1.toString());

			entrada.close();
			return tec1;
		}
	 	
	 }

public Tecnico(String cuitEmp, String codSopo, String titulo, String disponibilidad, String estado) {
	cuitEmpleado = cuitEmp;
	codSoporte = codSopo;
	tituloTecnico = titulo;
	dispoTecnico = disponibilidad;
	estadoTecnico = estado;
}

	
	
}
